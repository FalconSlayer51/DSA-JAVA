package leetcode_daily;

public class FindingMinimumDiameterAfterMergingTwoTrees {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        return 0;
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
