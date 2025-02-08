package leetcode_daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MagnificentSets {
    public int magnificentSets(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            adjList.get(edge[0] - 1).add(edge[1] - 1);
            adjList.get(edge[1] - 1).add(edge[0] - 1);
        }

        int[] colors = new int[n];
        for (int node = 0; node < n; node++) {
            if (colors[node] != 0) continue;
            colors[node] = 1;
            if (!isBipartite(adjList,node,colors)) return -1;
        }

        int[] distances = new int[n];
        for (int node = 0; node < n; node++) {
            distances[node] = getLongestLength(adjList,node,n);
        }

        int maxNumberOfGroups = 0;
        boolean[] visited = new boolean[n];
        for (int node = 0; node < n; node ++) {
            if (visited[node]) continue;
            maxNumberOfGroups += getNumberOfGroupsForComponent(adjList,node,distances,visited);
        }

        return maxNumberOfGroups;
    }

    private int getNumberOfGroupsForComponent(ArrayList<ArrayList<Integer>> adjList, int node, int[] distances, boolean[] visited) {
        int maxNumberOfGroups = distances[node];
        visited[node] = true;

        for (int neighbor: adjList.get(node)) {
            if (visited[neighbor]) continue;
            maxNumberOfGroups = Math.max(maxNumberOfGroups,getNumberOfGroupsForComponent(adjList,neighbor,distances,visited));
        }

        return maxNumberOfGroups;
    }

    private int getLongestLength(ArrayList<ArrayList<Integer>> adjList,int node,int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(node);
        visited[node] = true;
        int distance = 0;

        while (!queue.isEmpty()) {
            int numOfNodesInLayer = queue.size();
            for (int i = 0; i < numOfNodesInLayer; i++) {
                int currentNode = queue.poll();
                for (int neighbor : adjList.get(currentNode)) {
                    if (visited[neighbor]) continue;
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
            distance++;
        }
        return distance;
    }

    private boolean isBipartite(ArrayList<ArrayList<Integer>> adjList,int node,int[] colors) {
        for (int neighbor : adjList.get(node)) {
            if (colors[neighbor] == colors[node]) return false; //check for same color
            if (colors[neighbor] != 0) continue; //already colored
            // green = 1 * -1 = -1 / blue = -1 * -1 =1
            colors[neighbor] = -1*(colors[node]); //not visited -> color
            if (!isBipartite(adjList, neighbor, colors)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MagnificentSets ms = new MagnificentSets();

        int[][] edges1 = {{1, 2}, {1, 4}, {1, 5}, {2, 6}, {2, 3}, {4, 6}};
        System.out.println(ms.magnificentSets(6, edges1)); // Output: 4

        int[][] edges2 = {{1, 2}, {2, 3}, {3, 1}};
        System.out.println(ms.magnificentSets(3, edges2)); // Output: -1
    }
}
