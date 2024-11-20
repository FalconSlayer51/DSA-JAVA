package leetcode_daily;

import java.util.Arrays;

public class CountNoOfFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);
        long count = 0;
        for (int i = 0; i < n; i++) {
            int leftIdx = lowerBound(nums,i+1,n,lower-nums[i]);
            int rightIdx = upperBound(nums,i+1,n,upper-nums[i]);

            int x = leftIdx - i -1;
            int y = rightIdx - i - 1;

            count += (y-x);
        }

        return count;
    }

    private int lowerBound(int[] nums,int start,int end,int target) {
        while (start < end) {
            int mid = start + (end - start) /2 ;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }


    private int upperBound(int[] nums,int start,int end,int target) {
        while (start < end) {
            int mid = start + (end - start) /2 ;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        CountNoOfFairPairs obj = new CountNoOfFairPairs();

        // Test case 1
        int[] nums1 = {0, 1, 7, 4, 4, 5};
        int lower1 = 3;
        int upper1 = 6;
        System.out.println(obj.countFairPairs(nums1, lower1, upper1)); // Output: 6

        // Test case 2
        int[] nums2 = {1, 7, 9, 2, 5};
        int lower2 = 11;
        int upper2 = 11;
        System.out.println(obj.countFairPairs(nums2, lower2, upper2)); // Output: 1
    }
}
