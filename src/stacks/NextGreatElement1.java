package stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class NextGreatElement1 {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums2.length];

        for (int i = n-1; i >= 0 ; i--) {
            int currentElement = nums2[i];
            while (!stack.isEmpty() && stack.peek() < currentElement) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = currentElement;
            }

            stack.push(currentElement);
        }
        return res;
    }

    private static int findIndex(int[] array, int target) {
        return IntStream.range(0, array.length)
                .filter(i -> array[i] == target)
                .findFirst()
                .orElse(-1);  // Returns -1 if not found
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = nextGreaterElement(nums1, nums2);
        //System.out.println(Arrays.toString(result)); // Output: [-1, 3, -1]

//        nums1 = new int[]{2, 4};
//        nums2 = new int[]{1, 2, 3, 4};
//        result = nextGreaterElement(nums1, nums2);
//        System.out.println(Arrays.toString(result)); // Output: [3, -1]
    }
}
