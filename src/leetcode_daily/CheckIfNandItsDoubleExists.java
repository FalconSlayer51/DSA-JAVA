package leetcode_daily;

import java.util.HashSet;

public class CheckIfNandItsDoubleExists {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> s = new HashSet<>();
        for(int i: arr) {
            if(s.contains(i*2) || (s.contains(i/2) && i%2 == 0))
                return true;
            s.add(i);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {-2,0,10,-19,4,6,-8};
        CheckIfNandItsDoubleExists checkIfNandItsDoubleExists = new CheckIfNandItsDoubleExists();
        System.out.println(checkIfNandItsDoubleExists.checkIfExist(arr1)); // Expected output: true

        int[] arr2 = {3, 1, 7, 11};
        System.out.println(checkIfNandItsDoubleExists.checkIfExist(arr2)); // Expected output: false
    }
}
