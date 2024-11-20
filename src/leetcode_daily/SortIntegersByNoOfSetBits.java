package leetcode_daily;

import java.util.*;

public class SortIntegersByNoOfSetBits {
    public static int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int num : arr) {
            map.computeIfAbsent(Integer.bitCount(num), k -> new ArrayList<>()).add(num);
        }

        System.out.println(map);
        Iterator<Integer> iterator = map.keySet().iterator();
        int arrLen = 0;
        while (iterator.hasNext() && arrLen < n) {
            int key = iterator.next();
            Collections.sort(map.get(key));
            for (int num: map.get(key)) {
                result[arrLen] = num;
                arrLen++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] sortedArr1 = sortByBits(arr1);
        System.out.println(Arrays.toString(sortedArr1)); // Output: [0, 1, 2, 4, 8, 3, 5, 6, 7]

        int[] arr2 = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        int[] sortedArr2 = sortByBits(arr2);
        System.out.println(Arrays.toString(sortedArr2)); // Output: [1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024]
    }
}
