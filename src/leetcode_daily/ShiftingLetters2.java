package leetcode_daily;

import java.util.Arrays;

public class ShiftingLetters2 {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] stringArray = new int[n];

        for (int i = 0; i < n; i++) {
            int strVal = s.charAt(i) - 'a';
            stringArray[i] = strVal;
        }

        for (int i = 0; i < shifts.length; i++) {
            int start = shifts[i][0];
            int end = shifts[i][1];
            int dir = shifts[i][2];

            for (int j = start; j <= end ; j++) {
                if (dir == 1) {
                    stringArray[j] += 1;
                } else {
                    stringArray[j] -= 1;
                    if(stringArray[j] < 0) {
                        stringArray[j] += 26;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(stringArray));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (stringArray[i] > 25) {
                stringArray[i] %= 26;
            }

            sb.append((char) (stringArray[i] + 'a'));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ShiftingLetters2 solution = new ShiftingLetters2();

        // Example 1
        String s1 = "abc";
        int[][] shifts1 = {{0, 1, 0}, {1, 2, 1}, {0, 2, 1}};
        System.out.println(solution.shiftingLetters(s1, shifts1)); // Output: "ace"

        // Example 2
        String s2 = "dztz";
        int[][] shifts2 = {{0, 0, 0}, {1, 1, 1}};
        System.out.println(solution.shiftingLetters(s2, shifts2)); // Output: "catz"
    }
}
