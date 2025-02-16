package leetcode_daily;

import java.util.Arrays;

public class ConstructLexicoGraphicallyLargestValidSequence {
    public int[] constructDistancedSequence(int n) {
        boolean[] used = new boolean[n + 1];
        int[] seq = new int[(2 * n) - 1];
        backtrack(0, used, seq, n);
        return seq;
    }

    private boolean backtrack(int i, boolean[] used, int[] seq, int n) {
        while (i < seq.length && seq[i] != 0) {
            i++;
        }
        if (i == seq.length) return true;
        for (int j = n; j >= 1; j--) {
            if (used[j]) continue;
            if (j == 1) {
                seq[i] = j;
                used[j] = true;
                if (backtrack(i + 1, used, seq, n)) {
                    return true;
                }
                seq[i] = 0;
                used[j] = false;
            } else if (i + j < seq.length && seq[i + j] == 0) {
                seq[i] = j;
                seq[i + j] = j;
                used[j] = true;
                if (backtrack(i + 1, used, seq, n)) {
                    return true;
                }
                seq[i] = 0;
                seq[i + j] = 0;
                used[j] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] result1 = new ConstructLexicoGraphicallyLargestValidSequence().constructDistancedSequence(3);
        System.out.println(Arrays.toString(result1)); // Expected: [3, 1, 2, 3, 2]

        int[] result2 = new ConstructLexicoGraphicallyLargestValidSequence().constructDistancedSequence(5);
        System.out.println(Arrays.toString(result2)); // Expected: [5, 3, 1, 4, 3, 5, 2, 4, 2]
    }
}
