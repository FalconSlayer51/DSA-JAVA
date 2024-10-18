package leetcode_daily;

public class LongestHappyString {
    public static String longestDiverseString(int a,int b,int c) {
        int curra = 0, currb=0, currc=0;
        int totalIterations = a + b + c;
        StringBuilder string = new StringBuilder();

        for(int i = 0; i< totalIterations;i++) {
            if ((a >= b && a >=c && curra != 2) || (a>0&&(currb == 2 || currc == 2))) {
                string.append('a');
                a--;
                curra ++;
                currb =0;
                currc = 0;
            } else if((b >= a && b >=c && currb != 2) || (b>0 && (curra == 2 || currc == 2))) {
                string.append('b');
                b --;
                currb++;
                curra =0;
                currc = 0;
            } else if((c >= a && c>=b && currc != 2) ||(c > 0 && (curra == 2||currb==2))) {
                string.append('c');
                c --;
                currc ++;
                curra =0;
                currb = 0;
            }
        }

        return string.toString();
    }

    public static void main(String[] args) {
        // Test case 1: Equal number of a, b, and c
        System.out.println(longestDiverseString(1, 1, 1)); // Expected output: "abc", "acb", "bac", "bca", "cab", or "cba"

        // Test case 2: More a's than b's and c's
        System.out.println(longestDiverseString(4, 1, 1)); // Expected output: "aabaac", "aabaca", or similar

        // Test case 3: More b's than a's and c's
        System.out.println(longestDiverseString(1, 4, 1)); // Expected output: "bbabbc", "babbcb", or similar

        // Test case 4: More c's than a's and b's
        System.out.println(longestDiverseString(1, 1, 4)); // Expected output: "ccabcc", "ccbacb", or similar

        // Test case 5: No a's
        System.out.println(longestDiverseString(0, 2, 3)); // Expected output: "bccbcc", "cbcbcc", or similar

        // Test case 6: No b's
        System.out.println(longestDiverseString(3, 0, 2)); // Expected output: "aacaac", "acaaca", or similar

        // Test case 7: No c's
        System.out.println(longestDiverseString(2, 3, 0)); // Expected output: "bbaabb", "bababb", or similar

        // Test case 8: All zeros
        System.out.println(longestDiverseString(0, 0, 0)); // Expected output: ""
    }
}
