package leetcode_daily;

import java.util.HashSet;

public class MinimumCostForTickets {
    private int[] dp = new int[366];
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> set = new HashSet<>();
        for (int day: days) {
            set.add(day);
        }

        int lastDay = days[days.length-1];
        int[] dp = new int[lastDay+1];
        dp[0] = 0;
        for (int i = 1; i <= lastDay; i++) {
            if(!set.contains(i)) {
                dp[i] = dp[i-1];
                continue;
            }

            dp[i] = Integer.MAX_VALUE;

            int day1Pass = dp[Math.max(0,i-1)] + costs[0];

            int day7Pass = dp[Math.max(0,i-7)] + costs[1];

            int day30Pass = dp[Math.max(0,i-30)] + costs[2];

            dp[i] = Math.min(Math.min(day1Pass,day7Pass),day30Pass);
        }

        return dp[lastDay];
    }

    private int solve(int[] days, int[] costs, int idx, int n) {
        if (idx >= n) return 0;

        if (dp[idx] != -1) return dp[idx];

        int cost_1 = costs[0] + solve(days, costs, idx + 1, n);

        int i = idx;
        while (i < n && days[i] < days[idx]+7) {
            i++;
        }

        int cost_7 = costs[1] + solve(days, costs, i, n);

        int j = idx;
        while (j < n && days[j] < days[idx]+30) {
            j++;
        }

        int cost_30 = costs[2] + solve(days, costs, j, n);

        dp[idx] = Math.min(Math.min(cost_1, cost_7), cost_30);

        return dp[idx];
    }

    public static void main(String[] args) {
        int[] days1 = {1, 4, 6, 7, 8, 20};
        int[] costs1 = {2, 7, 15};
        System.out.println("Example 1 Output: " + new MinimumCostForTickets().mincostTickets(days1, costs1)); // Output: 11

        int[] days2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] costs2 = {2, 7, 15};
        System.out.println("Example 2 Output: " + new MinimumCostForTickets().mincostTickets(days2, costs2)); // Output: 17
    }
}
