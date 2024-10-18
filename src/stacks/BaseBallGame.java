package stacks;

import java.util.Stack;

public class BaseBallGame {
    public static int calPoints(String[] operations) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < operations.length; i++) {
            String currStr = operations[i];
            if(!currStr.equals("C") && !currStr.equals("D") && !currStr.equals("+")) {
                stack.push(currStr);
            } else {
                if (currStr.equals("C")) {
                    stack.pop();
                } else if (currStr.equals("D")) {
                    int value = Integer.parseInt(stack.peek());
                    stack.push(Integer.toString(value*2));
                } else {
                    int val1 = Integer.parseInt(stack.peek());
                    int val2 = Integer.parseInt(stack.get(stack.size() -2));

                    stack.push(Integer.toString(val1+val2));
                }
            }
        }



        int sum = 0;
        while (!stack.isEmpty()) {
            sum += Integer.parseInt(stack.pop());
        }

        return sum;
    }

    public static void main(String[] args) {
        String[] ops1 = {"5", "2", "C", "D", "+"};
        System.out.println(calPoints(ops1)); // Expected output: 30

        // Test case 2
        String[] ops2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(calPoints(ops2)); // Expected output: 27
    }
}
