package leetcode_daily;

import java.util.PriorityQueue;


public class FindScoreMarkingAllElements {
    public long findScore(int[] nums) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if (a[0] == b[0])
                return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{nums[i],i});
        }

        boolean[] marked = new boolean[n];
        long score = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currentElement = curr[0];
            int index = curr[1];

            if (!marked[index]) {
                score += currentElement;
                if (index > 0)
                    marked[index-1] = true;
                if (index < n-1)
                    marked[index+1] = true;
            }
        }

        return score;
    }

    public static void main(String[] args) {
        FindScoreMarkingAllElements sol = new FindScoreMarkingAllElements();
        System.out.println(sol.findScore(new int[]{2, 1, 3, 4, 5, 2})); // Output: 7
        System.out.println(sol.findScore(new int[]{2,5,6,6,10})); // Output: 18
    }
}
