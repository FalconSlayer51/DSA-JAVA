package leetcode_daily;

import java.util.Arrays;

public class LongestNiceSubarray {
    public int longestNiceSubarray(int[] nums) {
        int result = 1;
        int n = nums.length;

        int start = 0;
        int end = 0;
        int used = 0;
        while (end < n) {
            while ((used & nums[end]) != 0) {
                used ^= nums[start++];
            }
            used |= nums[end];
            result = Math.max(result,end - start +1);
            end ++;
        }

        return result;
    }


    public static void main(String[] args) {
        LongestNiceSubarray solution = new LongestNiceSubarray();

        // Test case 1
        int[] nums1 = {1, 3, 8, 48, 10};
        int result1 = solution.longestNiceSubarray(nums1);
        System.out.println("Test case 1: " + (result1 == 3 ? "Passed" : "Failed"));

        // Test case 2
        int[] nums2 = {3, 1, 5, 11, 13};
        int result2 = solution.longestNiceSubarray(nums2);
        System.out.println("Test case 2: " + (result2 == 1 ? "Passed" : "Failed"));
    }
}
