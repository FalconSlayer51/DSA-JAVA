package leetcode_daily;

import java.util.Stack;

public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || stack.peek() < arr[i]) {
                stack.push(arr[i]);
                continue;
            }

            int maxElement = stack.peek();
            while (!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.pop();
            }
            stack.push(maxElement);
        }

        return stack.size();
    }

    public int maxChunksToSorted2(int[] arr) {
        int chunks = 0;
        int prevMax = 0;
        int n = arr.length;
        for (int i = 0; i< n ;i++) {
            prevMax = Math.max(prevMax,arr[i]);
            if(prevMax == i) {
                chunks++;
            }
        }

        return chunks;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 3, 2, 1, 0};
        int[] arr2 = {1, 0, 2, 3, 4};

        MaxChunksToMakeSorted solution = new MaxChunksToMakeSorted();

        System.out.println("Example 1:");
        System.out.println("Input: arr = [4, 3, 2, 1, 0]");
        System.out.println("Output: " + solution.maxChunksToSorted(arr1)); // Expected output: 1

        System.out.println("Example 2:");
        System.out.println("Input: arr = [1, 0, 2, 3, 4]");
        System.out.println("Output: " + solution.maxChunksToSorted(arr2)); // Expected output: 4
    }
}
