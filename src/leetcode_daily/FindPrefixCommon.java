package leetcode_daily;

import java.util.Arrays;

public class FindPrefixCommon {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        int[] freqArray = new int[n+1];
        int commonCount = 0;

        for (int i = 0; i < n; i++) {
            freqArray[A[i]] += 1;
            if (freqArray[A[i]] == 2) commonCount ++;

            freqArray[B[i]] += 1;
            if (freqArray[B[i]] == 2) commonCount ++;

            result[i] = commonCount;
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
