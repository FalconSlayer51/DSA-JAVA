package leetcode_daily;

public class MakeStringSubsequenceUsingCyclicIncrements {
    public boolean canMakeSubsequence(String str1,String str2) {
        int m = str1.length();
        int n = str2.length();

        int i = 0, j = 0;
        while (i < m && j < n) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(j);
            if (ch1 == ch2 || ch1 + 1 == ch2 || ch1-25 == ch2) {
                j++;
            }
            i ++;
        }

        return j==n;
    }

    public static void main(String[] args) {
        // Example 1
        MakeStringSubsequenceUsingCyclicIncrements sol = new MakeStringSubsequenceUsingCyclicIncrements();
        System.out.println(sol.canMakeSubsequence("abc", "ad")); // true

        // Example 2
        System.out.println(sol.canMakeSubsequence("zc", "ad")); // true

        // Example 3
        System.out.println(sol.canMakeSubsequence("ab", "d")); // false
    }
}
