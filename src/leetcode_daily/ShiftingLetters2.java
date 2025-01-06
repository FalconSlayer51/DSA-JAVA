package leetcode_daily;

public class ShiftingLetters2 {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] stringArray = new int[n];

        for (int i = 0; i < shifts.length; i++) {
            int start = shifts[i][0];
            int end = shifts[i][1];
            int dir = shifts[i][2];

            int x;
            if (dir == 0)
                x = -1;
            else
                x = 1;

            stringArray[start] += x;
            if (end +1 < n)
                stringArray[end + 1] -= x;
        }


        // calculate cum sum
        for (int i = 1; i < n; i++) {
            stringArray[i] += stringArray[i-1];
        }


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int shift = stringArray[i] % 26;
            if (shift < 0) {
                shift += 26;
            }
            char newChar = (char) (((s.charAt(i) - 'a' + shift) % 26) + 'a');
            sb.append(newChar);
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
