package leetcode_daily;

import java.util.Arrays;

public class CountUnguardedCellsInGrid {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        for (int[] ints : guards) {
            int row = ints[0];
            int col = ints[1];

            grid[row][col] = 2;
        }

        for (int[] wall: walls) {
            int row = wall[0];
            int col = wall[1];

            grid[row][col] = 3;
        }

        for (int[] guard: guards) {
            int i = guard[0];
            int j = guard[1];
            markGuard(i,j,grid);
        }

        int count = 0;
        for (int i = 0; i< m;i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count ++;
                }
            }
        }

        return count;
    }

    private void markGuard(int row, int col, int[][] grid) {
        //up
        for (int i = row-1; i >= 0; i--) {
            if (grid[i][col] == 2||grid[i][col] == 3) {
                break;
            }
            grid[i][col] = 1;
        }


        for (int i = row+1; i < grid.length; i++) {
            if (grid[i][col] == 2||grid[i][col] == 3) {
                break;
            }
            grid[i][col] = 1;
        }


        for (int i = col-1; i >= 0; i--) {
            if (grid[row][i] == 2||grid[row][i] == 3) {
                break;
            }
            grid[row][i] = 1;
        }

        for (int i = col+1; i < grid[0].length; i++) {
            if (grid[row][i] == 2||grid[row][i] == 3) {
                break;
            }
            grid[row][i] = 1;
        }
    }

    public static void main(String[] args) {
        CountUnguardedCellsInGrid solution = new CountUnguardedCellsInGrid();
        int[][] guards1 = {{0, 0}, {1, 1}, {2, 3}};
        int[][] walls1 = {{0, 1}, {2, 2}, {1, 4}};
        System.out.println(solution.countUnguarded(4, 6, guards1, walls1)); // Output: 7

        int[][] guards2 = {{1, 1}};
        int[][] walls2 = {{0, 1}, {1, 0}, {2, 1}, {1, 2}};
        System.out.println(solution.countUnguarded(3, 3, guards2, walls2)); // Output: 4
    }
}
