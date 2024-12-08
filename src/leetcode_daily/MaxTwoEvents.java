package leetcode_daily;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxTwoEvents {

    public int maxTwoEvents(int[][] events) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        Arrays.sort(events,(a,b) -> Integer.compare(a[0],b[0]));

        int prevMax = 0;
        int result = 0;

        for (int[] event : events) {
            while (!pq.isEmpty() && pq.peek()[1] < event[0]) {
                prevMax = Math.max(prevMax,pq.peek()[2]);
                pq.poll();
            }
            result = Math.max(result,prevMax+event[2]);
            pq.offer(event);
        }

        return result;
    }


    private int binarySearch(int[] startTimes,int target) {
        int start = 0;
        int end = startTimes.length - 1;

        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target <= startTimes[mid]) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaxTwoEvents solution = new MaxTwoEvents();

        int[][] events1 = {{1, 3, 2}, {4, 5, 2}, {2, 4, 3}};
        System.out.println(solution.maxTwoEvents(events1)); // Expected output: 4

        int[][] events2 = {{1, 3, 2}, {4, 5, 2}, {1, 5, 5}};
        System.out.println(solution.maxTwoEvents(events2)); // Expected output: 5

        int[][] events3 = {{1, 5, 3}, {1, 5, 1}, {6, 6, 5}};
        System.out.println(solution.maxTwoEvents(events3)); // Expected output: 8
    }
}
