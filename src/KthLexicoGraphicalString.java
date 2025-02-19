import java.util.ArrayList;
import java.util.List;

public class KthLexicoGraphicalString {
    private void generateSequences(int len,String current, String chars, List<String> list) {
        if (current.length() == len) {
            list.add(current);
            return;
        }

        for (char ch: chars.toCharArray()) {
            if (current.isEmpty() || current.charAt(current.length() -1) != ch) {
                generateSequences(len,current + ch, chars, list);
            }
        }
    }

    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        generateSequences(n,"","abc",list);
        return k > list.size() ? "" : list.get(k-1);
    }
    public static void main(String[] args) {
        KthLexicoGraphicalString obj = new KthLexicoGraphicalString();

        // Example 1
        System.out.println(obj.getHappyString(1, 3)); // Output: "c"

        // Example 2
        System.out.println(obj.getHappyString(1, 4)); // Output: ""

        // Example 3
        System.out.println(obj.getHappyString(3, 9)); // Output: "cab"

    }
}
