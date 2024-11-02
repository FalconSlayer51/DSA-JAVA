package leetcode_daily;

import java.util.Stack;

public class DeleteChractersToMakeStringFancy {
    public static String makeFancyString(String s) {
        if (s.length() <= 2) {
            return s;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.size() >= 2 && ch == stack.peek() && ch == stack.get(stack.size() -2)) {
                continue;
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0,stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeFancyString("leeetcode")); // Expected output: "leetcode"
        System.out.println(makeFancyString("aaabaaaa")); // Expected output: "aabaa"
        System.out.println(makeFancyString("aab")); // Expected output: "aab"
        System.out.println(makeFancyString("a")); // Expected output: "a"
        System.out.println(makeFancyString(""));
    }
}
