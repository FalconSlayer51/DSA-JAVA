package leetcode_daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindTheLargestValueInEachRowOFTree {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                int currentVal = current.val;
                max = Math.max(max, currentVal);
                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            result.add(max);
        }

        return result;
    }

    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);
        root1.left.right = new TreeNode(3);
        root1.right.right = new TreeNode(9);
        System.out.println(new FindTheLargestValueInEachRowOFTree().largestValues(root1)); // Output: [1, 3, 9]

        // Example 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        System.out.println(new FindTheLargestValueInEachRowOFTree().largestValues(root2)); // Output: [1, 3]

        TreeNode root3 = new TreeNode(1);
        System.out.println(new FindTheLargestValueInEachRowOFTree().largestValues(root3)); // Output: [1]
    }
}
