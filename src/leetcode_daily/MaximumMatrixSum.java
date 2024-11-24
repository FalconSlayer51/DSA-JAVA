package leetcode_daily;

public class MaximumMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        long minNegNumber = Integer.MAX_VALUE;
        int negativeNumCount = 0;
        for (int[] nums: matrix) {
            for (int num: nums) {
                int eleAbs = Math.abs(num);
                if (num < 0) {
                    negativeNumCount ++;
                }
                minNegNumber = Math.min(minNegNumber, eleAbs);
                sum += eleAbs;
            }
        }

        return (negativeNumCount % 2 == 0) ? sum : sum - (2*minNegNumber);
    }

    public static void main(String[] args) {
        MaximumMatrixSum solution = new MaximumMatrixSum();

        int[][] matrix1 = {{1, -1}, {-1, 1}};
        System.out.println("Example 1 Output: " + solution.maxMatrixSum(matrix1)); // Output: 4

        int[][] matrix2 = {{1, 2, 3}, {-1, -2, -3}, {1, 2, 3}};
        System.out.println("Example 2 Output: " + solution.maxMatrixSum(matrix2)); // Output: 16
    }
}
