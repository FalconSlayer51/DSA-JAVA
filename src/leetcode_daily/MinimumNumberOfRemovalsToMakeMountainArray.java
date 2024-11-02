package leetcode_daily;

import java.util.Arrays;

public class MinimumNumberOfRemovalsToMakeMountainArray {
    public static int minimumMountainRemovals(int[] nums) {
        int n = nums.length;

        int[] lis = new int[n];
        Arrays.fill(lis,1);

        for (int i = 0; i < n; i++) {
            for (int j =0;j<i;j++) {
                if (nums[j]<nums[i]) {
                    lis[i] = Math.max(lis[i],1+lis[j] );
                }
            }
        }

        int[] lds = new int[n];
        Arrays.fill(lds,1);
        for (int i = n-1; i >= 0 ; i--) {
            for (int j = i+1; j < n; j++) {
                if(nums[j] < nums[i]) {
                    lds[i] = Math.max(lds[i],1+lds[j]);
                }
            }
        }

        int result = n;
        for (int i = 1; i < n; i++) {
            if (lis[i] > 1 && lds[i] > 1)
                result = Math.min(result,n-lis[i]-lds[i] + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 1};
        System.out.println(minimumMountainRemovals(nums1)); // Output: 0

        int[] nums2 = {2, 1, 1, 5, 6, 2, 3, 1};
        System.out.println(minimumMountainRemovals(nums2)); // Output: 3
    }
}
