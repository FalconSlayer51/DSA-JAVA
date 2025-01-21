package leetcode_daily;


import java.util.Arrays;

public class GridGame {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] maxOfGrids = new long[n];

        int[] first = new int[n];
        for (int i = n-1; i >= 0; i--) {
            if (i == n-1) continue;
            first[i] = grid[0][i+1];
        }

        for (int i = n-2; i>= 0; i--) {
            first[i] += first[i+1];
        }

        System.out.println(Arrays.toString(first));

        int[] second = new int[n];
        for (int i = 1;i<n;i++) {
            if (i == 1) {
                second[i] = grid[1][i-1];
                continue;
            }
            second[i] = grid[1][i-1];
        }
        for (int i = 1; i < n; i++) {
            second[i] += second[i-1];
        }
        System.out.println(Arrays.toString(second));

        for (int i = 0; i<n;i++) {
            maxOfGrids[i] = Math.max(first[i],second[i]);
        }

        long result = Long.MAX_VALUE;
        for (long num: maxOfGrids) {
            result = Math.min(num,result);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] grid1 = {{2, 5, 4}, {1, 5, 1}};
        System.out.println(new GridGame().gridGame(grid1)); // Output: 4

        int[][] grid2 = {{3, 3, 1}, {8, 5, 2}};
        System.out.println(new GridGame().gridGame(grid2)); // Output: 4

        int[][] grid3 = {{1, 3, 1, 15}, {1, 3, 3, 1}};
        System.out.println(new GridGame().gridGame(grid3)); // Output: 7
    }
}
