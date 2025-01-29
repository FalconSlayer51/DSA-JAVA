package leetcode_daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        List<int[]> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], (k) -> new ArrayList<>());
            adj.computeIfAbsent(edge[1], (k) -> new ArrayList<>());

            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).remove(Integer.valueOf(v));
            adj.get(v).remove(Integer.valueOf(u));

            boolean[] visited = new boolean[adj.size() + 1];
            if (dfs(u, v, adj, visited)) {
                result.add(new int[]{u, v});
            }

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return result.get(result.size() - 1);
    }

    private boolean dfs(int source, int destination, HashMap<Integer, List<Integer>> adj, boolean[] visited) {
        if (source == destination) return true;
        if (visited[source]) return false;
        visited[source] = true;

        for (var neighbor : adj.getOrDefault(source, new ArrayList<>())) {
            if (dfs(neighbor,destination,adj,visited)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        RedundantConnection rc = new RedundantConnection();

        int[][] edges1 = {{1, 2}, {1, 3}, {2, 3}};
        int[] result1 = rc.findRedundantConnection(edges1);
        System.out.println("Output: " + Arrays.toString(result1)); // Output: [2, 3]

        int[][] edges2 = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[] result2 = rc.findRedundantConnection(edges2);
        System.out.println("Output: " + Arrays.toString(result2)); // Output: [1, 4]
    }
}
