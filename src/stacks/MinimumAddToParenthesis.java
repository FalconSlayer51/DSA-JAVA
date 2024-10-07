package stacks;

import java.util.Stack;

public class MinimumAddToParenthesis {
    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch=='(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || stack.peek() == ')') {
                    stack.push(ch);
                } else {
                    stack.pop();
                }
            }

        }
        return stack.size();
    }

    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("())")); // Output: 1
        System.out.println(minAddToMakeValid("(((")); // Output: 3
        System.out.println(minAddToMakeValid("()"));  // Output: 0
        System.out.println(minAddToMakeValid("()))((")); // Output: 4
    }
}
