package leetcode_daily;

public class CountWordsWithGivenPrefix {
    public int prefixCount(String[] words, String pref) {
        int n = words.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (words[i].startsWith(pref)) {
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountWordsWithGivenPrefix cwgp = new CountWordsWithGivenPrefix();

        String[] words1 = {"pay", "attention", "practice", "attend"};
        String pref1 = "at";
        System.out.println(cwgp.prefixCount(words1, pref1)); // Output: 2

        String[] words2 = {"leetcode", "win", "loops", "success"};
        String pref2 = "code";
        System.out.println(cwgp.prefixCount(words2, pref2)); // Output: 0
    }
}
