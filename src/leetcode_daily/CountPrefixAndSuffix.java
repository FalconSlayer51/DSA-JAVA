package leetcode_daily;

public class CountPrefixAndSuffix {
    private boolean isPrefixAndSuffix(String word1, String word2) {
        return word2.startsWith(word1) && word2.endsWith(word1);
    }

    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (isPrefixAndSuffix(words[i],words[j]))
                    count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountPrefixAndSuffix cps = new CountPrefixAndSuffix();

        String[] words1 = {"a", "aba", "ababa", "aa"};
        System.out.println(cps.countPrefixSuffixPairs(words1)); // Output: 4

        String[] words2 = {"pa", "papa", "ma", "mama"};
        System.out.println(cps.countPrefixSuffixPairs(words2)); // Output: 2

        String[] words3 = {"abab", "ab"};
        System.out.println(cps.countPrefixSuffixPairs(words3)); // Output: 0
    }
}
