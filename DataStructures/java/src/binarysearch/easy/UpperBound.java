package binarysearch.easy;

/**
 * @author Ripan Baidya
 * @date 01-09-2025
 *
 * Given a sorted array arr[] and a number target, the task is to find the lower bound of the
 * target in this given array. The lower bound of a number is defined as the smallest index in
 * the sorted array where the element is greater than or equal to the given number.
 *
 * Note: If all the elements in the given array are smaller than the target, the lower bound
 * will be the length of the array.
 *
 * Examples :
 *
 * Input:  arr[] = [2, 3, 7, 10, 11, 11, 25], target = 9
 * Output: 3
 * Explanation: 3 is the smallest index in arr[] where element (arr[3] = 10) is greater than or
 * equal to 9.
 */
public class UpperBound {
    int upperBound(int[] arr, int target) {
        int n = arr.length;
        if (target > arr[n-1]) // base case
            return n;

        int uprBnd = -1; // upper bound
        int low = 0, high = n-1;

        while (low <= high) {
            // calculate mid
            int mid = low + (high-low)/2;

            if (arr[mid] > target) {
                uprBnd = mid;
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }

        return uprBnd;
    }

    public static void main(String[] args) {
        var ub = new UpperBound();
        int[] arr = {2, 3, 7, 10, 11, 11, 25};
        int target = 9;

        int index = ub.upperBound(arr, target);
        System.out.println("Index of target: "+ index);
    }
}
