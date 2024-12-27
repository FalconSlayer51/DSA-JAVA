package leetcode_daily;

public class BestSightSeeingPair {
    public int maxScoreSightSeeingSpot(int[] values) {
        int result = 0;
        int currentMax = values[0] -1;

        for (int i = 1; i < values.length; i++) {
            result = Math.max(result,currentMax+values[i]);
            currentMax = Math.max(currentMax-1,values[i]-1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] values1 = {8, 1, 5, 2, 6};
        int[] values2 = {1, 2};

        BestSightSeeingPair pair = new BestSightSeeingPair();
        System.out.println(pair.maxScoreSightSeeingSpot(values1)); // Output: 11
        System.out.println(pair.maxScoreSightSeeingSpot(values2)); // Output: 2
    }
}
