package leetcode_daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FindLongestSubstringOccursThrice {
    public int maximumLength(String s) {
        int n = s.length();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String substring = s.substring(i,j+1);
                if (isSpecial(substring)) {
                    map.put(substring,map.getOrDefault(substring,0)+1);
                }
            }
        }

        System.out.println(map);

        int result = -1;
        for (String key: map.keySet()) {
            int specialStringFreq = map.get(key);
            if (specialStringFreq >= 3) {
                result = Math.max(result,key.length());
            }
        }

        return result;
    }

    public int maximumLength2(String s) {
        int n = s.length();
        HashMap<String,Integer> subStrToFreq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringBuilder currentString = new StringBuilder();
            for (int j = i; j < n; j++) {
                if (currentString.length() == 0 || s.charAt(j) == currentString.charAt(currentString.length()-1)) {
                    currentString.append(s.charAt(j));
                    String current = currentString.toString();
                    subStrToFreq.put(current,subStrToFreq.getOrDefault(current,0)+1);
                } else {
                    break;
                }
            }
        }

        int maxLen = -1;
        for (Map.Entry<String,Integer> entry: subStrToFreq.entrySet()) {
            String subStr = entry.getKey();
            int frequency = entry.getValue();

            if (frequency >= 3) {
                maxLen = Math.max(maxLen,subStr.length());
            }
        }
        return maxLen;
    }

    private boolean isSpecial(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char ch: s.toCharArray()) {
            set.add(ch);
        }
        return set.size() == 1;
    }

    public static void main(String[] args) {
        FindLongestSubstringOccursThrice solution = new FindLongestSubstringOccursThrice();

        // Example 1
        String s1 = "aaaa";
        System.out.println("Example 1: " + solution.maximumLength2(s1)); // Output: 2

        // Example 2
        String s2 = "abcdef";
        System.out.println("Example 2: " + solution.maximumLength2(s2)); // Output: -1

        // Example 3
        String s3 = "abcaba";
        System.out.println("Example 3: " + solution.maximumLength2(s3)); // Output: 1
    }
}
