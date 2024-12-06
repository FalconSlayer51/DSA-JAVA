package leetcode_daily;

import java.util.HashSet;

public class MaximumNoOfIntegersToChoseFromRange {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : banned) {
            set.add(num);
        }
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) continue;
            if (sum + i <= maxSum) {
                sum+=i;
                count++;
            } else {
                break;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        MaximumNoOfIntegersToChoseFromRange solution = new MaximumNoOfIntegersToChoseFromRange();

        int[] banned1 = {1, 6, 5};
        int n1 = 5;
        int maxSum1 = 6;
        System.out.println(solution.maxCount(banned1, n1, maxSum1)); // Expected output: 2

        int[] banned2 = {1, 2, 3, 4, 5, 6, 7};
        int n2 = 8;
        int maxSum2 = 1;
        System.out.println(solution.maxCount(banned2, n2, maxSum2)); // Expected output: 0

        int[] banned3 = {11};
        int n3 = 7;
        int maxSum3 = 50;
        System.out.println(solution.maxCount(banned3, n3, maxSum3)); // Expected output: 7
    }
}
