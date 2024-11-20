package leetcode_daily;

import java.util.HashMap;

public class MaximumSumOfDistinctSubarrays {
    public long maximumSubarraySum(int[] nums,int k) {
        int n = nums.length;
        int start = 0;
        int end = 0;
        long sum = 0;
        long result = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        while (end < n) {
            int lastOccurrence = map.getOrDefault(nums[end],-1);

            while (start<=lastOccurrence||(end-start + 1) > k) {
                sum -= nums[start];
                start++;
            }

            sum += nums[end];
            map.put(nums[end],end);

            if (end-start + 1 == k) {
                result = Math.max(result,sum);
            }
            end++;
        }

        return result;
    }
    public static void main(String[] args) {
        MaximumSumOfDistinctSubarrays maximumSumOfDistinctSubarrays = new MaximumSumOfDistinctSubarrays();

        int[] nums1 = {1, 5, 4, 2, 9, 9, 9};
        int k1 = 3;
        System.out.println(maximumSumOfDistinctSubarrays.maximumSubarraySum(nums1, k1)); // Output: 15

        int[] nums2 = {4, 4, 4};
        int k2 = 3;
        System.out.println(maximumSumOfDistinctSubarrays.maximumSubarraySum(nums2, k2)); // Output: 0
    }
}
