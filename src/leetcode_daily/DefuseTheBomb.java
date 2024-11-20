package leetcode_daily;

import java.util.Arrays;

public class DefuseTheBomb {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (k > 0){
                int sum = 0;
                for (int j = i+1; j < i+k+1; j++) {
                    System.out.println(j+"th iteration "+code[j%n]+" k is: "+k);
                    sum += code[j%n];
                }
                result[i] = sum;
            } else if(k < 0) {
                int sum = 0;
                for (int j = i-Math.abs(k); j < i; j++) {
                    sum += code[(j+n)%n];
                }
                result[i] = sum;
            } else {
                result[i] = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        DefuseTheBomb obj = new DefuseTheBomb();

        int[] code1 = {5, 7, 1, 4};
        int k1 = 3;
        int[] result1 = obj.decrypt(code1, k1);
        System.out.println(java.util.Arrays.toString(result1)); // Output: [12, 10, 16, 13]

        int[] code2 = {1, 2, 3, 4};
        int k2 = 0;
        int[] result2 = obj.decrypt(code2, k2);
        System.out.println(java.util.Arrays.toString(result2)); // Output: [0, 0, 0, 0]

        int[] code3 = {2, 4, 9, 3};
        int k3 = -2;
        int[] result3 = obj.decrypt(code3, k3);
        System.out.println(java.util.Arrays.toString(result3)); // Output: [12, 5, 6,
    }
}
