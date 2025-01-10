package leetcode_daily;

import java.util.ArrayList;
import java.util.List;

public class WordSubSets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] bMax = count("");
        for (String word: words2) {
            int[] bCount = count(word);
            for (int i = 0; i < 26; i++) {
                bMax[i] = Math.max(bMax[i],bCount[i]);
            }
        }

        List<String> result = new ArrayList<>();
        search: for (String word: words1) {
            int[] aCount = count(word);
            for (int i = 0; i < 26; i++) {
                if (bMax[i] > aCount[i])
                    continue search;
            }
            result.add(word);
        }

        return result;
    }

    private int[] count(String s) {
        int[] count = new int[26];
        for(char ch : s.toCharArray()) {
            count[ch-'a'] ++;
        }
        return count;
    }

    public static void main(String[] args) {
        WordSubSets ws = new WordSubSets();

        // Example 1
        String[] words1_1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] words2_1 = {"e", "o"};
        System.out.println(ws.wordSubsets(words1_1, words2_1)); // Output: ["facebook", "google", "leetcode"]

        // Example 2
        String[] words1_2 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] words2_2 = {"l", "e"};
        System.out.println(ws.wordSubsets(words1_2, words2_2)); // Output: ["apple", "google", "leetcode"]
    }
}
