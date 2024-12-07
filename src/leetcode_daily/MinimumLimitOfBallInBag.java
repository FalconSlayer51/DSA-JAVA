package leetcode_daily;


public class MinimumLimitOfBallInBag {
    public int minimumSize(int[] nums, int maxOperations) {
        int start = 1;
        int end = 0;

        for(int num: nums) {
            end = Math.max(end,num);
        }

        int ans = 0;
        while (start < end) {
            int mid = start + (end - start)/2;
            if (isPossible(nums,mid,maxOperations)) {
                ans = mid;
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    private boolean isPossible(int[] nums,int maxBallsInBag, int maxOperations) {
        int totalOperations = 0;
        for (int num: nums) {
            int operations = (int) Math.ceil(num/(double)maxBallsInBag) - 1;
            totalOperations += operations;

            if (totalOperations > maxOperations) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MinimumLimitOfBallInBag solution = new MinimumLimitOfBallInBag();

        int[] nums1 = {9};
        int maxOperations1 = 2;
        System.out.println(solution.minimumSize(nums1, maxOperations1)); // Expected output: 3

        int[] nums2 = {2, 4, 8, 2};
        int maxOperations2 = 4;
        System.out.println(solution.minimumSize(nums2, maxOperations2)); // Expected output: 2
    }
}
