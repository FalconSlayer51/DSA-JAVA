package leetcode_daily;

import java.util.*;

public class ShortestDistanceAfterAdditionOfQueries {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        ArrayList<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            adj.add(new ArrayList<>());
            adj.get(i).add(i+1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int[] query: queries) {
            adj.get(query[0]).add(query[1]);
            result.add(bfs(adj,n));
        }

        System.out.println(adj);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private Integer bfs(ArrayList<List<Integer>> adj, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        queue.offer(0);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- > 0){
                int node = queue.poll();

                if (node == n -1) {
                    return level;
                }

                for (int neighbor: adj.get(node)) {
                    if(!visited[neighbor]) {
                        queue.offer(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }


    public static void main(String[] args) {
        ShortestDistanceAfterAdditionOfQueries obj = new ShortestDistanceAfterAdditionOfQueries();

        int n1 = 5;
        int[][] queries1 = {{2, 4}, {0, 2}, {0, 4}};
        int[] result1 = obj.shortestDistanceAfterQueries(n1, queries1);
        System.out.println(Arrays.toString(result1)); // Output: [3, 2, 1]

        int n2 = 4;
        int[][] queries2 = {{0, 3}, {0, 2}};
        int[] result2 = obj.shortestDistanceAfterQueries(n2, queries2);
        System.out.println(Arrays.toString(result2)); // Output: [1, 1]
    }
}
