package leetcode_daily;


public class ShortestSubArrayWithOrAtleastK {
    public static int minimumSubarrayLength(int[] nums,int k) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int[] arr = new int[32]; // arr[i] = total no of set bits in ith position
        while (j < n) {
            update(arr,nums[j],1);
            while (i <= j && getDecimal(arr) >= k) {
                result = Math.min(result,j-i+1);
                update(arr,nums[i],-1);
                i++;
            }
            j++;
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int getDecimal(int[] arr) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (arr[i] > 0){
                result |= (1 << i);
            }
        }
        return result;
    }

    private static void update(int[] arr,int num,int val) {
        for (int i = 0; i < 32; i++) {
            if (((num >> i) & 1) != 0) {
                arr[i] += val;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int k1 = 2;
        System.out.println(minimumSubarrayLength(nums1, k1)); // Output: 1

         //Test case 2
        int[] nums2 = {2, 1, 8};
        int k2 = 10;
        System.out.println(minimumSubarrayLength(nums2, k2)); // Output: 3

        // Test case 3
        int[] nums3 = {2,1,9,12};
        int k3 = 21;
        System.out.println(minimumSubarrayLength(nums3, k3)); // Output: 1
    }
}
