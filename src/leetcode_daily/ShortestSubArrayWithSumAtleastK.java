package leetcode_daily;


import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubArrayWithSumAtleastK {
    //BRUTE FORCE NOT GOING TO WORK
    //Solved using monotonic deque
    //Store index in deque
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;

        Deque<Integer> deque = new ArrayDeque<>(); //Stores index in monotonic increasing order of cumulative sum
        long[] cumulativeSum = new long[n];
        int j = 0;

        while (j < n){
            if (j==0) {
                cumulativeSum[j] = nums[j];
            }else {
                cumulativeSum[j] = cumulativeSum[j-1] + nums[j];
            }

            if (cumulativeSum[j] >= k) {
                result = Math.min(result,j+1);
            }

            while (!deque.isEmpty() && cumulativeSum[j] - cumulativeSum[deque.peek()] >= k) {
                result = Math.min(result,j-deque.peekFirst());
                deque.pollFirst();
            }

            while (!deque.isEmpty() && cumulativeSum[j] <= cumulativeSum[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(j);
            j++;
        }

        return result == Integer.MAX_VALUE ? -1: result;
    }
    public static void main(String[] args) {
        ShortestSubArrayWithSumAtleastK obj = new ShortestSubArrayWithSumAtleastK();
        int[] nums1 = {1};
        int k1 = 1;
        System.out.println(obj.shortestSubarray(nums1, k1)); // Output: 1

        int[] nums2 = {1, 2};
        int k2 = 4;
        System.out.println(obj.shortestSubarray(nums2, k2)); // Output: -1

        int[] nums3 = {2, -1, 2};
        int k3 = 3;
        System.out.println(obj.shortestSubarray(nums3, k3)); // Output: 3
    }
}
