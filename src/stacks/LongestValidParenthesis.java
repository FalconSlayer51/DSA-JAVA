package stacks;

import java.util.Stack;

public class LongestValidParenthesis {
    public static int longestValidParenthesis(String s) {
        if(s.isEmpty()) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else {
                if ((stack.peek() == -1 ||s.charAt(stack.peek()) == ')')||stack.isEmpty()) {
                    stack.push(i);
                } else {
                    stack.pop();
                }
            }
        }
        //stack.insertElementAt(0,-1);
        stack.push(s.length());

        int max = 0;
        for (int i = 1; i < stack.size(); i++) {
            max = Math.max(max,stack.get(i)-stack.get(i-1)-1);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParenthesis("()")); // Expected output: 2
        System.out.println(longestValidParenthesis(")()())")); // Expected output: 4
        System.out.println(longestValidParenthesis("")); // Expected output: 0
        System.out.println(longestValidParenthesis("(()")); // Expected output: 2
        System.out.println(longestValidParenthesis("()(()")); // Expected output: 2
        System.out.println(longestValidParenthesis("()()")); // Expected output: 4
        System.out.println(longestValidParenthesis(")()())()()(")); // Expected output: 4
        System.out.println(longestValidParenthesis("()"));//Expected outpu: 2
    }
}

