package leetcode_daily;


public class NeighboringBitwiseOr {

    public boolean doesValidArrayExist1(int[] derived) {
        int n = derived.length;
        int[] original = new int[n];

        original[0] = 0;
        for (int i = 0; i < n-1; i++) {
            original[i+1] = derived[i] ^ original[i];
        }

        if((original[n-1] ^ original[0]) == derived[n-1]) return true;

        original[0] = 1;
        for (int i = 0; i < n-1; i++) {
            original[i+1] = derived[i] ^ original[i];
        }

        if((original[n-1] ^ original[0]) == derived[n-1]) return true;

        return false;
    }
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
            boolean result = solution.doesValidArrayExist1(testCases[i]);
            System.out.println("Test case " + (i + 1) + ": " + (result == expectedResults[i] ? "Passed" : "Failed"));
        }
    }
}
