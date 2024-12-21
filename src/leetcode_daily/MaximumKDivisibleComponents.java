package leetcode_daily;

import java.util.ArrayList;
import java.util.List;

public class MaximumKDivisibleComponents {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adjList[node1].add(node2);
            adjList[node2].add(node1);
        }

        int[] componentCount = new int[1];
        dfs(0, -1, adjList, values, k, componentCount);
        return componentCount[0];
    }

    private long dfs(
            int currentNode,
            int parentNode,
            List<Integer>[] adjList,
            int[] values,
            int k,
            int[] componentCount
    ) {
        long sum = 0;
        for (int neighborNode : adjList[currentNode]) {
            if (neighborNode != parentNode) {
                sum += dfs(neighborNode, currentNode, adjList, values, k, componentCount);
            }
        }

        sum += values[currentNode];
        if (sum % k == 0) {
            componentCount[0]++;
            sum = 0;
        }

        return sum;
    }

    public static void main(String[] args) {
        MaximumKDivisibleComponents solution = new MaximumKDivisibleComponents();

        // Test case 1
        int n1 = 5;
        int[][] edges1 = {{0, 2}, {1, 2}, {1, 3}, {2, 4}};
        int[] values1 = {1, 8, 1, 4, 4};
        int k1 = 6;
        System.out.println(solution.maxKDivisibleComponents(n1, edges1, values1, k1)); // Output: 2

        // Test case 2
        int n2 = 7;
        int[][] edges2 = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
        int[] values2 = {3, 0, 6, 1, 5, 2, 1};
        int k2 = 3;
        System.out.println(solution.maxKDivisibleComponents(n2, edges2, values2, k2)); // Output: 3
    }
}
