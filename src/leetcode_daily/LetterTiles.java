package leetcode_daily;

import java.util.HashSet;
import java.util.Set;

public class LetterTiles {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        boolean[] isSeen = new boolean[tiles.length()];
        findSequences("", set, isSeen, tiles);
        return set.size() - 1;
    }

    private void findSequences(String seq, Set<String> set, boolean[] isSeen, String tiles) {
        set.add(seq);
        for (int i = 0; i < tiles.length(); i++) {
            if (!isSeen[i]) {
                isSeen[i] = true;
                findSequences(seq + tiles.charAt(i), set, isSeen, tiles);
                isSeen[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterTiles().numTilePossibilities("AAB")); // Output: 8
        System.out.println(new LetterTiles().numTilePossibilities("AAABBC")); // Output: 188
        System.out.println(new LetterTiles().numTilePossibilities("V")); // Output: 1
    }
}
