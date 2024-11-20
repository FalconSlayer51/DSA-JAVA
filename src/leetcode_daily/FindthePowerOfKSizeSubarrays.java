package leetcode_daily;

public class FindthePowerOfKSizeSubarrays {
    public int[] resultsArray(int[] nums,int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];

        for (int i = 0; i <= n-k; i++) {
            boolean isConsecutiveAndSorted = true;
            for (int j = i; j < i+k-1; j++) {
                if(nums[j+1] != nums[j]+1) {
                    isConsecutiveAndSorted = false;
                    break;
                }
            }

            if (isConsecutiveAndSorted) {
                result[i] = nums[i + k - 1];
            } else {
                result[i] = -1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindthePowerOfKSizeSubarrays solution = new FindthePowerOfKSizeSubarrays();

        // Test case 1
        int[] nums1 = {1, 2, 3, 4, 3, 2, 5};
        int k1 = 3;
        int[] result1 = solution.resultsArray(nums1, k1);
        System.out.println(java.util.Arrays.toString(result1)); // Output: [3, 4, -1, -1, -1]

        // Test case 2
        int[] nums2 = {2, 2, 2, 2, 2};
        int k2 = 4;
        int[] result2 = solution.resultsArray(nums2, k2);
        System.out.println(java.util.Arrays.toString(result2)); // Output: [-1, -1]

        // Test case 3
        int[] nums3 = {3, 2, 3, 2, 3, 2};
        int k3 = 2;
        int[] result3 = solution.resultsArray(nums3, k3);
        System.out.println(java.util.Arrays.toString(result3)); // Output: [-1, 3, -1, 3, -1]
    }
}
