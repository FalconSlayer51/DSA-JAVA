package leetcode_daily;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class CountVowelStringInRange {

    private boolean isVowel(char ch) {
        HashSet<Character> vowels = new HashSet<>();
        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u');
        return vowels.contains(ch);
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] result = new int[queries.length];

        int[] vowArray = new int[n];
        for (int i = 0; i < n; i++) {
            String currentWord = words[i];
            if (isVowel(currentWord.charAt(0)) && isVowel(currentWord.charAt(currentWord.length()-1))) {
                vowArray[i] = 1;
            } else {
                vowArray[i] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            vowArray[i] += vowArray[i-1];
        }

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            if (left == 0) {
                result[i] = vowArray[right];
            } else {
                result[i] = vowArray[right] - vowArray[left-1];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words1 = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries1 = {{0, 2}, {1, 4}, {1, 1}};
        CountVowelStringInRange solution = new CountVowelStringInRange();
        System.out.println(Arrays.toString(solution.vowelStrings(words1, queries1))); // Output: [2, 3, 0]

        String[] words2 = {"a", "e", "i"};
        int[][] queries2 = {{0, 2}, {0, 1}, {2, 2}};
        System.out.println(Arrays.toString(solution.vowelStrings(words2, queries2))); // Output: [3, 2, 1]
    }
}
