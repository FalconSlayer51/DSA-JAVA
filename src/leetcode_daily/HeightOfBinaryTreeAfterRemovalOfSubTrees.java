package leetcode_daily;

import java.util.Arrays;

public class HeightOfBinaryTreeAfterRemovalOfSubTrees {
    static final int[] maxAfterRemoval = new int[100001];
    int currentMaxHeight = 0;
    public int[] treeQueries(TreeNode root, int[] queries) {
        traverseLeftToRight(root,0);
        currentMaxHeight = 0;
        traverseRightToLeft(root,0);
        int n = queries.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = maxAfterRemoval[queries[i]];
        }

        return result;
    }

    public void traverseLeftToRight(TreeNode root,int currentHeight) {
        if(root == null) return;
        maxAfterRemoval[root.val] = currentMaxHeight;
        currentMaxHeight = Math.max(currentMaxHeight,currentHeight);
        traverseLeftToRight(root.left,currentHeight+1);
        traverseLeftToRight(root.right,currentHeight+1);
    }

    public void traverseRightToLeft(TreeNode root, int currentHeight) {
        if(root == null) return;

        maxAfterRemoval[root.val] =  Math.max(maxAfterRemoval[root.val],currentMaxHeight);

        currentMaxHeight = Math.max(currentMaxHeight,currentHeight);

        traverseRightToLeft(root.right,currentHeight+1);
        traverseRightToLeft(root.left,currentHeight+1);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(4);
        root1.left.left = new TreeNode(2);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(5);
        root1.right.left.right = new TreeNode(7);

        HeightOfBinaryTreeAfterRemovalOfSubTrees obj = new HeightOfBinaryTreeAfterRemovalOfSubTrees();
        int[] queries1 = {4};
        int[] result1 = obj.treeQueries(root1, queries1);
        System.out.println(Arrays.toString(result1)); // Expected output: [2]
    }
}
