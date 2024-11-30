package leetcode_daily;

import java.util.PriorityQueue;

public class MinimumTimeToVisitCellInGrid {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    /*
    * Source = [0][0]
    * Destination = [m-1][n-1]
    * Condition to move to neighboring cell
    *   -> t >= grid[r][c]
    *   -> Djisktra is the best algorithm
    * We can waste time when t< grid[r][c]
    *   if diff == odd
    *       t = grid[r][c]
    *   else
    *       t = grid[r][c] + 1
    * */
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];


        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        priorityQueue.offer(new int[]{grid[0][0],0,0});

        while (!priorityQueue.isEmpty()) {
            int[] curr = priorityQueue.poll();
            int time = curr[0], row = curr[1], col = curr[2];

            if(row == m-1 && col == n-1){
                return time;
            }

            if (visited[row][col]) continue;
            visited[row][col] = true;

            for (int[] dir: directions) {
                int i = row + dir[0];
                int j = col + dir[1];

                if(i < 0 || i>=m || j<0 || j>=n || visited[i][j]) {
                    continue;
                }

                if (grid[i][j] <= time + 1) {
                    priorityQueue.add(new int[]{time+1,i,j});
                } else if((grid[i][j] - time) % 2 == 0) {
                    priorityQueue.add(new int[]{grid[i][j]+1,i,j});
                } else {
                    priorityQueue.add(new int[]{grid[i][j],i,j});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        MinimumTimeToVisitCellInGrid solver = new MinimumTimeToVisitCellInGrid();

        int[][] grid1 = {{0, 1, 3, 2}, {5, 1, 2, 5}, {4, 3, 8, 6}};
        System.out.println(solver.minimumTime(grid1)); // Expected output: 7

        int[][] grid2 = {{0, 2, 4}, {3, 2, 1}, {1, 0, 4}};
        System.out.println(solver.minimumTime(grid2)); // Expected output: -1
    }
}
