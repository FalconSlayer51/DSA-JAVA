package leetcode_daily;

public class MaximumAbsSum {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int maxSubArraySum = findMaxSubArraySum(nums);
        int minSubArraySum = findMinSubArraySum(nums);

        return Math.max(maxSubArraySum, Math.abs(minSubArraySum));
    }

    private int findMaxSubArraySum(int[] nums) {
        int n = nums.length;
        int currMax = nums[0];
        int maxOverAll = nums[0];

        for (int i = 1; i < n; i++) {
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxOverAll = Math.max(maxOverAll, currMax);
        }

        return maxOverAll;
    }

    private int findMinSubArraySum(int[] nums) {
        int n = nums.length;
        int currMin = nums[0];
        int minOverAll = nums[0];

        for (int i = 1; i < n; i++) {
            currMin = Math.min(nums[i], currMin + nums[i]);
            minOverAll = Math.min(minOverAll, currMin);
        }

        return minOverAll;
    }
}
