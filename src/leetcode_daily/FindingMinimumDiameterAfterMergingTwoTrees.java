package leetcode_daily;

import java.util.*;

public class FindingMinimumDiameterAfterMergingTwoTrees {

    // Try to choose nodes that divides the diameters of tree1 and tree2
    // The solution will be the ceil of mid-point of diameter of 1st tree,
    // take ceil of the mid-point of diameter of 2nd tree
    // add both diameters + 1
    // (d1+1/2) + (d2+1)/2 + 1;
    // corner case :- a diameter can exist solely in one tree.
    // the answer will be:- max(d1,d2,(d1+1/2) + (d2+1)/2 + 1);
    // we will find the diameter using bfs
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        Map<Integer,List<Integer>> adj1 = buildAdjList(edges1);
        Map<Integer,List<Integer>> adj2 = buildAdjList(edges2);

        int d1 = findDiameter(adj1);
        int d2 = findDiameter(adj2);

        int combined = ((d1+1)/2) + ((d2+1)/2) + 1;

        return Math.max(Math.max(d1,d2),combined);
    }

    private int findDiameter(Map<Integer, List<Integer>> adj1) {
        List<Integer> farthestNode = bfs(adj1,0);
        farthestNode = bfs(adj1,farthestNode.get(0));
        return farthestNode.get(1);
    }

    private List<Integer> bfs(Map<Integer, List<Integer>> adjList, int sourceNode) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer,Boolean> visited = new HashMap<>();

        queue.add(sourceNode);
        visited.put(sourceNode,true);

        int maxDistance = 0, farthestNode = sourceNode;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currentNode = queue.poll();
                farthestNode = currentNode;
                for (int neighbor: adjList.getOrDefault(currentNode,new ArrayList<>())) {
                    if (!visited.getOrDefault(neighbor,false)) {
                        visited.put(neighbor,true);
                        queue.add(neighbor);
                    }
                }
            }
            if (!queue.isEmpty()) {
                maxDistance ++;
            }
        }

        return Arrays.asList(farthestNode,maxDistance);
    }

    private Map<Integer, List<Integer>> buildAdjList(int[][] edges) {
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        for(int[] edge: edges) {
            adjList.computeIfAbsent(edge[0],k->new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1],k->new ArrayList<>()).add(edge[0]);
        }
        return adjList;
    }

    public static void main(String[] args) {
        FindingMinimumDiameterAfterMergingTwoTrees solver = new FindingMinimumDiameterAfterMergingTwoTrees();

        int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}};
        int[][] edges2 = {{0, 1}};
        System.out.println("Output: " + solver.minimumDiameterAfterMerge(edges1, edges2)); // Output: 3

        int[][] edges1_2 = {{0, 1}, {0, 2}, {0, 3}, {2, 4}, {2, 5}, {3, 6}, {2, 7}};
        int[][] edges2_2 = {{0, 1}, {0, 2}, {0, 3}, {2, 4}, {2, 5}, {3, 6}, {2, 7}};
        System.out.println("Output: " + solver.minimumDiameterAfterMerge(edges1_2, edges2_2)); // Output: 5
    }
}
