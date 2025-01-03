package leetcode_daily;

import java.util.Arrays;

public class NumberOfWaysToSplitArray {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        long sum = prefixSum[n - 1];

        System.out.println("Prefix sum: " + Arrays.toString(prefixSum));
        System.out.println("Sum: " + sum);

        int count = 0;
        for (int i = 0; i < n-1; i++) {
            long sumUptoI = prefixSum[i];
            long sumItoN = sum - sumUptoI;

            if (sumUptoI >= sumItoN) {
                System.out.println(sumUptoI+","+sumItoN);
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 4, -8, 7};
        int[] nums2 = {2, 3, 1, 0};

        NumberOfWaysToSplitArray solution = new NumberOfWaysToSplitArray();

        System.out.println("Output: " + solution.waysToSplitArray(nums1)); // Output: 2
        System.out.println("Output: " + solution.waysToSplitArray(nums2)); // Output: 2
    }
}
