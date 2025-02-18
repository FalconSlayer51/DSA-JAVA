package leetcode_daily;

public class ConstructDIString {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        char[] num = new char[n+1];
        for (int i = 0; i <= n ; i++) {
            num[i] = (char) ('1' + i);
        }

        while (!matches(num, pattern)) {
            nextPermutation(num);
        }

        return new String(num);
    }

    private void nextPermutation(char[] num) {
        int i = num.length - 2;
        while (i >= 0 && num[i] >= num[i+1]) {
            i --;
        }

        if (i >= 0) {
            int j = num.length - 1;
            while (num[j] <= num[i]) {
                j--;
            }
            swap(num, i, j);
        }
        reverse(num, i+1);
    }

    private void swap(char[] num, int i, int j) {
        char temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    private void reverse(char[] num, int start) {
        int end = num.length -1;
        while (start < end) {
            swap(num, start, end);
            start++;
            end --;
        }
    }

    private boolean matches(char[] num, String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            if ((pattern.charAt(i) == 'I' && num[i] > num[i + 1] || (pattern.charAt(i) == 'D' && num[i] < num[i + 1])))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ConstructDIString solution = new ConstructDIString();

        // Example 1
        String pattern1 = "IIIDIDDD";
        String result1 = solution.smallestNumber(pattern1);
        System.out.println("Input: pattern = \"" + pattern1 + "\"");
        System.out.println("Output: \"" + result1 + "\""); // "123549876"

        // Example 2
        String pattern2 = "DDD";
        String result2 = solution.smallestNumber(pattern2);
        System.out.println("Input: pattern = \"" + pattern2 + "\"");
        System.out.println("Output: \"" + result2 + "\""); // "4321"
    }
}
