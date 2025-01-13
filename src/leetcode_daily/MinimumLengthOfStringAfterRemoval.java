package leetcode_daily;

import java.util.HashMap;

public class MinimumLengthOfStringAfterRemoval {
    public int minimumLength(String s) {
        int n = s.length();
        HashMap<Character, Integer> charToFreq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            charToFreq.put(ch,charToFreq.getOrDefault(ch,0)+1);
        }

        System.out.println(charToFreq);
        int len = 0;
        for (char ch : charToFreq.keySet()) {
            int freq = charToFreq.get(ch);
            if ( freq >= 3) {
                int lenToSub = freq % 2 != 0 ? 1 : 2;
                len += freq - lenToSub;
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
