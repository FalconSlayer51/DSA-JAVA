package leetcode_daily;

import java.util.Arrays;

public class SpecialArray2 {
    public boolean[] isArraySpecial(int[] nums,int[][] queries) {
        int n = queries.length;
        boolean[] result = new boolean[n];

        int[] count = new int[nums.length];
        count[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]%2 == nums[i-1]%2)
                count[i] = count[i-1]+1;
            else
                count[i] = count[i-1];
        }

        for (int i = 0; i < n; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            int countUpToStart = count[start];
            int countUpToEnd = count[end];

            result[i] = (countUpToEnd - countUpToStart) == 0;
        }


        return result;
    }

    private boolean isSubArraySpecial(int[] nums, int start, int end) {
        int[] subarray = Arrays.copyOfRange(nums,start,end+1);
        int n = end - start + 1;
        for (int i = 1; i < n; i++) {
            if(subarray[i] % 2 == subarray[i - 1] % 2) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SpecialArray2 solution = new SpecialArray2();

        int[] nums1 = {3, 4, 1, 2, 6};
        int[][] queries1 = {{0, 4}};
        System.out.println(Arrays.toString(solution.isArraySpecial(nums1, queries1))); // Expected output: [false]

        int[] nums2 = {4, 3, 1, 6, 4, 3, 1};
        int[][] queries2 = {{0, 2}, {2, 3}};
        System.out.println(Arrays.toString(solution.isArraySpecial(nums2, queries2))); // Expected output: [false, true]
    }
}
