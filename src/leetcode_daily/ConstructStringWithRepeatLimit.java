package leetcode_daily;

import java.util.HashMap;
import java.util.PriorityQueue;

public class ConstructStringWithRepeatLimit {
    public String repeatLimitedString(String s,int repeatLimit) {
        HashMap<Character,Integer> charToFreq = new HashMap<>();
        StringBuilder result = new StringBuilder();
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>((a,b) -> Character.compare(b,a));

        for (char ch : s.toCharArray()) {
            charToFreq.put(ch,charToFreq.getOrDefault(ch,0)+1);
        }

        for (char ch : charToFreq.keySet()) {
            priorityQueue.add(ch);
        }

        while (!priorityQueue.isEmpty()) {
            char currentChar = priorityQueue.poll();
            int count = charToFreq.get(currentChar);

            int use = Math.min(count,repeatLimit);
            for (int i = 0; i < use; i++) {
                result.append(currentChar);
            }

            charToFreq.put(currentChar,count - use);

            if (charToFreq.get(currentChar) > 0 && !priorityQueue.isEmpty()) {
                char nextChar = priorityQueue.poll();
                result.append(nextChar);
                charToFreq.put(nextChar,charToFreq.get(nextChar)-1);

                if (charToFreq.get(nextChar) > 0) {
                    priorityQueue.add(nextChar);
                }

                priorityQueue.add(currentChar);
            }
        }

        return result.toString();
    }
    public static void main(String[] args) {
        ConstructStringWithRepeatLimit solution = new ConstructStringWithRepeatLimit();

        // Test case 1
        String s1 = "cczazcc";
        int repeatLimit1 = 3;
        String result1 = solution.repeatLimitedString(s1, repeatLimit1);
        System.out.println(result1); // Expected output: "zzcccac"

        // Test case 2
        String s2 = "aababab";
        int repeatLimit2 = 2;
        String result2 = solution.repeatLimitedString(s2, repeatLimit2);
        System.out.println(result2); // Expected output: "bbabaa"
    }
}
