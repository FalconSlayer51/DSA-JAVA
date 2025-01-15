package leetcode_daily;

public class CountWaysToBuildStrings {
    public int countGoodStrings(int low, int high, int zero, int one) {
        // This is a dp solution
        int maxLen = high + Math.max(zero, one);
        int[] dp = new int[maxLen + 1];
        for (int len = high; len >= 0; len--) {
            int zeroLen = len + zero;
            int oneLen = len + one;

            int zeroCount = (zeroLen >= low && zeroLen <= high) ? 1 : 0;
            int oneCount = (oneLen >= low && oneLen <= high) ? 1 : 0;

            int res = zeroCount + dp[zeroLen] + oneCount + dp[oneLen];
            dp[len] = res % 1000000007;
        }

        return dp[0];
    }

    public static void main(String[] args) {
        CountWaysToBuildStrings solution = new CountWaysToBuildStrings();

        // Example 1
        int low1 = 3;
        int high1 = 3;
        int zero1 = 1;
        int one1 = 1;
        int result1 = solution.countGoodStrings(low1, high1, zero1, one1);
        System.out.println("Example 1 Output: " + result1); // Expected: 8

        // Example 2
        int low2 = 2;
        int high2 = 3;
        int zero2 = 1;
        int one2 = 2;
        int result2 = solution.countGoodStrings(low2, high2, zero2, one2);
        System.out.println("Example 2 Output: " + result2); // Expected: 5
    }
}
