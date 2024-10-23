package leetcode_daily;

import java.util.ArrayList;
import java.util.Stack;

public class ParsingaBooleanExpression {
    public static boolean parseBooleanExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i< expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch != ')' && ch != ',') {
                stack.push(ch);
            } else {
               if (ch == ')') {
                   ArrayList<Character> list = new ArrayList<>();
                   while (!stack.isEmpty() && stack.peek() != '(') {
                       list.add(stack.pop());
                   }
                   stack.pop();
                   char op = stack.pop();
                   char ans = evaluate(list,op);
                   stack.push(ans);
               }
            }
        }
        return stack.peek() == 't';
    }

    private static char evaluate(ArrayList<Character> list, char op) {
        if (op == '|') {
            if (list.contains('t')) {
                return 't';
            } else {
                return 'f';
            }
        } else if(op == '&') {
            if (list.contains('f')) {
                return 'f';
            } else {
                return 't';
            }
        } else {
            return (list.get(0)=='t') ? 'f':'t';
        }
    }

    public static void main(String[] args) {
        System.out.println(parseBooleanExpr("!(f)")); // Expected output: true
        System.out.println(parseBooleanExpr("|(f,t)")); // Expected output: true
        System.out.println(parseBooleanExpr("&(t,f)")); // Expected output: false
        System.out.println(parseBooleanExpr("|(&(t,f,t),!(t))")); // Expected output: false
    }
}
