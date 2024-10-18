package leetcode_daily;

public class CountNoOfBitWiseOr {
    public static int countMaxOrSubsets(int[] nums) {
        if (nums.length == 0) return 0;
        int targetOr = 0;
        for(int num: nums) {
            targetOr |= num;
        }

        Integer[][] dp = new Integer[nums.length][targetOr+1];

        return recur(nums,0,targetOr,0,dp);
    }

    private static int recur(int[] nums,int index,int targetOr,int currentOr,Integer[][] dp) {
        if(index == nums.length) {
            return (currentOr == targetOr) ? 1 : 0;
        }

        if (dp[index][currentOr] != null) {
            return dp[index][currentOr];
        }

        int pick = recur(nums,index+1,targetOr,currentOr|nums[index],dp);
        int noPick = recur(nums,index+1,targetOr,currentOr,dp);

        dp[index][currentOr] = pick+noPick;

        return dp[index][currentOr];
    }

    public static void main(String[] args) {
        // Test case 1: Example case
        int[] nums1 = {1, 2, 3};
        System.out.println(countMaxOrSubsets(nums1)); // Expected output: (depends on the implementation)

        // Test case 2: All elements are the same
        int[] nums2 = {1, 1, 1};
        System.out.println(countMaxOrSubsets(nums2)); // Expected output: (depends on the implementation)

        // Test case 3: Single element
        int[] nums3 = {4};
        System.out.println(countMaxOrSubsets(nums3)); // Expected output: 1

        // Test case 4: No elements
        int[] nums4 = {};
        System.out.println(countMaxOrSubsets(nums4)); // Expected output: 0

        // Test case 5: Larger array
        int[] nums5 = {1, 2, 4, 8};
        System.out.println(countMaxOrSubsets(nums5)); // Expected output: (depends on
    }
}
