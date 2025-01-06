package leetcode_daily;

import java.util.Arrays;

public class MinOperationsToMoveBalls {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] result = new int[n];

        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                char ch = boxes.charAt(j);
                if (ch == '1') {
                    prefix[i] += Math.abs(j-i);
                }
            }
        }

        int[] suffix = new int[n];
        for (int i = n-1; i >= 0 ; i--) {
            for (int j = i-1; j >= 0 ; j--) {
                char ch = boxes.charAt(j);
                if (ch=='1') {
                    suffix[i] += Math.abs(j-i);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] + suffix[i];
        }

        return result;
    }

    public static void main(String[] args) {
        MinOperationsToMoveBalls solution = new MinOperationsToMoveBalls();

        // Example 1
        String boxes1 = "110";
        int[] result1 = solution.minOperations(boxes1);
        System.out.println(Arrays.toString(result1)); // Output: [1, 1, 3]

        // Example 2
        String boxes2 = "001011";
        int[] result2 = solution.minOperations(boxes2);
        System.out.println(Arrays.toString(result2)); // Output: [11, 8, 5, 4, 3, 4]
    }
}
