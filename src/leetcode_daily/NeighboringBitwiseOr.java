package leetcode_daily;


public class NeighboringBitwiseOr {
    public boolean doesValidArrayExist(int[] derived) {
        int xorSum = 0;
        for (int num : derived) {
            xorSum ^= num;
        }

        return xorSum == 0;
    }


    public static void main(String[] args) {
        int[][] testCases = {
                {1, 1, 0},
                {1, 1},
                {1, 0}
        };

        boolean[] expectedResults = {
                true,
                true,
                false
        };

        NeighboringBitwiseOr solution = new NeighboringBitwiseOr();

        for (int i = 0; i < testCases.length; i++) {
            boolean result = solution.doesValidArrayExist(testCases[i]);
            System.out.println("Test case " + (i + 1) + ": " + (result == expectedResults[i] ? "Passed" : "Failed"));
        }
    }
}
