package binarysearch.easy;

/**
 * @author Ripan Baidya
 * @date 01-09-2025
 *
 * Given a sorted array arr[] and an integer k, find the position(0-based indexing) at which k
 * is present in the array using binary search. If k doesn't exist in arr[] return -1.
 * Note: If multiple occurrences are there, please return the smallest index.
 *
 * Examples:
 *
 * Input: arr[] = [1, 2, 3, 4, 5], k = 4
 * Output: 3
 * Explanation: 4 appears at index 3.
 */
public class BinarySearch {
    public int binarySearch(int[] arr, int k) {
        int n = arr.length;

        int low = 0,high = n-1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            // calculate mid
            int mid = low + (high - low) / 2;

            // if the mid element is equal to k,
            // update the answer and search in the left half
            if (arr[mid] == k) {
                ans = Math.min(ans, mid);
                high = mid - 1;
            }
            else if (arr[mid] < k)
                low = mid + 1;
            else
                high = mid - 1;
        }

        if (ans != Integer.MAX_VALUE)
            return ans; // found

        return -1; // not found
    }

    public static void main(String[] args) {
        var obj = new BinarySearch();
        int[] arr = {1, 2, 3, 4, 5};
        int target = 4;

        int index = obj.binarySearch(arr, target);
        System.out.println(index);
    }
}

