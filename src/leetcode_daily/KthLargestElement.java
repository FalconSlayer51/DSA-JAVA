package leetcode_daily;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {
    public static int findKthLargest(int[] nums,int k) {
        Queue<Integer> heap = new PriorityQueue<>();
        for (int num: nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.peek();
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println(findKthLargest(nums1, k1)); // Output: 5

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println(findKthLargest(nums2, k2)); // Output: 4
    }
}
