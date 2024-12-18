package leetcode_daily;

import java.util.Arrays;
import java.util.Stack;

public class FinalPriceWithSpecialDiscount {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int n = prices.length;
        int[] monotonicResult = new int[n];

        for (int i = n-1 ; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }

            monotonicResult[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(prices[i]);
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (monotonicResult[i] == -1) {
                result[i] = prices[i];
                continue;
            }
            result[i] = prices[i] - monotonicResult[i];
        }

        return result;
    }

    public static void main(String[] args) {
        FinalPriceWithSpecialDiscount solution = new FinalPriceWithSpecialDiscount();

        int[] prices1 = {8, 4, 6, 2, 3};
        int[] result1 = solution.finalPrices(prices1);
        System.out.println(Arrays.toString(result1)); // Output: [4, 2, 4, 2, 3]

        int[] prices2 = {1, 2, 3, 4, 5};
        int[] result2 = solution.finalPrices(prices2);
        System.out.println(Arrays.toString(result2)); // Output: [1, 2, 3, 4, 5]

        int[] prices3 = {10, 1, 1, 6};
        int[] result3 = solution.finalPrices(prices3);
        System.out.println(Arrays.toString(result3)); // Output: [9, 0, 1, 6]
    }
}
