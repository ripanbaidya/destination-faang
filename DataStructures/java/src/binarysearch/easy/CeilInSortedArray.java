package binarysearch.easy;

/**
 * @author Ripan Baidya
 * @date 03-09-2025
 *
 * Given a sorted array arr[] and an integer x, find the index (0-based) of the smallest element
 * in arr[] that is greater than or equal to x. This element is called the ceil of x. If such an
 * element does not exist, return -1.
 *
 * Note: In case of multiple occurrences of ceil of x, return the index of the first occurrence.
 *
 * Examples
 *
 * Input: arr[] = [1, 2, 8, 10, 11, 12, 19], x = 5
 * Output: 2
 * Explanation: Smallest number greater than 5 is 8, whose index is 2.
 */
public class CeilInSortedArray {
    public int findCeil(int[] arr, int x) {
        int n = arr.length;
        if (arr[n-1] < x) return -1;

        int low = 0, high = n-1;
        int res = -1;

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (arr[mid] >= x) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        var obj = new CeilInSortedArray();

        int[] arr = {1, 2, 8, 10, 11, 12, 19};
        int x = 5;
        
        int ceil = obj.findCeil(arr, x);
        System.out.println("ceil = " + ceil);
    }
}
