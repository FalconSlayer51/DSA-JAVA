package leetcode_daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumOfNonOverlappingSubarrays {
    private int[][] dp = new int[20001][4];
    private int helper(int[] sums, int k, int idx, int rem) {
        if (rem == 0) return 0;
        if (idx >= sums.length) return Integer.MIN_VALUE;

        if (dp[idx][rem] != -1) {
            return dp[idx][rem];
        }

        int take = sums[idx] + helper(sums, k, idx + k, rem - 1);
        int notTake = helper(sums, k, idx + 1, rem);

        dp[idx][rem] = Math.max(take, notTake);
        return dp[idx][rem];
    }

    private void solve(int[] sums, int k, int idx, int rem, List<Integer> indices) {
        if (rem == 0 || idx >= sums.length) return;

        int take = sums[idx] + helper(sums, k, idx + k, rem - 1);
        int notTake = helper(sums, k, idx + 1, rem);

        if (take >= notTake) {
            indices.add(idx);
            solve(sums, k, idx + k, rem - 1, indices);
        } else {
            solve(sums, k, idx + 1, rem, indices);
        }
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // Initialize the memoization array with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int n = nums.length - k + 1;
        int[] sums = new int[n];
        int windowSum = 0;
        int i = 0, j = 0;

        // Calculate window sums
        while (j < nums.length) {
            windowSum += nums[j];

            if (j - i + 1 == k) {
                sums[i] = windowSum;
                windowSum -= nums[i];
                i++;
            }
            j++;
        }

        List<Integer> indices = new ArrayList<>();
        solve(sums, k, 0, 3, indices);

        return indices.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        MaxSumOfNonOverlappingSubarrays solution = new MaxSumOfNonOverlappingSubarrays();

        // Test case 1
        int[] nums1 = {1, 2, 1, 2, 6, 7, 5, 1};
        int k1 = 2;
        int[] result1 = solution.maxSumOfThreeSubarrays(nums1, k1);
        System.out.println("Test case 1: " + Arrays.toString(result1)); // Expected output: [0, 3, 5]

        // Test case 2
        int[] nums2 = {1, 2, 1, 2, 1, 2, 1, 2, 1};
        int k2 = 2;
        int[] result2 = solution.maxSumOfThreeSubarrays(nums2, k2);
        System.out.println("Test case 2: " + Arrays.toString(result2)); // Expected output: [0, 2, 4]
    }
}
