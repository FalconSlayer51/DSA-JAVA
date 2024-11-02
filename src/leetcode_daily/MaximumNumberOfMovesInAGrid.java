package leetcode_daily;

import java.util.Arrays;

public class MaximumNumberOfMovesInAGrid {
    public static int maxMoves(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[][] mem = new int[r][c];
        for (int[] row: mem) {
            Arrays.fill(row,-1);
        }

        int maxMoves = 0;
        for (int i = 0; i < r; i++) {
            maxMoves = Math.max(maxMoves,maxMoves1(i,0,grid,mem));
        }

        return maxMoves;
    }

    public static int maxMoves1(int r,int c,int[][] grid,int[][] mem) {
        if (mem[r][c] != -1) return mem[r][c];
        int maxMoves = 0;
        if (r-1>= 0 && c+1 < grid[0].length && grid[r-1][c+1] > grid[r][c]) {
            maxMoves = 1+maxMoves1(r-1,c+1,grid,mem);
        }
        if (c+1 < grid[0].length && grid[r][c+1] > grid[r][c]) {
            maxMoves = Math.max(maxMoves,1+maxMoves1(r,c+1,grid,mem));
        }
        if (r+1<grid.length && c+1 < grid[0].length && grid[r+1][c+1] > grid[r][c]) {
            maxMoves = Math.max(maxMoves,1+maxMoves1(r+1,c+1,grid,mem));
        }

        mem[r][c] = maxMoves;
        return mem[r][c];
    }


    public static void main(String[] args) {
        int[][] grid1 = {
                {2, 4, 3, 5},
                {5, 4, 9, 3},
                {3, 4, 2, 11},
                {10, 9, 13, 15}
        };
        System.out.println(maxMoves(grid1)); // Output: 3

        int[][] grid2 = {
                {3, 2, 4},
                {2, 1, 9},
                {1, 1, 7}
        };
        System.out.println(maxMoves(grid2)); // Output: 0
    }
}
