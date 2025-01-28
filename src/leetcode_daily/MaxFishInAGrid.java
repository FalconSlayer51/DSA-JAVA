package leetcode_daily;

import java.util.LinkedList;
import java.util.Queue;

public class MaxFishInAGrid {
    public int findMaxFish(int[][] grid) {
        int maxFish = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0){
                    maxFish = Math.max(maxFish,bfs(m,n,i,j,grid));
                }
            }
        }

        return maxFish;
    }

    private int bfs(int m, int n, int i,int j,int[][] grid) {
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[m][n];
        int fish = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentI = current[0];
            int currentJ = current[1];

            fish += grid[currentI][currentJ];

            for (int[] dir: directions) {
                int newI = currentI + dir[0];
                int newJ = currentJ + dir[1];

                if (isValidMove(newI,newJ,m,n,grid,visited)) {
                    visited[newI][newJ] = true;
                    queue.offer(new int[]{newI,newJ});
                }
            }
        }

        return fish;
    }

    private boolean isValidMove(int newI, int newJ, int m, int n, int[][] grid, boolean[][] visited) {
        return newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] != 0 && !visited[newI][newJ];
    }

    public static void main(String[] args) {
        int[][] grid1 = {{0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}};
        int[][] grid2 = {{1,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,1}};

        MaxFishInAGrid solution = new MaxFishInAGrid();

        System.out.println("Output: " + solution.findMaxFish(grid1)); // Output: 7
        System.out.println("Output: " + solution.findMaxFish(grid2)); // Output: 1
    }
}
