package leetcode_daily;

import java.util.Stack;

public class RemoveAllOccurencesOfSubstring {
    public String removeOccurrences(String s, String part) {
        int n = s.length();
        int m = part.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            stack.push(ch);
            if (stack.size() >= m && check(stack, part, m)) {
                for (int j = 0; j < m; j++) {
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

    private boolean check(Stack<Character> stack, String part, int m) {
        Stack<Character> tempStack = new Stack<>();
        tempStack.addAll(stack);
        for (int i = m-1; i >= 0; i--) {
            if (tempStack.peek() != part.charAt(i)) return false;
            tempStack.pop();
        }
        return true;
    }

    public static void main(String[] args) {
        // Example 1
        String s1 = "daabcbaabcbc";
        String part1 = "abc";
        System.out.println(new RemoveAllOccurencesOfSubstring().removeOccurrences(s1, part1)); // Output: "dab"

        // Example 2
        String s2 = "axxxxyyyyb";
        String part2 = "xy";
        System.out.println(new RemoveAllOccurencesOfSubstring().removeOccurrences(s2, part2)); // Output: "ab"
    }
}
