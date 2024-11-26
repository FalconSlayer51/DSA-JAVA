package leetcode_daily;

public class FindChampion2 {
    public int findChampion(int n, int[][] edges) {
        int[] inDegree = new int[n];

        for(int[] edge : edges) {
            inDegree[edge[1]]++;
        }

        int champion = -1;
        int count = 0;

        for(int i =0;i<n;i++) {
            if(inDegree[i] == 0) {
                champion = i;
                count++;
            }
        }

        return count > 1 ? -1 : champion;
    }

    public static void main(String[] args) {
        FindChampion2 solution = new FindChampion2();

        int[][] edges1 = {{0, 1}, {1, 2}};
        System.out.println("Example 1 Output: " + solution.findChampion(3, edges1)); // Output: 0

        int[][] edges2 = {{0, 2}, {1, 3}, {1, 2}};
        System.out.println("Example 2 Output: " + solution.findChampion(4, edges2)); // Output: -1
    }
}
