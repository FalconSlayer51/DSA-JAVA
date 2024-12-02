package leetcode_daily;

public class IsPrefixOfAWord {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] list = sentence.split(" ");
        for (int i = 0; i< list.length;i++) {
            String str = list[i];
            if (str.indexOf(searchWord) == 0) {
                return i +1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        IsPrefixOfAWord solution = new IsPrefixOfAWord();

        // Example 1
        String sentence1 = "i love eating burger";
        String searchWord1 = "burg";
        System.out.println(solution.isPrefixOfWord(sentence1, searchWord1)); // Output: 4

        // Example 2
        String sentence2 = "this problem is an easy problem";
        String searchWord2 = "pro";
        System.out.println(solution.isPrefixOfWord(sentence2, searchWord2)); // Output: 2

        // Example 3
        String sentence3 = "i am tired";
        String searchWord3 = "you";
        System.out.println(solution.isPrefixOfWord(sentence3, searchWord3)); // Output: -1
    }
}
