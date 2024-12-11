package leetcode_daily;

import java.util.Arrays;

public class MaximumBeautyOfArray {
    public int maxBeauty(int[] nums,int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxLength = 0;
        int right = 0;

        for(int left = 0; left < n; left++) {
            while (right < n && nums[right] - nums[left] <= 2*k) {
                right++;
            }
            maxLength = Math.max(maxLength,right - left);
        }

        return maxLength;
    }

    public int maxBeauty2(int[] nums,int k) {
        if (nums.length == 1) return 1;
        int max = 0;
        for (int num : nums) {
            max = Math.max(num,max);
        }

        int[] count = new int[max+1];
        for(int num: nums) {
            count[Math.max(num-k,0)]++;
            count[Math.min(num+k+1,max)]--;
        }

        int curSum = 0;
        int maxSum = 0;

        for (int c : count) {
            curSum += c;
            maxSum = Math.max(maxSum,curSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumBeautyOfArray solution = new MaximumBeautyOfArray();

        // Example 1
        int[] nums1 = {4, 6, 1, 2};
        int k1 = 2;
        System.out.println(solution.maxBeauty2(nums1, k1)); // Expected output: 3

        // Example 2
        int[] nums2 = {1, 1, 1, 1};
        int k2 = 10;
        System.out.println(solution.maxBeauty2(nums2, k2)); // Expected output: 4
    }
}
