package leetcode_daily;

import java.util.HashMap;

public class FirstCompletelyPaintedColOrRow {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] result = new boolean[m][n];
        HashMap<Integer, Integer[]> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new Integer[]{i, j});
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                Integer[] point = map.get(arr[i]);
                result[point[0]][point[1]] = true;
                if (isAnyRowOrColFilled(result)) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static boolean isAnyRowOrColFilled(boolean[][] array) {
        int rows = array.length;
        int cols = array[0].length;

        // Check each row
        for (boolean[] row : array) {
            if (isAllTrue(row)) return true; // Return true if a row is fully filled
        }

        // Check each column
        for (int col = 0; col < cols; col++) {
            if (isColumnAllTrue(array, col, rows)) return true; // Return true if a column is fully filled
        }

        return false; // No row or column is fully filled
    }

    // Check if all elements in a row are true
    private static boolean isAllTrue(boolean[] row) {
        for (boolean val : row) {
            if (!val) return false; // If any value is false, the row is not filled
        }
        return true; // All values are true
    }

    // Check if all elements in a column are true
    private static boolean isColumnAllTrue(boolean[][] array, int col, int rows) {
        for (int row = 0; row < rows; row++) {
            if (!array[row][col]) return false; // If any value is false, the column is not filled
        }
        return true; // All values are true
    }

    public static void main(String[] args) {
        FirstCompletelyPaintedColOrRow solver = new FirstCompletelyPaintedColOrRow();

        int[] arr1 = {1, 3, 4, 2};
        int[][] mat1 = {{1, 4}, {2, 3}};
        System.out.println(solver.firstCompleteIndex(arr1, mat1)); // Output: 2

        int[] arr2 = {2, 8, 7, 4, 1, 3, 5, 6, 9};
        int[][] mat2 = {{3, 2, 5}, {1, 4, 6}, {8, 7, 9}};
        System.out.println(solver.firstCompleteIndex(arr2, mat2)); // Output: 3
    }
}
