package searching;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given an array of integers nums which is sorted in ascending order, and an integer target,
 * write a function to search target in nums. If target exists, then return its index. else,
 * return -1. You must write an algorithm with O(log n) runtime complexity.
 *
 * Example:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 */
public class BinarySearch {
    public int search(int[] arr, int key) {
        int n = arr.length;
        int start = 0, end = n-1;

        while (start <= end) {
            // calculate mid
            int mid = start + (end-start)/2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch obj = new BinarySearch();

        int[] arr = {-1,0,3,5,9,12};
        int target = 9;

        int index = obj.search(arr, target);
        System.out.println("Index of target: "+ index);
    }
}
