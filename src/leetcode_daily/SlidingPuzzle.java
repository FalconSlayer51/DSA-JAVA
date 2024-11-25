package leetcode_daily;

import java.util.*;

public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }

        String target = "123450";
        Queue<String> queue = new LinkedList<>();
        queue.offer(sb.toString());

        Map<Integer, int[]> mp = new HashMap<>();
        mp.put(0, new int[]{1, 3});
        mp.put(1, new int[]{0, 2, 4});
        mp.put(2, new int[]{1, 5});
        mp.put(3, new int[]{0, 4});
        mp.put(4, new int[]{1, 3, 5});
        mp.put(5, new int[]{2, 4});

        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());

        int level = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String curr = queue.poll();
                if (curr.equals(target)) {
                    return level;
                }

                int zeroIdx = curr.indexOf('0');
                for(int swapIdx : mp.get(zeroIdx)) {
                    char[] newStateArray = curr.toCharArray();
                    char temp = newStateArray[zeroIdx];
                    newStateArray[zeroIdx] = newStateArray[swapIdx];
                    newStateArray[swapIdx] = temp;

                    String newState = new String(newStateArray);
                    if (!visited.contains(newState)) {
                        queue.offer(newState);
                        visited.add(newState);
                    }
                }
            }
            level++;
        }

        return -1;

    }

    public static void main(String[] args) {
        SlidingPuzzle puzzle = new SlidingPuzzle();

        int[][] board1 = {{1, 2, 3}, {4, 0, 5}};
        System.out.println(puzzle.slidingPuzzle(board1)); // Output: 1

        int[][] board2 = {{1, 2, 3}, {5, 4, 0}};
        System.out.println(puzzle.slidingPuzzle(board2)); // Output: -1

        int[][] board3 = {{4, 1, 2}, {5, 0, 3}};
        System.out.println(puzzle.slidingPuzzle(board3)); // Output: 5
    }
}
