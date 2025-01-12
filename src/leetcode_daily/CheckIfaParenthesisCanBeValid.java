package leetcode_daily;

import java.util.Stack;

public class CheckIfaParenthesisCanBeValid {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if ((n & 1) != 0) return false;

        Stack<Integer> openStack = new Stack<>();
        Stack<Integer> openClose = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                openClose.push(i);
            } else if (s.charAt(i) == '('){
                openStack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!openStack.isEmpty()) {
                    openStack.pop();
                } else if (!openClose.isEmpty()) {
                    openClose.pop();
                } else {
                    return false;
                }
            }
        }

        while (
                !openStack.isEmpty() && !openClose.isEmpty() &&
                openStack.peek() < openClose.peek()
        ) {
            openStack.pop();
            openClose.pop();
        }

        return openStack.isEmpty();
    }

    public static void main(String[] args) {
        CheckIfaParenthesisCanBeValid sol = new CheckIfaParenthesisCanBeValid();
        // Example 1
        String s1 = "))()))";
        String locked1 = "010100";
        System.out.println(sol.canBeValid(s1, locked1)); // Output: true

        // Example 2
        String s2 = "()()";
        String locked2 = "0000";
        System.out.println(sol.canBeValid(s2, locked2)); // Output: true

        // Example 3
        String s3 = ")";
        String locked3 = "0";
        System.out.println(sol.canBeValid(s3, locked3)); // Output: false
    }
}
