package leetcode_daily;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

public class KthLargestSumInBinaryTree {
    public static long kthLargestLevelSum(TreeNode root, int k) {
        if (k > findLevels(root)) return -1;
        ArrayList<Long> list = new ArrayList<>();
        bfs(root,list);
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);
        return list.get(k-1);
    }

    public static int findLevels(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left_levels = findLevels(root.left);
        int right_levels = findLevels(root.right);

        return 1+ Math.max(left_levels,right_levels);
    }

    public static void bfs(TreeNode root,List<Long> list) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            long levelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val;

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            list.add(levelSum);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(6);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);

        System.out.println(kthLargestLevelSum(root, 2)); // Expected output: 11 (level 3: 2 + 1 + 3 + 7)
        System.out.println(kthLargestLevelSum(root2, 1));
    }
}
