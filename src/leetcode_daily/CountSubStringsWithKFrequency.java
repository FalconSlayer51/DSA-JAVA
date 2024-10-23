package leetcode_daily;

import java.util.Arrays;

public class CountSubStringsWithKFrequency {
    public static int numberOfSubStrings(String s,int k) {
        int n = s.length();
        if (n==1 && k ==1) return 1;
        if (k == 1) return (int)((Math.pow(2,n)-1)/2);
        int count = 0;
        for (int i = 0; i < n-k ; i++) {
            for (int j = k+1; j <= n-i; j++) {
                String subStr = s.substring(i,i+j);
                if (isValid(subStr,k)){
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isValid(String subStr, int k) {
        int[] counter = new int[26];
        for (int i = 0; i<subStr.length();i++) {
            char ch = subStr.charAt(i);
            counter[ch - 'a']++;
        }

        //System.out.println(Arrays.toString(counter));
        return Arrays.stream(counter).anyMatch(num -> num >= k);
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubStrings("abacb", 2)); // Output: 4
        System.out.println(numberOfSubStrings("abcde", 1)); // Output: 15

        //System.out.println(isValid("abacb",2));
    }
}
