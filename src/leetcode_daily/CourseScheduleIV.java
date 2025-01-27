package leetcode_daily;

import java.util.*;

public class CourseScheduleIV {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        if (prerequisites.length == 0) {
            return new ArrayList<>(Collections.nCopies(queries.length,false));
        }

        List<Boolean> result = new ArrayList<>();
        HashMap<Integer,List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.computeIfAbsent(i,(k) ->new ArrayList<>());
        }

        for (int[] preReq: prerequisites) {
            adj.get(preReq[0]).add(preReq[1]);
        }

        Map<Integer, Set<Integer>> topoLogicalResult = topologicalSort(numCourses,adj);
        System.out.println(topoLogicalResult);
        for (int[] query: queries) {
            int preReq = query[0];
            int node = query[1];

            result.add(topoLogicalResult.getOrDefault(node,new HashSet<>()).contains(preReq));
        }

        return result;
    }

    private Map<Integer, Set<Integer>> topologicalSort(int len, Map<Integer,List<Integer>> adj) {
        int[] inDegree = new int[len];
        for (int i = 0; i < len; i++) {
            for (int neighbor: adj.getOrDefault(i,new ArrayList<>())) {
                inDegree[neighbor] ++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        Map<Integer, Set<Integer>> prereqMap = new HashMap<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();

            for(int neighbor: adj.get(current)) {
                prereqMap.computeIfAbsent(neighbor, k -> new HashSet<>()).add(current);
                prereqMap.get(neighbor).addAll(prereqMap.getOrDefault(current, new HashSet<>()));


                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return prereqMap;
    }

    public static void main(String[] args) {
        CourseScheduleIV cs = new CourseScheduleIV();

        // Example 1
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        int[][] queries1 = {{0, 1}, {1, 0}};
        System.out.println(cs.checkIfPrerequisite(numCourses1, prerequisites1, queries1)); // Output: [false, true]

        // Example 2
        int numCourses2 = 2;
        int[][] prerequisites2 = {};
        int[][] queries2 = {{1, 0}, {0, 1}};
        System.out.println(cs.checkIfPrerequisite(numCourses2, prerequisites2, queries2)); // Output: [false, false]

        // Example 3
        int numCourses3 = 3;
        int[][] prerequisites3 = {{1, 2}, {1, 0}, {2, 0}};
        int[][] queries3 = {{1, 0}, {1, 2}};
        System.out.println(cs.checkIfPrerequisite(numCourses3, prerequisites3, queries3)); // Output: [true, true]
    }
}
