package stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        int n1 = nums1.length;
        int n2 = nums2.length;

        for (int i = n2-1; i >=0 ; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                map.put(nums2[i], stack.peek());
            } else {
                map.put(nums2[i], -1);
            }

            stack.push(nums2[i]);
        }

        int[] ans = new int[n1];
        for (int i = 0; i < n1; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        NextGreaterElement1 solution = new NextGreaterElement1();

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result1 = solution.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result1)); // Output: [-1, 3, -1]

        int[] nums1_2 = {2, 4};
        int[] nums2_2 = {1, 2, 3, 4};
        int[] result2 = solution.nextGreaterElement(nums1_2, nums2_2);
        System.out.println(Arrays.toString(result2)); // Output: [3, -1]
    }
}
