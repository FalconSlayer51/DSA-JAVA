package stacks;

import java.util.Stack;

public class RemovingDuplicates {
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
            } else {
                if(stack.peek() == ch) {
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0,stack.pop());
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicates("azxxzy"));
    }
}
