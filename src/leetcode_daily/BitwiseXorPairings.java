package leetcode_daily;

public class BitwiseXorPairings {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if ((m % 2 == 0) && (n % 2 == 0)) {
            return 0;
        }

        int res = 0;
        if (m % 2 != 0) {
            for (int num : nums2) {
                res ^= num;
            }
        }
        if (n % 2 != 0) {
            for (int num : nums1) {
                res ^= num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1Example1 = {2, 1, 3};
        int[] nums2Example1 = {10, 2, 5, 0};
        int[] nums1Example2 = {25, 29, 3, 10, 0, 15, 2};
        int[] nums2Example2 = {12};

        BitwiseXorPairings solution = new BitwiseXorPairings();

        System.out.println("Example 1 Output: " + solution.xorAllNums(nums1Example1, nums2Example1)); // Output: 13
        System.out.println("Example 2 Output: " + solution.xorAllNums(nums1Example2, nums2Example2)); // Output: 0
    }
}
