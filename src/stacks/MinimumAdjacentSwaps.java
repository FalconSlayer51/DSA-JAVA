package stacks;

public class MinimumAdjacentSwaps {
    public static int minimumNumberOfSwaps(String s) {
        int open =0,close = 0,unbalanced = 0,swaps=0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '[') {
                open++;
                if(unbalanced >0) {
                    swaps += unbalanced;
                    unbalanced--;
                }
            } else {
                close ++;
                unbalanced = close - open;
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        // Test cases for minimumNumberOfSwaps
        System.out.println(minimumNumberOfSwaps("][][")); // Expected output: 1
        System.out.println(minimumNumberOfSwaps("]]][[[")); // Expected output: 2
        System.out.println(minimumNumberOfSwaps("[]")); // Expected output: 0
        System.out.println(minimumNumberOfSwaps("[[]]")); // Expected output: 0
        System.out.println(minimumNumberOfSwaps("][[]")); // Expected output: 1
    }
}
