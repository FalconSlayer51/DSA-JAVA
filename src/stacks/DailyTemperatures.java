package stacks;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int currentElement = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] < currentElement) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result1 = dailyTemperatures(temperatures1);
        System.out.println(Arrays.toString(result1)); // Expected output: [1, 1, 4, 2, 1, 1, 0, 0]

        int[] temperatures2 = {30, 40, 50, 60};
        int[] result2 = dailyTemperatures(temperatures2);
        System.out.println(Arrays.toString(result2)); // Expected output: [1, 1, 1, 0]

        int[] temperatures3 = {30, 60, 90};
        int[] result3 = dailyTemperatures(temperatures3);
        System.out.println(Arrays.toString(result3)); // Expected output: [1, 1, 0]

        int[] temperatures4 = {90, 80, 70, 60};
        int[] result4 = dailyTemperatures(temperatures4);
        System.out.println(Arrays.toString(result4)); // Expected output: [0, 0, 0, 0]

        int[] temperatures5 = {70, 70, 70, 70};
        int[] result5 = dailyTemperatures(temperatures5);
        System.out.println(Arrays.toString(result5)); // Expected output: [0, 0, 0, 0]
    }
}

