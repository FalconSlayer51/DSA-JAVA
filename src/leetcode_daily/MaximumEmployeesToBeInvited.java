package leetcode_daily;

import java.util.*;

public class MaximumEmployeesToBeInvited {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int u = i;
            int v = favorite[i];
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        int longestCycleEmplCount = 0;
        int happyCouple = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                HashMap<Integer,Integer> map = new HashMap<>();
                int currentNode = i;
                int currNodeCount = 0;
                while (!visited[currentNode]) {
                    visited[currentNode] = true;
                    map.put(currentNode,currNodeCount);

                    int nextNode = favorite[currentNode];
                    currNodeCount++;

                    if (map.containsKey(nextNode)) {
                        int cycleLength = currNodeCount - map.get(nextNode);
                        longestCycleEmplCount = Math.max(longestCycleEmplCount,cycleLength);
                        if (cycleLength == 2) {
                            boolean[] visitedNodes = new boolean[n];
                            visitedNodes[currentNode] = true;
                            visitedNodes[nextNode] = true;
                            happyCouple += 2+bfs(currentNode,adj, visitedNodes) + bfs(nextNode,adj,visitedNodes);
                        }
                        break;
                    }

                    currentNode = nextNode;
                }
            }
        }

        return Math.max(happyCouple,longestCycleEmplCount);
    }

    private int bfs(int currentNode,Map<Integer, List<Integer>> adj,boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {currentNode,0});
        int maxDistance = 0;

        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            int currNode = curr[0];
            int pathLength = curr[1];

            for (int ngbr: adj.getOrDefault(currNode,new ArrayList<>())) {
                if (!visited[ngbr]) {
                    visited[ngbr] = true;
                    queue.offer(new int[]{ngbr,pathLength+1});
                    maxDistance = Math.max(maxDistance,pathLength+1);
                }
            }
        }

        return maxDistance;
    }

    public static void main(String[] args) {
        MaximumEmployeesToBeInvited solution = new MaximumEmployeesToBeInvited();

        int[] favorite1 = {2, 2, 1, 2};
        System.out.println(solution.maximumInvitations(favorite1)); // Output: 3

        int[] favorite2 = {1, 2, 0};
        System.out.println(solution.maximumInvitations(favorite2)); // Output: 3

        int[] favorite3 = {3, 0, 1, 4, 1};
        System.out.println(solution.maximumInvitations(favorite3)); // Output: 4
    }
}
