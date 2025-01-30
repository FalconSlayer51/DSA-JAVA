package leetcode_daily;

import java.util.HashSet;

public class SplitaSubStringIntMaxUniqueStrings {
    int maxCount;
    public int maxUniqueSplit(String s) {
        maxCount = 0;
        HashSet<String> set = new HashSet<>();
        backTrack(s,set,0);
        return maxCount;
    }

    private void backTrack(String s, HashSet<String> set, int index) {
        if (index == s.length()) {
            maxCount = Math.max(maxCount,set.size());
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index,i+1);
            if (!set.contains(sub)) {
                set.add(sub);
                backTrack(s,set,i+1);
                set.remove(sub);
            }
        }
    }

    public static void main(String[] args) {
        // Test cases
        SplitaSubStringIntMaxUniqueStrings sol = new SplitaSubStringIntMaxUniqueStrings();
        System.out.println(sol.maxUniqueSplit("ababccc")); // Expected output: 5
        System.out.println(sol.maxUniqueSplit("aba")); // Expected output: 2
        System.out.println(sol.maxUniqueSplit("aa")); // Expected output: 1
    }

    public static class MagnificentSets {

    }
}
