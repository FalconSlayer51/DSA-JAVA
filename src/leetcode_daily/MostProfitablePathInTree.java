package leetcode_daily;

import java.util.*;

class MostProfitablePathInTree {
    private HashMap<Integer, List<Integer>> adj = new HashMap<>();
    private HashMap<Integer, Integer> bobTime = new HashMap<>();
    private int aliceIncome;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        aliceIncome = Integer.MIN_VALUE;
        System.out.println(adj);

        boolean[] visited = new boolean[n];
        dfsForBob(bob, 0, visited, bobTime);

        Arrays.fill(visited, false);
        int income = 0;
        dfsForAlice(0, 0, income, visited, amount);

        return aliceIncome;
    }

    private void dfsForAlice(int curr, int time, int income, boolean[] visited, int[] amount) {
        visited[curr] = true;

        if (!bobTime.containsKey(curr) || bobTime.get(curr) > time) {
            income += amount[curr];
        } else if (time == bobTime.get(curr)) {
            income += amount[curr] / 2;
        }

        if (adj.getOrDefault(curr, new ArrayList<>()).size() == 1 && curr != 0) {
            aliceIncome = Math.max(aliceIncome, income);
        }

        for (int ngbr : adj.getOrDefault(curr, new ArrayList<>())) {
            if (!visited[ngbr]) {
                dfsForAlice(ngbr, time + 1, income, visited, amount);
            }
        }
    }

    private boolean dfsForBob(int bob, int time, boolean[] visited, Map<Integer, Integer> bobMap) {
        visited[bob] = true;
        bobMap.put(bob, time);

        if (bob == 0) {
            return true;
        }

        for (var ngbr : adj.getOrDefault(bob, new ArrayList<>())) {
            if (!visited[ngbr]) {
                if (dfsForBob(ngbr, time + 1, visited, bobMap)) {
                    return true;
                }
            }
        }

        bobMap.remove(bob);
        return false;
    }

    public static void main(String[] args) {
        int[][] edges1 = {{0, 1}, {1, 2}, {1, 3}, {3, 4}};
        int bob1 = 3;
        int[] amount1 = {-2, 4, 2, -4, 6};
        System.out.println(new MostProfitablePathInTree().mostProfitablePath(edges1, bob1, amount1)); // Output: 6

        int[][] edges2 = {{0, 1}};
        int bob2 = 1;
        int[] amount2 = {-7280, 2350};
        System.out.println(new MostProfitablePathInTree().mostProfitablePath(edges2, bob2, amount2)); // Output: -7280
    }
}
