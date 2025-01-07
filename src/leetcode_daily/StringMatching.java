package leetcode_daily;

import java.util.ArrayList;
import java.util.List;

public class StringMatching {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                if (words[i].contains(words[j]) && i != j && !result.contains(words[j])) {
                    result.add(words[j]);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        StringMatching sm = new StringMatching();

        String[] words1 = {"mass", "as", "hero", "superhero"};
        System.out.println(sm.stringMatching(words1)); // Output: ["as", "hero"]

        String[] words2 = {"leetcode", "et", "code"};
        System.out.println(sm.stringMatching(words2)); // Output: ["et", "code"]

        String[] words3 = {"blue", "green", "bu"};
        System.out.println(sm.stringMatching(words3)); // Output: []
    }
}
