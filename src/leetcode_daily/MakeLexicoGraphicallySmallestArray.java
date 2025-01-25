package leetcode_daily;

import java.util.*;

public class MakeLexicoGraphicallySmallestArray {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);

        int groupNum = 0;
        HashMap<Integer,Integer> numToGroup = new HashMap<>();
        HashMap<Integer, LinkedList<Integer>> groupToList = new HashMap<>();

        numToGroup.put(arr[0] , groupNum);
        groupToList.putIfAbsent(groupNum, new LinkedList<>());
        groupToList.get(groupNum).add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (Math.abs(arr[i]-arr[i-1]) > limit) {
                groupNum++;
            }

            numToGroup.put(arr[i],groupNum);
            groupToList.putIfAbsent(groupNum, new LinkedList<>());
            groupToList.get(groupNum).add(arr[i]);
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int group = numToGroup.get(nums[i]);
            result[i] = groupToList.get(group).pollFirst();
        }


        return result;
    }

    public void swap(int[] nums,int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1, 5, 3, 9, 8};
        int limit1 = 2;
        int[] result1 = new MakeLexicoGraphicallySmallestArray().lexicographicallySmallestArray(nums1, limit1);
        System.out.println(Arrays.toString(result1)); // Output: [1, 3, 5, 8, 9]

        // Example 2
        int[] nums2 = {1, 7, 6, 18, 2, 1};
        int limit2 = 3;
        int[] result2 = new MakeLexicoGraphicallySmallestArray().lexicographicallySmallestArray(nums2, limit2);
        System.out.println(Arrays.toString(result2)); // Output: [1, 6, 7, 18, 1, 2]

        // Example 3
        int[] nums3 = {1, 7, 28, 19, 10};
        int limit3 = 3;
        int[] result3 = new MakeLexicoGraphicallySmallestArray().lexicographicallySmallestArray(nums3, limit3);
        System.out.println(Arrays.toString(result3)); // Output: [1, 7, 28, 19, 10]
    }
}
