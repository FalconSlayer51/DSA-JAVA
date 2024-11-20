package leetcode_daily;

import java.util.Arrays;

public class TakeKCharsFromLeftAndRight {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int[] count = new int[3];
        for (char ch: s.toCharArray()) {
            count[ch-'a']++;
        }

        if (count[0] < k || count[1]<k || count[2] < k){
            return -1;
        }

        int i = 0;
        int j = 0;
        int result = Integer.MIN_VALUE;
        while (j < n) {
            count[s.charAt(j)-'a']--;

            while (i <= j && (count[0] < k || count[1]<k || count[2] < k)) {
                count[s.charAt(i) - 'a']++;
                i++;
            }
            result = Math.max(result,j-i+1);
            j++;
        }

        return n-result;
    }
    public static void main(String[] args) {
        TakeKCharsFromLeftAndRight solution = new TakeKCharsFromLeftAndRight();
        System.out.println(solution.takeCharacters("aabaaaacaabc", 2)); // Output: 8
        System.out.println(solution.takeCharacters("a", 1)); // Output: -1
    }
}
