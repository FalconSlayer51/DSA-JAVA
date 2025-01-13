package leetcode_daily;

import java.util.HashMap;

public class MinimumLengthOfStringAfterRemoval {
    public int minimumLength(String s) {
        int n = s.length();
        int[] freq = new int[26];

        for(char ch : s.toCharArray()) {
            freq[ch - 'a'] ++;
        }

        int len = 0;
        for(int i = 0; i < 26; i++) {
            int count = freq[i];
            if (count >= 3) {
                int lenToSub = count % 2 != 0 ? 1 : 2;
                len += count - lenToSub;
            }
        }
        return n - len;
    }

    public static void main(String[] args) {
        MinimumLengthOfStringAfterRemoval solution = new MinimumLengthOfStringAfterRemoval();

        // Example 1
        String s1 = "abaacbcbb";
        int result1 = solution.minimumLength(s1);
        System.out.println("Input: " + s1 + "\nOutput: " + result1); // Expected output: 5

        // Example 2
        String s2 = "aa";
        int result2 = solution.minimumLength(s2);
        System.out.println("Input: " + s2 + "\nOutput: " + result2); // Expected output: 2

    }
}
