package leetcode_daily;

import java.util.*;

public class CountTheServersThatCommunicate {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int servers = 0;

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    servers++;
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    if (rowCount[i] == 1 && colCount[j]==1) servers--;
            }
        }

        return servers;
    }


    public static void main(String[] args) {
        int[][] grid1 = {{1, 0}, {0, 1}};
        System.out.println(new CountTheServersThatCommunicate().countServers(grid1)); // Output: 0

        int[][] grid2 = {{1, 0}, {1, 1}};
        System.out.println(new CountTheServersThatCommunicate().countServers(grid2)); // Output: 3

        int[][] grid3 = {{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        System.out.println(new CountTheServersThatCommunicate().countServers(grid3)); // Output: 4
    }
}
