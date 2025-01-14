package leetcode_daily;

import java.util.Arrays;
import java.util.HashSet;

public class FindPrefixCommon {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int[] subarrayA = Arrays.copyOfRange(A, 0, i + 1);
            int[] subarrayB = Arrays.copyOfRange(B, 0, i + 1);
            HashSet<Integer> set = new HashSet<>();
            for (int num: subarrayA) {
                set.add(num);
            }

            int count = 0;
            for(int num : subarrayB) {
                if (set.contains(num)) count++;
            }

            result[i] = count;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A1 = {1, 3, 2, 4};
        int[] B1 = {3, 1, 2, 4};
        System.out.println(Arrays.toString(new FindPrefixCommon().findThePrefixCommonArray(A1, B1))); // Output: [0, 2, 3, 4]

        int[] A2 = {2, 3, 1};
        int[] B2 = {3, 1, 2};
        System.out.println(Arrays.toString(new FindPrefixCommon().findThePrefixCommonArray(A2, B2))); // Output: [0, 1, 3]
    }
}
