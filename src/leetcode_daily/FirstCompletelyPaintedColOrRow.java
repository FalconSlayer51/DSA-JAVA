package leetcode_daily;

import java.util.HashMap;

public class FirstCompletelyPaintedColOrRow {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        //boolean[][] result = new boolean[m][n];
        HashMap<Integer, Integer[]> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new Integer[]{i, j});
            }
        }

        int[] countRow = new int[m];
        int[] countCol = new int[n];

        for (int i = 0;i < arr.length;i++) {
            Integer[] point = map.get(arr[i]);
            int row = point[0];
            int col = point[1];

            countRow[row]++;
            countCol[col]++;

            if (countRow[row] == n || countCol[col] == m) {
                return i;
            }
        }

        return -1;
    }

    private boolean isColPainted(boolean[][] result, int colIndex) {
        int m = result.length;
        for (int i = 0; i < m; i++) {
            if (!result[i][colIndex]) return false;
        }
        return true;
    }

    private boolean isRowPainted(boolean[][] result, int rowIndex) {
        boolean[] row = result[rowIndex];
        for (boolean value: row) {
            if (!value) return false;
        }
        return true;
    }

    // Check if all elements in a column are true


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
