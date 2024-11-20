/*
 * Optimization :
 * To find max in O(N) in this problem, pre-computed the max at each index of the array.
 * */

package leetcode_daily;

import java.util.Arrays;


public class MostBeautifulItem {
    public static int[] maximumBeauty(int[][] items, int[] queries) {
        int n = queries.length;
        int[] result = new int[n];

        Arrays.sort(items,(a,b) -> Integer.compare(a[0],b[0]));

        int[] prices = new int[items.length];
        int[] beauty = new int[items.length];

        for (int i = 0;i< items.length;i++) {
            prices[i] = items[i][0];
            beauty[i] = items[i][1];
        }


        int maxBeauty = beauty[0];
        for (int i = 0;i<items.length;i++){
            maxBeauty = Math.max(maxBeauty,beauty[i]);
            beauty[i] = maxBeauty;
        }

        for (int i = 0; i < n; i++) {
            int index = getLastIndexLessThanOrEqualToK(prices,queries[i]);
            if (index == -1) {
                result[i] = 0;
                continue;
            }
            result[i] = beauty[index];
        }

        return result;
    }


    public static int getLastIndexLessThanOrEqualToK(int[] prices,int target) {
        int start = 0;
        int end = prices.length -1;
        int result = -1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            if (prices[mid] <= target) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] items1 = {{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}};
        int[] queries1 = {1, 2, 3, 4, 5, 6};
        int[] result1 = maximumBeauty(items1, queries1);
        System.out.println(Arrays.toString(result1)); // Output: [2, 4, 5, 5, 6, 6]

        // Example 2
        int[][] items2 = {{1, 2}, {1, 2}, {1, 3}, {1, 4}};
        int[] queries2 = {1};
        int[] result2 = maximumBeauty(items2, queries2);
        System.out.println(Arrays.toString(result2)); // Output: [4]

        // Example 3
        int[][] items3 = {{10, 1000}};
        int[] queries3 = {5};
        int[] result3 = maximumBeauty(items3, queries3);
        System.out.println(Arrays.toString(result3)); // Output: [0]
    }
}
