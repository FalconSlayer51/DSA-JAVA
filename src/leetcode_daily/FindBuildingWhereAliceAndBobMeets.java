package leetcode_daily;

import java.util.*;

public class FindBuildingWhereAliceAndBobMeets {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);
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

            for (int j = r + 1; j < n; j++) {
                if (heights[j] > Math.max(heights[l], heights[r])) {
                    result[i] = j;
                    break;
                }
            }
        }

        return result;
    }

    public int[] leftmostBuildingQueries2(int[] heights, int[][] queries) {
        List<List<List<Integer>>> storeQueries = new ArrayList<>(
                heights.length
        );
        for (int i = 0; i < heights.length; i++) storeQueries.add(
                new ArrayList<>()
        );
        PriorityQueue<List<Integer>> maxIndex = new PriorityQueue<>(
                (a, b) -> a.get(0) - b.get(0)
        );
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);

        //Store the mappings for all queries in storeQueries.
        for (int currQuery = 0; currQuery < queries.length; currQuery++) {
            int a = queries[currQuery][0], b = queries[currQuery][1];
            if (a < b && heights[a] < heights[b]) {
                result[currQuery] = b;
            } else if (a > b && heights[a] > heights[b]) {
                result[currQuery] = a;
            } else if (a == b) {
                result[currQuery] = a;
            } else {
                storeQueries
                        .get(Math.max(a, b))
                        .add(
                                Arrays.asList(
                                        Math.max(heights[a], heights[b]),
                                        currQuery
                                )
                        );
            }
        }

        //If the priority queue's minimum pair value is less than the current index of height, it is an answer to the query.
        for (int index = 0; index < heights.length; index++) {
            while (
                    !maxIndex.isEmpty() && maxIndex.peek().get(0) < heights[index]
            ) {
                result[maxIndex.peek().get(1)] = index;
                maxIndex.poll();
            }
            // Push the with their maximum index as the current index in the priority queue.
            for (List<Integer> element : storeQueries.get(index)) {
                maxIndex.offer(element);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindBuildingWhereAliceAndBobMeets solution = new FindBuildingWhereAliceAndBobMeets();

        // Example 1
        int[] heights1 = {6, 4, 8, 5, 2, 7};
        int[][] queries1 = {{0, 1}, {0, 3}, {2, 4}, {3, 4}, {2, 2}};
        System.out.println(Arrays.toString(solution.leftmostBuildingQueries2(heights1, queries1))); // Output: [2, 5, -1, 5, 2]

        // Example 2
        int[] heights2 = {5, 3, 8, 2, 6, 1, 4, 6};
        int[][] queries2 = {{0, 7}, {3, 5}, {5, 2}, {3, 0}, {1, 6}};
        System.out.println(Arrays.toString(solution.leftmostBuildingQueries2(heights2, queries2))); // Output: [7, 6, -1, 4, 6]
    }
}
