package leetcode_daily;

public class CountOddSumSubarrays {
    private int M =((int) Math.pow(10,9)) + 7;
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int[] prefixArr = new int[n];
        prefixArr[0] = arr[0];
        for(int i = 1; i < n; i++) {
            prefixArr[i] += prefixArr[i-1] + arr[i];
        }

        int count = 0;
        int even = 1;
        int odd = 0;


        for(int i = 0; i < n; i++) {
            int currentSum = prefixArr[i];
            if(currentSum % 2 == 0) {
                count = (count + odd) % M;
                even ++;
            } else {
                count = (count + even) % M;
                odd ++;
            }
        }

        return count;
    }
}
