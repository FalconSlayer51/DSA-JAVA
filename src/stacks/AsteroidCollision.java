package stacks;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int currElement = asteroids[i];

            if(stack.isEmpty() || currElement > 0) {
                stack.push(currElement);
            } else {
                while (!stack.isEmpty()) {
                    int top = stack.peek();
                    if(top < 0) {
                        stack.push(currElement);
                        break;
                    }

                    int modVal = Math.abs(currElement);
                    if (modVal == top) {
                        stack.pop();
                        break;
                    } else if (modVal < top) {
                        break;
                    } else {
                        stack.pop();
                        if (stack.isEmpty()) {
                            stack.push(currElement);
                            break;
                        }
                    }
                }
            }
        }

        int res[] = new int[stack.size()];
        for (int i = stack.size() -1; i >=0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] result1 = asteroidCollision(new int[]{5, 10, -5});
        System.out.println(Arrays.toString(result1)); // Expected output: [5, 10]

        int[] result2 = asteroidCollision(new int[]{8, -8});
        System.out.println(Arrays.toString(result2)); // Expected output: []

        int[] result3 = asteroidCollision(new int[]{10, 2, -5});
    }

    public static class RemoveStars {
        public static String removeStars(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch != '*') {
                    stack.push(ch);
                } else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                }
            }
    
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.insert(0,stack.pop());
            }
    
            return sb.toString();
        }
        public static void main(String[] args) {
            String s1 = "leet**cod*e";
            System.out.println(removeStars(s1)); // Expected output: "lecoe"
    
            // Test case 2
            String s2 = "erase*****";
            System.out.println(removeStars(s2)); // Expected output: ""
    
            // Additional test cases
            String s3 = "a*b*c*";
            System.out.println(removeStars(s3)); // Expected output: ""
    
            String s4 = "ab**c*d*";
            System.out.println(removeStars(s4)); // Expected output: ""
    
            String s5 = "abc*de*f*";
            System.out.println(removeStars(s5));
        }
    }
}
