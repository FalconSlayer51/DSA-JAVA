package leetcode_daily;

import java.util.HashMap;

public class FindKthBit {

    private static String generateString(int n,HashMap<Integer,String> dp) {
        if (n == 1) return "0";

        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        String previousString = generateString(n - 1,dp);
        String invertedReverse = new StringBuilder(previousString.replace('0', 'x').replace('1', '0').replace('x', '1')).reverse().toString();
        String result = previousString + "1" + invertedReverse;
        dp.put(n,result);
        return result;
    }

    public static char findKthBit(int n, int k) {
        HashMap<Integer,String> dp = new HashMap<>();
        String str = generateString(n,dp);
        return str.charAt(k-1);
    }

    public static void main(String[] args) {
        System.out.println(findKthBit(3, 1));  //Expected output: '0'
        System.out.println(findKthBit(4, 11));  //Expected output: '1'
        System.out.println(findKthBit(1, 1));  //Expected output: '0'
        System.out.println(findKthBit(2, 3));  //Expected output: '1'
        System.out.println(findKthBit(10, 20)); // Expected output: '0'
    }
}
