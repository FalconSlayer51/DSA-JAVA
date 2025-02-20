package leetcode_daily;

import java.util.HashSet;

public class FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (var num: nums) {
            set.add(Integer.parseInt(num,2));
        }
        System.out.println(set);
        for (int i = 0; i <= Math.pow(2,n); i++) {
            if (!set.contains(i)) {
                String binaryString = String.format("%"+n+"s", Integer.toBinaryString(i)).replace(' ', '0');
                return binaryString;
            }
        }
        return "";
    }

    // Beat 100%
    public String findDifferentBinaryString2(String[] nums) {
        int n = nums.length;
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            if (nums[i].charAt(i) == '0')
                sb.append("1");
            else
                sb.append("0");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] nums1 = {"01", "10"};
        System.out.println(new FindUniqueBinaryString().findDifferentBinaryString2(nums1)); // Output: "11"

        String[] nums2 = {"00", "01"};
        System.out.println(new FindUniqueBinaryString().findDifferentBinaryString2(nums2)); // Output: "11"

        String[] nums3 = {"111", "011", "001"};
        System.out.println(new FindUniqueBinaryString().findDifferentBinaryString2(nums3)); // Output: "101"
    }
}
