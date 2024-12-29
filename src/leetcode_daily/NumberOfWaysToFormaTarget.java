package leetcode_daily;

import java.util.Arrays;

public class NumberOfWaysToFormaTarget {
    public int numWays(String[] words, String target) {
        int wordLength = words[0].length();
        int[][] charFreq = new int[wordLength][26];

        for (String word: words) {
            for (int i = 0; i < word.length(); i++) {
                int charIndex = word.charAt(i) - 'a';
                charFreq[i][charIndex]++;
            }
        }

        long[][] dp = new long[wordLength+1][target.length()+1];
        for (int i = 0; i < wordLength+1; i++) {
            Arrays.fill(dp[i],-1);
        }

        return (int) recursion(0,0,charFreq,target,words,dp);
    }

    private long recursion(int wordIndex, int targetIndex, int[][] charFreq, String target, String[] words,long[][] dp) {
        if (targetIndex == target.length()) {
            dp[wordIndex][targetIndex] = 1;
            return 1;
        }
        if (wordIndex == words[0].length()) {
            dp[wordIndex][targetIndex] = 0;
            return 0;
        }
        if ((target.length() - targetIndex) > (words[0].length() - wordIndex)) {
            dp[wordIndex][targetIndex] = 0;
            return 0;
        }

        if (dp[wordIndex][targetIndex] != -1) {
            return dp[wordIndex][targetIndex];
        }

        int currIndex = target.charAt(targetIndex) - 'a';
        int freq = charFreq[wordIndex][currIndex];

        long pick = freq * recursion(wordIndex+1,targetIndex+1,charFreq,target,words,dp);
        long noPick = recursion(wordIndex+1,targetIndex,charFreq,target,words,dp);
        long res = (pick + noPick) % 1000000007;
        dp[wordIndex][targetIndex] = res;
        return res;
    }

    public static void main(String[] args) {
        String target1 = "aba";
        String[] words1 = {"acca", "bbbb", "caca"};
        System.out.println(new NumberOfWaysToFormaTarget().numWays(words1, target1)); // Output: 6

        String[] words2 = {"abba", "baab"};
        String target2 = "bab";
        System.out.println(new NumberOfWaysToFormaTarget().numWays(words2, target2));
    }
}
