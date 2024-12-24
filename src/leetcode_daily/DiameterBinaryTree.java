package leetcode_daily;

import static leetcode_daily.MinimumNoOfOperationsToSortBinaryTreeByLevel.buildTree;

public class DiameterBinaryTree {

    // Diameter -> Length of longest path between 2 nodes in a tree
    // Length is defined by the edges between the two nodes.
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int[] result = { Integer.MIN_VALUE };
        solve(root,result);
        return result[0];
    }

    private int solve(TreeNode root, int[] result) {
        if (root == null) return 0;

        int left = solve(root.left,result);
        int right = solve(root.right,result);

        result[0] = Math.max(result[0],left+right);
        return Math.max(left,right) + 1;
    }

    public static void main(String[] args) {
        DiameterBinaryTree solution = new DiameterBinaryTree();

        TreeNode root1 = buildTree(new Integer[]{1, 2, 3, 4, 5});
        System.out.println("Output: " + solution.diameterOfBinaryTree(root1)); // Output: 3

        TreeNode root2 = buildTree(new Integer[]{1, 2});
        System.out.println("Output: " + solution.diameterOfBinaryTree(root2)); // Output: 1
    }
}
