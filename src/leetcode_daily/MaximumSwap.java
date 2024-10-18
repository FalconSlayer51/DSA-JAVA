package leetcode_daily;

public class MaximumSwap {

    public static int maximumSwap(int num) {
        String numStr = Integer.toString(num);
        int max = num;

        for (int i = 0; i < numStr.length(); i++) {
            for (int j = i+1; j < numStr.length(); j++) {
                char[] numeral =  numStr.toCharArray();
                char temp = numeral[i];
                numeral[i] = numeral[j];
                numeral[j] = temp;

                int tempNum = Integer.parseInt(new String(numeral));
                max = Math.max(max,tempNum);
            }
        }

        return max;

    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(maximumSwap(2736)); // Expected output: 7236
        System.out.println(maximumSwap(9973)); // Expected output: 9973
        System.out.println(maximumSwap(98368)); // Expected output: 98863
        System.out.println(maximumSwap(0)); // Expected output: 0
        System.out.println(maximumSwap(1)); // Expected output: 1
    }
}
