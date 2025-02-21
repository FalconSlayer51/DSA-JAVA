package leetcode_daily;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {
    private Set<Integer> set;
    public FindElements(TreeNode root) {
        set = new HashSet<>();
        root.val = 0;
        dfs(root);
    }

    public boolean find(int target) {
        return set.contains(target);
    }

    private void dfs(TreeNode node) {
        if(node == null) {
            return;
        }

        set.add(node.val);
        if(node.left != null) {
            node.left.val = 2 * node.val +1;
            dfs(node.left);
        }

        if(node.right != null) {
            node.right.val = 2 * node.val +2;
            dfs(node.right);
        }
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
