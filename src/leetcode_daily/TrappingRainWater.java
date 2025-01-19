package leetcode_daily;

import java.util.PriorityQueue;

public class TrappingRainWater {
    public int trapRainWater(int[][] heightMap) {
        int rows = heightMap.length;
        int cols = heightMap[0].length;

        int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};
        int totalUnvisitedCells = rows * cols;
        boolean[][] visited = new boolean[rows][cols];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        for (int i = 0; i < rows; i++) {
            pq.offer(new int[]{heightMap[i][0],i,0});
            pq.offer(new int[]{heightMap[i][cols-1],i,cols-1});
            visited[i][0] = true;
            visited[i][cols-1] = true;
            totalUnvisitedCells--;
            totalUnvisitedCells--;
        }

        for (int i = 1; i < cols-1; i++) {
            pq.offer(new int[]{heightMap[0][i],0,i});
            pq.offer(new int[]{heightMap[rows-1][i],rows-1,i});
            visited[0][i] = true;
            visited[rows-1][i] = true;
            totalUnvisitedCells--;
            totalUnvisitedCells--;
        }

        int trappedWater = 0;
        int waterLevel = 0;

        while (!pq.isEmpty() && totalUnvisitedCells > 0) {
            int[] currentCell = pq.poll();
            int currentHeight = currentCell[0];
            int currentRow = currentCell[1];
            int currentCol = currentCell[2];
            waterLevel = Math.max(waterLevel,currentHeight);

            for (int direction = 0; direction < 4; direction++) {
                int neighborRow = currentRow + dir[direction][0];
                int neighborCol = currentCol + dir[direction][1];

                if (isValidCell(neighborRow,neighborCol,rows,cols) && !visited[neighborRow][neighborCol]) {
                    int neighborHeight = heightMap[neighborRow][neighborCol];
                    if (neighborHeight < waterLevel) {
                        trappedWater += waterLevel - neighborHeight;
                    }
                    pq.offer(new int[]{neighborHeight,neighborRow,neighborCol});
                    visited[neighborRow][neighborCol] = true;
                    totalUnvisitedCells--;
                }
            }
        }

        return trappedWater;
    }

    private boolean isValidCell(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }


    public static void main(String[] args) {
        int[][] heightMap1 = {
                {1, 4, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 4},
                {2, 3, 3, 2, 3, 1}
        };
        int[][] heightMap2 = {
                {3, 3, 3, 3, 3},
                {3, 2, 2, 2, 3},
                {3, 2, 1, 2, 3},
                {3, 2, 2, 2, 3},
                {3, 3, 3, 3, 3}
        };

        TrappingRainWater solution = new TrappingRainWater();
        System.out.println("Output for heightMap1: " + solution.trapRainWater(heightMap1)); // Output: 4
        System.out.println("Output for heightMap2: " + solution.trapRainWater(heightMap2)); // Output: 10
    }
}
