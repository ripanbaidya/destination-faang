package binarysearch.easy;

/**
 * @author Ripan Baidya
 * @date 03-09-2025
 *
 * Given a sorted array arr[] (0-index based) of distinct integers and an integer k, find the index
 * of k if it is present in the arr[]. If not, return the index where k should be inserted to maintain
 * the sorted order.
 *
 * Input: arr[] = [1, 3, 5, 6], k = 5
 * Output: 2
 * Explanation: Since 5 is found at index 2 as arr[2] = 5, the output is 2.
 */
public class SearchInsertPosition {
    public int searchInsertK(int[] arr, int k) {
        int n = arr.length;
        if (arr[n-1] < k) return n;

        int low = 0, high = n-1;
        int pos = -1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (arr[mid] < k) {
                low = mid + 1;
            } else {
                pos = mid;
                high = mid -1;
            }
        }

        return pos;
    }

    public static void main(String[] args) {
        var obj = new SearchInsertPosition();

        int[] arr = {1, 3, 5, 6};
        int k = 5;
        int position = obj.searchInsertK(arr, k);
        System.out.println("position = " + position);
    }
}
