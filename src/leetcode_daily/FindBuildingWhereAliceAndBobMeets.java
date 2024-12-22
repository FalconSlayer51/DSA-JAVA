package leetcode_daily;

import java.util.Arrays;

public class FindBuildingWhereAliceAndBobMeets {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int[] result = new int[queries.length];
        Arrays.fill(result,-1);
        System.out.println(Arrays.toString(result));
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            Arrays.sort(query);
            int l = query[0];
            int r = query[1];

            if (l == r || heights[r] > heights[l]) {
                result[i] = r;
                continue;
            }

            for (int j = r+1; j < n; j++) {
                if (heights[j] > Math.max(heights[l],heights[r])) {
                    result[i] = j;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindBuildingWhereAliceAndBobMeets solution = new FindBuildingWhereAliceAndBobMeets();

        // Example 1
        int[] heights1 = {6, 4, 8, 5, 2, 7};
        int[][] queries1 = {{0, 1}, {0, 3}, {2, 4}, {3, 4}, {2, 2}};
        System.out.println(Arrays.toString(solution.leftmostBuildingQueries(heights1, queries1))); // Output: [2, 5, -1, 5, 2]

        // Example 2
        int[] heights2 = {5, 3, 8, 2, 6, 1, 4, 6};
        int[][] queries2 = {{0, 7}, {3, 5}, {5, 2}, {3, 0}, {1, 6}};
        System.out.println(Arrays.toString(solution.leftmostBuildingQueries(heights2, queries2))); // Output: [7, 6, -1, 4, 6]
    }
}
