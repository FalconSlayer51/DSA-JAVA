package leetcode_daily;

import java.util.*;

public class ValidArrangementOfPairs {
    /* HierHolzer Algorithm
        -> Build adjacency list
        -> Build indegree and outdegree
        -> Find the start node of euler path => outdegree - indegree == 1
        -> Euler path stored in an array
        -> Do a dfs from starting node
        -> End node indegree-outdegree == 1
     */
    public int[][] validArrangement(int[][] pairs) {
        // adj list
        HashMap<Integer, List<Integer>> adj = new HashMap<>();


        // build in degree and out degree
        HashMap<Integer,Integer> indegree = new HashMap<>();
        HashMap<Integer,Integer> outdegree = new HashMap<>();

        for (int[] edge: pairs) {
            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u,k-> new ArrayList<>()).add(v);
            outdegree.put(u,outdegree.getOrDefault(u,0)+1);
            indegree.put(v,indegree.getOrDefault(v,0)+1);
        }
        
        // Find the start node of euler path
        int startNode = pairs[0][0];
        for (int node: adj.keySet()) {
            if (outdegree.getOrDefault(node,0)-indegree.getOrDefault(node,0) == 1){
                startNode = node;
                break;
            }
        }

        //khandani dfs
        List<Integer> eulerPath = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            int curr = stack.peek();
            if (adj.containsKey(curr) && !adj.get(curr).isEmpty()) {
                int neighbor = adj.get(curr).remove(adj.get(curr).size()-1);
                stack.push(neighbor);
            } else {
                eulerPath.add(curr);
                stack.pop();
            }
        }

        Collections.reverse(eulerPath);

        int[][] result = new int[eulerPath.size()-1][2];
        for(int i = 0;i<eulerPath.size()-1;i++) {
            result[i][0] = eulerPath.get(i);
            result[i][1] = eulerPath.get(i+1);
        }

        return result;
    }

    public static void main(String[] args) {
        ValidArrangementOfPairs solution = new ValidArrangementOfPairs();

        int[][] pairs1 = {{5, 1}, {4, 5}, {11, 9}, {9, 4}};
        int[][] result1 = solution.validArrangement(pairs1);
        System.out.println(Arrays.deepToString(result1));

        int[][] pairs2 = {{1, 3}, {3, 2}, {2, 1}};
        int[][] result2 = solution.validArrangement(pairs2);
        System.out.println(Arrays.deepToString(result2));

        int[][] pairs3 = {{1, 2}, {1, 3}, {2, 1}};
        int[][] result3 = solution.validArrangement(pairs3);
        System.out.println(Arrays.deepToString(result3));
    }
}
