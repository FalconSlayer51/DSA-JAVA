package leetcode_daily;

public class ShortestSubarrayToBeRemovedToMakeArraySorted {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        int j = n -1;
        while (j > 0 && arr[j] >= arr[j-1]) {
            j--;
        }

        int i = 0;
        int result = j;

        while (i < j && (i==0||arr[i] >= arr[i-1])) {
            while (j<n && arr[i] > arr[j]) {
                j++;
            }

            result = Math.min(j-i-1,result);
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        ShortestSubarrayToBeRemovedToMakeArraySorted obj = new ShortestSubarrayToBeRemovedToMakeArraySorted();

        // Test case 1
        int[] arr1 = {1, 2, 3, 10, 4, 2, 3, 5};
        System.out.println(obj.findLengthOfShortestSubarray(arr1)); // Output: 3

        // Test case 2
        int[] arr2 = {5, 4, 3, 2, 1};
        System.out.println(obj.findLengthOfShortestSubarray(arr2)); // Output: 4

        // Test case 3
        int[] arr3 = {1, 2, 3};
        System.out.println(obj.findLengthOfShortestSubarray(arr3)); // Output: 0
     }
}
