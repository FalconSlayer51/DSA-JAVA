package leetcode_daily;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreAndPostOrder {
    private HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = postorder.length;
        for (int i = 0; i < n; i++) {
            map.put(postorder[i], i);
        }
        return recursion(0, n - 1, 0, n - 1, preorder, postorder);
    }

    private TreeNode recursion(int i1, int i2, int j1, int j2, int[] preorder, int[] postorder) {
        if (i1 > i2 || j1 > j2) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[i1]);
        if (i1 == i2) {
            return root;
        }

        int r = map.get(preorder[i1 + 1]);
        int size = r - j1 + 1;
        root.left = recursion(i1 + 1, i1 + size, j1, r, preorder, postorder);
        root.right = recursion(i1 + size + 1, i2, r + 1, j2 - 1, preorder, postorder);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder1 = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder1 = {4, 5, 2, 6, 7, 3, 1};
        TreeNode result1 = new ConstructBinaryTreeFromPreAndPostOrder().constructFromPrePost(preorder1, postorder1);
        System.out.println(result1); // Expected output: [1, 2, 3, 4, 5, 6, 7]

        int[] preorder2 = {1};
        int[] postorder2 = {1};
        TreeNode result2 = new ConstructBinaryTreeFromPreAndPostOrder().constructFromPrePost(preorder2, postorder2);
        System.out.println(result2); // Expected output: [1]
    }
}
