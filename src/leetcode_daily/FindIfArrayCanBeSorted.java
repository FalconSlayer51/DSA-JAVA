package leetcode_daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class FindIfArrayCanBeSorted {
    public static boolean canSortArray(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if (nums[j] <= nums[j+1]) {
                    continue;
                } else {
                    if (Integer.bitCount(nums[j]) != Integer.bitCount(nums[j+1])) {
                        return false;
                    } else {
                        int temp = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = temp;
                    }
                }
            }
        }

        return true;
    }

    public static boolean canSortArray1(int[] nums) {
        if (isSorted(nums)) return true;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int num : nums) {
            int key = Integer.bitCount(num);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(num);
        }


        System.out.println(map);
        Iterator<Integer> iterator = map.keySet().iterator();

        while (iterator.hasNext()){
            ArrayList<Integer> list1 = map.get(iterator.next());
            ArrayList<Integer> list2 = map.get(iterator.next());

            if (Collections.max(list1) > Collections.min(list2)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false; // Not sorted
            }
        }
        return true; // Sorted
    }

    public static void main(String[] args) {
        int[] nums1 = {20,16};
        System.out.println(canSortArray1(nums1)); // Output: true

//        int[] nums2 = {1, 2, 3, 4, 5};
//        System.out.println(canSortArray1(nums2)); // Output: true
//
//        int[] nums3 = {3, 16, 8, 4, 2};
//        System.out.println(canSortArray1(nums3)); // Output: false
    }
}
