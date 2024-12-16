package leetcode_daily;

import java.util.PriorityQueue;

public class FindArrayStateAfterKOperations {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });

        for (int i = 0; i < n; i++) {
            priorityQueue.add(new int[]{nums[i],i});
        }

        while (k-- > 0) {
            int[] currentArr = priorityQueue.poll();
            int minValue = currentArr[0];
            int idx = currentArr[1];

            nums[idx] = minValue * multiplier;
            priorityQueue.add(new int[]{minValue*multiplier,idx});
        }

        return nums;
    }

    public static void main(String[] args) {
        FindArrayStateAfterKOperations solution = new FindArrayStateAfterKOperations();

        int[] nums1 = {2, 1, 3, 5, 6};
        int k1 = 5;
        int multiplier1 = 2;
        int[] result1 = solution.getFinalState(nums1, k1, multiplier1);
        System.out.println(java.util.Arrays.toString(result1)); // Output: [8, 4, 6, 5, 6]

        int[] nums2 = {1, 2};
        int k2 = 3;
        int multiplier2 = 4;
        int[] result2 = solution.getFinalState(nums2, k2, multiplier2);
        System.out.println(java.util.Arrays.toString(result2)); // Output: [16, 8]
    }

}
