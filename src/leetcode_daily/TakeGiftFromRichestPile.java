package leetcode_daily;

import java.util.Collections;
import java.util.PriorityQueue;

public class TakeGiftFromRichestPile {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int gift : gifts) {
            pq.add(gift);
        }

        for (int i = 0; i < k; i++) {
            int currMax = pq.poll();
            int leftOver = (int) Math.floor(Math.sqrt(currMax));
            pq.add(leftOver);
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }


    public static void main(String[] args) {
        TakeGiftFromRichestPile solution = new TakeGiftFromRichestPile();

        // Example 1
        int[] gifts1 = {25, 64, 9, 4, 100};
        int k1 = 4;
        System.out.println(solution.pickGifts(gifts1, k1)); // Output: 29

        // Example 2
        int[] gifts2 = {1, 1, 1, 1};
        int k2 = 4;
        System.out.println(solution.pickGifts(gifts2, k2)); // Output: 4
    }
}
