package leetcode_daily;

public class TargetSum {

    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        solve(nums,target,0,0);
        return count;
    }

    public void solve(int[] nums,int target,int sum,int index) {
        if (sum == target && index == nums.length) {
            count ++;
        }

        if (index == nums.length) {
            return;
        }

        solve(nums,target,sum-nums[index],index+1);
        solve(nums,target,sum+nums[index],index+1);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 1, 1};
        int target1 = 3;
        System.out.println(new TargetSum().findTargetSumWays(nums1, target1)); // Output: 5

        int[] nums2 = {100,100};
        int target2 = 0;
        System.out.println(new TargetSum().findTargetSumWays(nums2, target2)); // Output: 1
    }
}
