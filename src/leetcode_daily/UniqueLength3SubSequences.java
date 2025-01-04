package leetcode_daily;

import java.util.HashSet;

public class UniqueLength3SubSequences {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(s.charAt(i));
        }

        int result = 0;
        for (char letter: set) {
            int leftIdx = -1;
            int rightIdx = -1;

            for (int i = 0; i < n; i++) {
                if (letter == s.charAt(i)) {
                    if (leftIdx == -1) {
                        leftIdx = i;
                    }

                    rightIdx = i;
                }
            }

            HashSet<Character> palinSet = new HashSet<>();
            for (int middle = leftIdx+1; middle <= rightIdx -1;middle++) {
                palinSet.add(s.charAt(middle));
            }

            result += palinSet.size();
        }

        return result;
    }

    public static void main(String[] args) {
        UniqueLength3SubSequences solution = new UniqueLength3SubSequences();

        // Example 1
        String s1 = "aabca";
        int result1 = solution.countPalindromicSubsequence(s1);
        System.out.println("Input: " + s1 + " Output: " + result1); // Expected: 3

        // Example 2
        String s2 = "adc";
        int result2 = solution.countPalindromicSubsequence(s2);
        System.out.println("Input: " + s2 + " Output: " + result2); // Expected: 0

        // Example 3
        String s3 = "bbcbaba";
        int result3 = solution.countPalindromicSubsequence(s3);
        System.out.println("Input: " + s3 + " Output: " + result3); // Expected: 4
    }
}
