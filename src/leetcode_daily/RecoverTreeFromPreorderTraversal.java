package leetcode_daily;

import java.util.ArrayList;
import java.util.List;

public class RecoverTreeFromPreorderTraversal {
    private int n;

    public TreeNode recoverFromPreorder(String traversal) {
        n = traversal.length();
        int depth = 0;
        int[] i = {0};
        return solve(traversal, i, depth);
    }

    private TreeNode solve(String traversal, int[] index, int depth) {
        if (index[0] >= n) {
            return null;
        }

        int j = index[0];
        while (j < n && traversal.charAt(j) == '-') {
            j++;
        }
        int dash = j - index[0];
        if (dash != depth) {
            return null;
        }
        index[0] += dash;
        int num = 0;
        while (index[0] < n && Character.isDigit(traversal.charAt(index[0]))) {
            num = (num * 10) + traversal.charAt(index[0]) - '0';
            index[0]++;
        }

        TreeNode root = new TreeNode(num);
        root.left = solve(traversal, index, depth + 1);
        root.right = solve(traversal, index, depth + 1);

        return root;
    }

    public static void main(String[] args) {
        String[] testCases = {
                "1-2--3--4-5--6--7",
                "1-2--3---4-5--6---7",
                "1-401--349---90--88"
        };

        for (String testCase : testCases) {
            TreeNode result = new RecoverTreeFromPreorderTraversal().recoverFromPreorder(testCase);
            System.out.println(treeToList(result));
        }
    }

    public static List<Integer> treeToList(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    private static void preorderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        preorderTraversal(node.left, result);
        preorderTraversal(node.right, result);
    }
}
