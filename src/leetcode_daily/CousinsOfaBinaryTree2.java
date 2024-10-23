package leetcode_daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CousinsOfaBinaryTree2 {

    public static TreeNode replaceValueInTree(TreeNode root) {
        ArrayList<Integer> levelSum = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //pass1
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                sum += currentNode.val;

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            levelSum.add(sum);
        }

        int level = 0;
        queue.offer(root);
        root.val = 0;
        // pass 2
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int sum = 0;
                TreeNode currentNode = queue.poll();

                if (currentNode.left != null) {
                    sum += currentNode.left.val;
                }

                if (currentNode.right != null) {
                    sum += currentNode.right.val;
                }

                if (currentNode.left != null) {
                    currentNode.left.val = levelSum.get(level + 1) - sum;
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    currentNode.right.val = levelSum.get(level + 1) - sum;
                    queue.offer(currentNode.right);
                }
            }
            level ++;
        }
        return root;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(10);
        root.right.right = new TreeNode(7);

        System.out.println(replaceValueInTree(root));
    }
}
