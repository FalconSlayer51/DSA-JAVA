package leetcode_daily;

import java.util.HashMap;

public class CountBadPairs {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long validPairs = 0;
        long totalPairs = ((long) n * (n - 1)) / 2;
        HashMap<Integer, Integer> numToCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            numToCount.put(nums[i] - i, numToCount.getOrDefault(nums[i] - i, 0) + 1);
        }
        for (var value : numToCount.values()) {
            if (value > 1) {
                validPairs += ((long) value * (value - 1)) / 2;
            }
        }

        return totalPairs - validPairs;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 3, 3};
        System.out.println(new CountBadPairs().countBadPairs(nums1)); // Output: 5

        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println(new CountBadPairs().countBadPairs(nums2)); // Output: 0
    }
}
