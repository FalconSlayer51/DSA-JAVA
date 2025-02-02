package leetcode_daily;

public class CheckIfArrayIsSortedRotated {
    public boolean check(int[] nums) {
        int n = nums.length;
        int peakElementIndex = -1;

        if(isSorted(nums)) {
            return true;
        }

        for (int i = 1; i < n - 1; i++) {
            int currNum = nums[i];
            if (currNum >= nums[i - 1] && currNum > nums[i + 1]) {
                peakElementIndex = i;
            }
        }
        if (peakElementIndex == -1 && nums[0] >= nums[1]) {
            peakElementIndex = 0;
        } else if (peakElementIndex==-1){
            peakElementIndex = n-1;
        }

        int[] origArray = new int[n];

        for (int i = 0; i < n; i++) {
            origArray[i] = nums[(i+peakElementIndex+1) % n];
        }
        return isSorted(origArray);
    }

    private boolean isSorted(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            if (nums[i-1] > nums[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {2, 1, 3, 4};
        int[] nums3 = {6, 7, 7, 5};

        CheckIfArrayIsSortedRotated checker = new CheckIfArrayIsSortedRotated();

        System.out.println(checker.check(nums1)); // Output: true
        System.out.println(checker.check(nums2)); // Output: false
        System.out.println(checker.check(nums3)); // Output: true
    }
}
