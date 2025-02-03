package leetcode_daily;

public class LongestIncreasingOrDecreasing {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        if (isSortedIncreasing(nums, 0, n) || isSortedDecreasing(nums, 0, n)) {
            return nums.length;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (isSortedIncreasing(nums, i, j) || isSortedDecreasing(nums, i, j)) {
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }

        return maxLen;
    }

    private boolean isSortedIncreasing(int[] nums, int start, int end) {
        for (int i = start + 1; i < end; i++) {
            if (nums[i - 1] >= nums[i]) return false;
        }
        return true;
    }


    private boolean isSortedDecreasing(int[] nums, int start, int end) {
        for (int i = start + 1; i < end; i++) {
            if (nums[i - 1] <= nums[i]) return false;
        }
        return true;
    }
}
