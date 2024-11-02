package leetcode_daily;

import java.util.HashSet;

public class LongestSquareStreakInAnArray {
    public static int longestSquareStreak(int[] nums) {
        HashSet<Long> set = new HashSet<>();
        for (int num: nums) {
            set.add(num*1l);
        }

        int max = -1;
        for(int i = 0;i< nums.length ;i++) {
            int count = 1;
            int num = nums[i];
            while (set.contains(num*1l * num*1l)) {
                count ++;
                num = num * num;
                max = Math.max(max,count);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSquareStreak(new int[]{4, 3, 6, 16, 8, 2})); // Output: 3
        System.out.println(longestSquareStreak(new int[]{2, 3, 5, 6, 7})); // Output: -1
    }
}
