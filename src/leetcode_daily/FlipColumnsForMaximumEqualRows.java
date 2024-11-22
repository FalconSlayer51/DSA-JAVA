package leetcode_daily;

import java.util.HashMap;

public class FlipColumnsForMaximumEqualRows {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix[0].length;
        int result = 0;
        HashMap<String,Integer> rowToFreq = new HashMap<>();

        for (int[] currentRow: matrix) {
            StringBuilder sb = new StringBuilder();
            int firstChar = currentRow[0];
            for (int col = 0; col < n; col++) {
                sb.append((currentRow[col] == firstChar) ? 'S':'B');
            }

            rowToFreq.put(sb.toString(),rowToFreq.getOrDefault(sb.toString(),0)+1);
        }

        for (int maxRows:rowToFreq.values()) {
            result = Math.max(result,maxRows);
        }

        return result;
    }
    public static void main(String[] args) {
        FlipColumnsForMaximumEqualRows solution = new FlipColumnsForMaximumEqualRows();

        int[][] matrix1 = {{0, 1}, {1, 1}};
        System.out.println(solution.maxEqualRowsAfterFlips(matrix1)); // Output: 1

        int[][] matrix2 = {{0, 1}, {1, 0}};
        System.out.println(solution.maxEqualRowsAfterFlips(matrix2)); // Output: 2

        int[][] matrix3 = {{0, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        System.out.println(solution.maxEqualRowsAfterFlips(matrix3)); // Output: 2
    }
}
