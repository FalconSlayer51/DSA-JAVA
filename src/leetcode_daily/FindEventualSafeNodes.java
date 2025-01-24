package leetcode_daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindEventualSafeNodes {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        int n = graph.length;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(i,graph,map)) {
                result.add(i);
            }
        }

        return result;
    }

    public boolean dfs(int node, int[][] graph, HashMap<Integer,Boolean> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }

        map.put(node,false);
        for (int neighbor: graph[node]) {
            if(!dfs(neighbor,graph,map)){
                return false;
            }
        }
        map.put(node,true);
        return true;
    }

    public static void main(String[] args) {
        int[][] graph1 = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(new FindEventualSafeNodes().eventualSafeNodes(graph1)); // Output: [2, 4, 5, 6]

        int[][] graph2 = {{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}};
        System.out.println(new FindEventualSafeNodes().eventualSafeNodes(graph2)); // Output: [4]
    }
}
