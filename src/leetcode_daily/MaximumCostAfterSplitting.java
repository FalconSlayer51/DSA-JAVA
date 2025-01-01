package leetcode_daily;

import java.util.Arrays;

public class MaximumCostAfterSplitting {

    public int maxScore(String s) {
        int n = s.length();
        int[] prefixSum = new int[n];

        int sumOnes = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') sumOnes++;
        }

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                prefixSum[i] = sumOnes;
            } else {
                prefixSum[i] = --sumOnes;
            }
        }

        System.out.println(Arrays.toString(prefixSum));


        int numZeros = 0;
        int maxScore = 0;

        // we should not consider the last character since the right sum is always zero
        for (int i = 0; i < n-1; i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                numZeros++;
            }
            maxScore = Math.max(maxScore, numZeros + prefixSum[i]);
        }

        return maxScore;
    }


    public static void main(String[] args) {
        // Test case 1
        String s1 = "00";
        System.out.println("Output: " + new MaximumCostAfterSplitting().maxScore(s1)); // Expected: 5

        // Test case 2
        String s2 = "00111";
        System.out.println("Output: " + new MaximumCostAfterSplitting().maxScore(s2)); // Expected: 5

        // Test case 3
        String s3 = "1111";
        System.out.println("Output: " + new MaximumCostAfterSplitting().maxScore(s3)); // Expected: 3
    }
}
