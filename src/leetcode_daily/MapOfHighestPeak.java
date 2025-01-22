package leetcode_daily;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak {

    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    isWater[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0];
            int j = curr[1];


            for (int[] dir : directions) {
                int newI = i + dir[0];
                int newJ = j + dir[1];

                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && !visited[newI][newJ]) {
                    visited[newI][newJ] = true;
                    isWater[newI][newJ] = isWater[i][j] + 1;
                    queue.offer(new int[]{newI,newJ});
                }
            }
        }

        return isWater;
    }

    public static void main(String[] args) {
        int[][] isWater1 = {{0, 1}, {0, 0}};
        MapOfHighestPeak solution = new MapOfHighestPeak();
        int[][] result1 = solution.highestPeak(isWater1);
        System.out.println(Arrays.deepToString(result1)); // Expected: [[1, 0], [2, 1]]

        int[][] isWater2 = {{0, 0, 1}, {1, 0, 0}, {0, 0, 0}};
        int[][] result2 = solution.highestPeak(isWater2);
        System.out.println(Arrays.deepToString(result2)); // Expected: [[1, 1, 0], [0, 1, 1], [1, 2, 2]]
    }
}
