package leetcode_daily;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostToMakeAtleastOneValidPath {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }

        pq.offer(new int[]{0, 0, 0});
        result[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int row = curr[1];
            int col = curr[2];

            for (int dir = 0; dir <= 3; dir++) {
                int newRow = row + dirs[dir][0];
                int newCol = col + dirs[dir][1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    int griDir = grid[row][col];
                    int dirCost = (griDir - 1 == dir) ? 0 : 1;
                    int newCost = cost + dirCost;

                    if (newCost < result[newRow][newCol]) {
                        result[newRow][newCol] = newCost;
                        pq.offer(new int[]{newCost, newRow, newCol});
                    }
                }
            }
        }
        return result[m - 1][n - 1];
    }


    public static void main(String[] args) {
        MinimumCostToMakeAtleastOneValidPath solver = new MinimumCostToMakeAtleastOneValidPath();

        int[][] grid1 = {{1, 1, 1, 1}, {2, 2, 2, 2}, {1, 1, 1, 1}, {2, 2, 2, 2}};
        System.out.println(solver.minCost(grid1)); // Output: 3

        int[][] grid2 = {{1, 1, 3}, {3, 2, 2}, {1, 1, 4}};
        System.out.println(solver.minCost(grid2)); // Output: 0

        int[][] grid3 = {{1, 2}, {4, 3}};
        System.out.println(solver.minCost(grid3)); // Output: 1
    }
}
