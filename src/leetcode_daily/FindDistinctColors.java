package leetcode_daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindDistinctColors {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> ballToColor = new HashMap<>();
        HashMap<Integer,Integer> colorMap = new HashMap<>();
        int n = queries.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballToColor.containsKey(ball)) {
                int oldColor = ballToColor.get(ball);
                colorMap.put(oldColor, colorMap.get(oldColor) - 1);
                if (colorMap.get(oldColor) == 0) colorMap.remove(oldColor);
            }
            ballToColor.put(ball,color);
            colorMap.put(color,colorMap.getOrDefault(color,0)+1);

            result[i] = colorMap.size();
        }
        return result;
    }

    public static void main(String[] args) {
        int limit1 = 4;
        int[][] queries1 = {{1, 4}, {2, 5}, {1, 3}, {3, 4}};
        FindDistinctColors fdc1 = new FindDistinctColors();
        System.out.println(Arrays.toString(fdc1.queryResults(limit1, queries1))); // Output: [1, 2, 2, 3]

        int limit2 = 4;
        int[][] queries2 = {{0, 1}, {1, 2}, {2, 2}, {3, 4}, {4, 5}};
        FindDistinctColors fdc2 = new FindDistinctColors();
        System.out.println(Arrays.toString(fdc2.queryResults(limit2, queries2))); // Output: [1, 2, 2, 3, 4]
    }
}

