package leetcode_daily;


public class ReverseOddLevelsOfBinaryTree {
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, 0);
        return root;
    }

    private void dfs(TreeNode node1, TreeNode node2, int level) {
        if (node1 == null || node2 == null) return;
        if (level % 2 == 0) {
            int val = node1.val;
            node1.val = node2.val;
            node2.val = val;
        }
        dfs(node1.left, node2.right, level + 1);
        dfs(node1.right, node2.left, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(8);
        root1.left.right = new TreeNode(13);
        root1.right.left = new TreeNode(21);
        root1.right.right = new TreeNode(34);

        ReverseOddLevelsOfBinaryTree solution = new ReverseOddLevelsOfBinaryTree();
        solution.reverseOddLevels(root1);
        printTree(root1); // Output: [2, 5, 3, 8, 13, 21, 34]

        // Example 2
        TreeNode root2 = new TreeNode(7);
        root2.left = new TreeNode(13);
        root2.right = new TreeNode(11);

        solution.reverseOddLevels(root2);
        printTree(root2); // Output: [7, 11, 13]

        // Example 3
        TreeNode root3 = new TreeNode(0);
        root3.left = new TreeNode(1);
        root3.right = new TreeNode(2);
        root3.left.left = new TreeNode(0);
        root3.left.right = new TreeNode(0);
        root3.right.left = new TreeNode(0);
        root3.right.right = new TreeNode(0);
        root3.left.left.left = new TreeNode(1);
        root3.left.left.right = new TreeNode(1);
        root3.left.right.left = new TreeNode(1);
        root3.left.right.right = new TreeNode(1);
        root3.right.left.left = new TreeNode(2);
        root3.right.left.right = new TreeNode(2);
        root3.right.right.left = new TreeNode(2);
        root3.right.right.right = new TreeNode(2);

        solution.reverseOddLevels(root3);
    }

    private static void printTree(TreeNode root2) {
        if (root2 == null) return;
        System.out.print(root2.val + " ");
        printTree(root2.left);
        printTree(root2.right);
    }
}
