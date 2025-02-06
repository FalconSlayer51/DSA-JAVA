package leetcode_daily;

import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productToTuple = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                productToTuple.put(product, productToTuple.getOrDefault(product, 0) + 1);
            }
        }

        int result = 0;
        for (int count : productToTuple.values()) {
            if (count >= 2) {
                int comb = (count * (count - 1)) / 2;
                result += comb * 8;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TupleWithSameProduct solution = new TupleWithSameProduct();

        int[] nums1 = {2, 3, 4, 6};
        System.out.println(solution.tupleSameProduct(nums1)); // Output: 8

        int[] nums2 = {1, 2, 4, 5, 10};
        System.out.println(solution.tupleSameProduct(nums2)); // Output: 16
    }
}
