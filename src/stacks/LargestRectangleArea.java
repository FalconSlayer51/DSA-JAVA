package stacks;

import java.util.Stack;

public class LargestRectangleArea {
    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        int[] nextSmaller = findNextSmaller(heights);
        int[] previousSmaller = findPrevSmaller(heights);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int w = nextSmaller[i] - previousSmaller[i] -1;
            max = Math.max(max,h*w);
        }

        return max;
    }

    private static int[] findNextSmaller(int[] heights) {
        int[] res = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = heights.length - 1; i >=0 ; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()){
                res[i] = heights.length;
            } else {
                res[i] = stack.peek();
            }

            stack.push(i);
        }
        return res;
    }

    private static int[] findPrevSmaller(int[] heights) {
        int[] res = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length ; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()){
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }

            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println("Test case 1: " + (largestRectangleArea(heights1) == 10));

        // Test case 2: Single bar
        int[] heights2 = {2};
        System.out.println("Test case 2: " + (largestRectangleArea(heights2) == 2));

        // Test case 3: All bars of the same height
        int[] heights3 = {2, 2, 2, 2};
        System.out.println("Test case 3: " + (largestRectangleArea(heights3) == 8));

        // Test case 4: Decreasing heights
        int[] heights4 = {6, 5, 4, 3, 2, 1};
        System.out.println("Test case 4: " + (largestRectangleArea(heights4) == 12));

        // Test case 5: Empty array
        int[] heights5 = {};
        System.out.println("Test case 5: " + (largestRectangleArea(heights5) == 0));
    }
}
