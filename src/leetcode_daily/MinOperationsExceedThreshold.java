package leetcode_daily;

import java.util.PriorityQueue;

public class MinOperationsExceedThreshold {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer((long) num);
        }

        int minOps = 0;
        while (pq.peek() < k) {
            long x = pq.peek() != null ? pq.poll() : 0;
            long y = pq.peek() != null ? pq.poll() : 0;

            long result = x * 2 + y;
            pq.offer(result);
            minOps++;
        }

        return minOps;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 11, 10, 1, 3};
        int k1 = 10;
        System.out.println(new MinOperationsExceedThreshold().minOperations(nums1, k1)); // Output: 2

        int[] nums2 = {1, 1, 2, 4, 9};
        int k2 = 20;
        System.out.println(new MinOperationsExceedThreshold().minOperations(nums2, k2)); // Output: 4
    }
}
