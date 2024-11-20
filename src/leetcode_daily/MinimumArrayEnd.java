package leetcode_daily;

public class MinimumArrayEnd {
    public static long minEnd(int n,int x) {
        long num = x;
        long count = 0;
        long res = 0;
        while (count < n) {
            long or = x | num +1;
            if((x & or) == x) {
                res = num;
                count++;
            }
            num = or;
        }

        return res;
    }

    public static long minEnd1(int n, int x) {
        long num = x;
        for (int i = 1; i < n; i++) {
            num = (num+1) | x;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(minEnd1(3, 4)); // Output: 6
        System.out.println(minEnd1(2, 7)); // Output: 15
    }
}
