package leetcode_daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingLargeIsland {
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int largestIsLand(int[][] grid) {
        int n = grid.length;
        int result = 0;
        boolean[][] visited = new boolean[n][n];
        Map<Integer,Integer> idToSize = new HashMap<>();
        int id = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int size = dfs(grid,visited,i,j,n,id);
                    result = Math.max(result,size);
                    idToSize.put(id,size);
                    id++;
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> uniqueId = new HashSet<>();
                    for(int[] dir : directions) {
                        int nR = i + dir[0];
                        int nC = j + dir[1];
                        if (nR >=0 && nR<n && nC>=0 && nC <n && grid[nR][nC] != 0) {
                            uniqueId.add(grid[nR][nC]);
                        }
                    }

                    int overAllSize = 1;
                    for (var it: uniqueId) {
                        overAllSize += idToSize.get(it);
                    }

                    result = Math.max(result,overAllSize);
                }
            }
        }

        return (result == 0) ? n * n : result;
    }

    private int dfs(int[][] grid, boolean[][] visited,int i,int j,int n,int id) {
        if (i < 0 || i >= n || j <0 || j >= n ||grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        grid[i][j] = id;
        visited[i][j] = true;
        int size = 1;
        for (int[] dir: directions) {
            size += dfs(grid, visited, i+dir[0], j+dir[1], n,id);
        }
        return size;
    }

    public static void main(String[] args) {
        int[][] grid1 = {{1, 0}, {0, 1}};
        System.out.println(new MakingLargeIsland().largestIsLand(grid1)); // Output: 3

        int[][] grid2 = {{1, 1}, {1, 0}};
        System.out.println(new MakingLargeIsland().largestIsLand(grid2)); // Output: 4

        int[][] grid3 = {{1, 1}, {1, 1}};
        System.out.println(new MakingLargeIsland().largestIsLand(grid3)); // Output: 4
    }
}
