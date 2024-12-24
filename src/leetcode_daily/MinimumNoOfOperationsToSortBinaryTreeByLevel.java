package leetcode_daily;

import java.util.*;

public class MinimumNoOfOperationsToSortBinaryTreeByLevel {
    public int minimumOperations(TreeNode root) {
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] nodesAtCurrentLevel = new int[size];

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                nodesAtCurrentLevel[i] = current.val;
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            count += noOfOperations(nodesAtCurrentLevel);
        }

        return count;
    }

    private int noOfOperations(int[] nodesAtCurrentLevel) {
        int n = nodesAtCurrentLevel.length;
        int[] target = nodesAtCurrentLevel.clone();
        Arrays.sort(target);
        int swaps = 0;

        HashMap<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.put(nodesAtCurrentLevel[i], i);
        }

        for (int i = 0; i < n; i++) {
            if (nodesAtCurrentLevel[i] != target[i]) {
                swaps++;
                int currentPos = pos.get(target[i]);
                pos.put(nodesAtCurrentLevel[i], currentPos);
                nodesAtCurrentLevel[currentPos] = nodesAtCurrentLevel[i];
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        MinimumNoOfOperationsToSortBinaryTreeByLevel solution = new MinimumNoOfOperationsToSortBinaryTreeByLevel();

        TreeNode root1 = buildTree(new Integer[]{1, 4, 3, 7, 6, 8, 5, null, null, null, null, 9, null, 10});
        System.out.println(solution.minimumOperations(root1)); // Output: 3

        TreeNode root2 = buildTree(new Integer[]{1, 3, 2, 7, 6, 5, 4});
        System.out.println(solution.minimumOperations(root2)); // Output: 3

        TreeNode root3 = buildTree(new Integer[]{1, 2, 3, 4, 5, 6});
        System.out.println(solution.minimumOperations(root3)); // Output: 0
    }

    public static TreeNode buildTree(Integer[] values) {
        if (values.length == 0 || values[0] == null) return null;
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (i < values.length) {
            TreeNode current = queue.poll();
            if (values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.add(current.left);
            }
            i++;
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
}
