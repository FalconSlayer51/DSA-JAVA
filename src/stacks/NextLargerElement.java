package stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextLargerElement {
    public static int[] nextLargerElement(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];

        for (int i = n-1;i >=0;i--) {
            int currentElement = arr[i];
            while(!stack.isEmpty() && stack.peek()<currentElement) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }

            stack.push(currentElement);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 2, 25};
        int[] result1 = nextLargerElement(arr1);
        System.out.println(Arrays.toString(result1)); // Expected output: [5, 25, 25, -1]

        int[] arr2 = {13, 7, 6, 12};
        int[] result2 = nextLargerElement(arr2);
        System.out.println(Arrays.toString(result2)); // Expected output: [-1, 12, 12, -1]

        int[] arr3 = {6, 8, 0, 1, 3};
        int[] result3 = nextLargerElement(arr3);
        System.out.println(Arrays.toString(result3)); // Expected output: [8, -1, 1, 3, -1]
    }
}
