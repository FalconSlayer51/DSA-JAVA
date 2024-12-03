package leetcode_daily;


public class AddingSpacesToString {
    public String addSpaces(String s,int[] spaces) {
        /* BEATS 88%
        * ```java
            int n = s.length();
            StringBuilder sb = new StringBuilder();
            int it = 0;
            for (int i = 0; i < n; i++) {
                char currChar = s.charAt(i);
                if (it < spaces.length && i == spaces[it]) {
                    sb.append(' ');
                    it++;
                }
                sb.append(currChar);
            }

            return sb.toString();
          ```
        *
        * */


        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char currChar = s.charAt(i);
            boolean isExists = binarySearch(spaces,i) != -1;
            if (isExists) {
                sb.append(' ');
            }
            sb.append(currChar);
        }

        return sb.toString();
    }

    private int binarySearch(int[] spaces, int target) {
        int n = spaces.length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == spaces[mid]) {
                return mid;
            } else if (target <= spaces[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        AddingSpacesToString solution = new AddingSpacesToString();

        // Example 1
        String s1 = "LeetcodeHelpsMeLearn";
        int[] spaces1 = {8, 13, 15};
        System.out.println(solution.addSpaces(s1, spaces1)); // Output: "Leetcode Helps Me Learn"

        // Example 2
        String s2 = "icodeinpython";
        int[] spaces2 = {1, 5, 7, 9};
        System.out.println(solution.addSpaces(s2, spaces2)); // Output: "i code in py thon"

        // Example 3
        String s3 = "spacing";
        int[] spaces3 = {0, 1, 2, 3, 4, 5, 6};
        System.out.println(solution.addSpaces(s3, spaces3)); // Output: " s p a c i n g"
    }
}
