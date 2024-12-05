package leetcode_daily;

import java.util.HashMap;

public class MovePiecesToObtainString {

    private HashMap<String,Boolean> map = new HashMap<>();
    private boolean canChangeHelper(String start, String target) {
        if(start.equals(target)) return true;

        if (map.containsKey(start)) return map.get(start);

        for (int i = 0; i < start.length(); i++) {
            char currentChar = start.charAt(i);
            if (currentChar == '_') {
                continue;
            }

            if (currentChar == 'L' && i > 0 && start.charAt(i-1) == '_') {
                String swappedString = swap(i, i - 1, start);
                if(canChangeHelper(swappedString, target)){
                    return true;
                }
            }

            if (currentChar == 'R' && i < start.length() -1 && start.charAt(i+1) == '_') {
                String swappedString = swap(i,i+1,start);
                if(canChangeHelper(swappedString,target)) {
                    return true;
                }
            }
        }

        map.put(start,false);
        return false;
    }

    private String swap(int i,int j,String start) {
        char[] arr = start.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return new String(arr);
    }
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0, j = 0;

        while (i < n || j < n) {
            while (i < n && start.charAt(i) == '_') {
                i++;
            }

            while (j < n && target.charAt(j) == '_') {
                j++;
            }

            if (i == n || j == n) {
                return i==n & j==n;
            }

            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }

            if (start.charAt(i) == 'L' && i < j) {
                return false;
            }

            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }

            i++;
            j++;
        }

        return true;
    }
    public static void main(String[] args) {
        MovePiecesToObtainString solution = new MovePiecesToObtainString();

        // Example 1
        String start1 = "_L__R__R_";
        String target1 = "L______RR";
        System.out.println(solution.canChange(start1, target1)); // Output: true

        // Example 2
        String start2 = "R_L_";
        String target2 = "__LR";
        System.out.println(solution.canChange(start2, target2)); // Output: false

        // Example 3
        String start3 = "_R";
        String target3 = "R_";
        System.out.println(solution.canChange(start3, target3)); // Output: false
    }
}
