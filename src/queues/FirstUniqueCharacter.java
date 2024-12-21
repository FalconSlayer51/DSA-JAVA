package queues;

import java.util.LinkedList;
import java.util.Queue;

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        int n = s.length();
        Queue<int[]> queue = new LinkedList<>();
        int[] counter = new int[26];

        for (int i = 0; i < n ; i++) {
            char ch = s.charAt(i);
            queue.add(new int[]{i,ch});
            counter[ch - 'a'] ++;

            while (!queue.isEmpty() && counter[queue.peek()[1] - 'a'] > 1)
                queue.poll();
        }

        return !queue.isEmpty() ? queue.peek()[0] : -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacter solution = new FirstUniqueCharacter();
        System.out.println(solution.firstUniqChar("leetcode")); // Output: 0
        System.out.println(solution.firstUniqChar("loveleetcode")); // Output: 2
        System.out.println(solution.firstUniqChar("aabb")); // Output: -1
    }
}
