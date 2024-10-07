package stacks;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch=='{' || ch=='[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.peek();
                if ((ch==')' && top != '(' )||(ch=='}' && top != '{')||(ch==']' && top != '[')) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(isValid("()"));         // Expected output: true
        System.out.println(isValid("()[]{}"));    // Expected output: true
        System.out.println(isValid("(]"));       // Expected output: false
        System.out.println(isValid("([])"));    // Expected output: true
    }
}