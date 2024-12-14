package leetcode_daily;

import java.util.ArrayList;
import java.util.TreeMap;

public class ContinuousSubArrays {
    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int n = nums.length;
        long subarrays = 0;
        int i = 0,j = 0;

        while (j <n) {
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while (map.lastEntry().getKey() - map.firstEntry().getKey() > 2) {
                map.put(nums[i],map.get(nums[i])-1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            subarrays += j-i + 1;
            j++;
        }


        return subarrays;
    }

    public static void main(String[] args) {
        ContinuousSubArrays solution = new ContinuousSubArrays();

        // Example 1
        int[] nums1 = {5, 4, 2, 4};
        System.out.println(solution.continuousSubarrays(nums1)); // Expected output: 8

        // Example 2
        int[] nums2 = {1, 2, 3};
        System.out.println(solution.continuousSubarrays(nums2)); // Expected output: 6
    }
}
