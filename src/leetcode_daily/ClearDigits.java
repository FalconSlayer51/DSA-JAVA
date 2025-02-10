package leetcode_daily;

import java.util.Stack;

public class ClearDigits {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) {
                if(!stack.isEmpty())
                    stack.pop();
            }else{
                stack.push(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.insert(0,stack.pop());
        }
        return result.toString();
    }
}
