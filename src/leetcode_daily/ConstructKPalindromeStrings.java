package leetcode_daily;

public class ConstructKPalindromeStrings {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (n == k) return true;
        if (n < k) return false;

        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch-'a'] ++;
        }

        int oddCount = 0;
        for (int countVal: count) {
            if (countVal % 2 != 0) oddCount++;
        }

        return oddCount <= k;
    }

    public static void main(String[] args) {
        // Example 1
        System.out.println(new ConstructKPalindromeStrings().canConstruct("annabelle", 2)); // true

        // Example 2
        System.out.println(new ConstructKPalindromeStrings().canConstruct("leetcode", 3)); // false

        // Example 3
        System.out.println(new ConstructKPalindromeStrings().canConstruct("true", 4)); // true
    }
}
