package leetcode_daily;

public class StringCompression3 {
    public static String compressedString(String word) {
        StringBuilder sb = new StringBuilder();

        int start = 0;
        int end = 1;

        while (end < word.length()) {
            while (end < word.length() && word.charAt(end) == word.charAt(end-1) && (end - start) < 10) {
                end ++;
            }

            if ((end-start) == 10) {
                end --;
            }

            sb.append(end - start);
            sb.append(word.charAt(start));

            start = end;
            end ++;
        }

        if (start == word.length() - 1) {
            sb.append(end -start);
            sb.append(word.charAt(start));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressedString("abcde")); // Expected output: "1a1b1c1d1e"
        System.out.println(compressedString("aaaaaaaaaaaaaabb"));
    }
}
