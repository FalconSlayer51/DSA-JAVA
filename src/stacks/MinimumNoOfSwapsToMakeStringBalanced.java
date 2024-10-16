package stacks;

import java.util.Stack;

public class MinimumNoOfSwapsToMakeStringBalanced {
    public static int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();

        // removes the valid strings
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch=='[') {
                stack.push(ch);
            } else {
                if(stack.isEmpty() || stack.peek() == ']') {
                    stack.push(ch);
                } else {
                    stack.pop();
                }
            }
        }

        int open = 0;
        while (!stack.isEmpty()) {
            char top = stack.pop();
            if(top == '[') {
                open ++;
            }
        }
        return (open + 1)/2;
    }
    public static void main(String[] args) {
        System.out.println(minSwaps("][][")); // Expected output: 1
        System.out.println(minSwaps("]]][[[")); // Expected output: 2
        System.out.println(minSwaps("[]")); // Expected output: 0
        System.out.println(minSwaps("]][[[]")); // Expected output: 1
        System.out.println(minSwaps("[]][[]")); // Expected output: 1
    }
}
