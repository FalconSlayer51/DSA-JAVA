package leetcode_daily;


public class CircularSequence {
    public static boolean isCircularSequence(String sentence) {
        String[] words = sentence.split(" ");
        int n = words.length;
        if (words.length == 1 && words[0].charAt(0) == words[0].charAt(words[0].length()-1)) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            String currentWord = words[i];
            String nextWord = words[(i+1)% n];

            if (!(currentWord.charAt(currentWord.length()-1) == nextWord.charAt(0))) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(isCircularSequence("leetcode exercises sound delightful")); // Expected output: true
        System.out.println(isCircularSequence("eetcode")); // Expected output: true
        System.out.println(isCircularSequence("Leetcode is cool")); //
    }
}
