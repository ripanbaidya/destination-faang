package binarysearch.easy;

/**
 * @author Ripan Baidya
 * @date 03-09-2025
 *
 * Given a sorted array arr[] and an integer x, find the index (0-based) of the largest element
 * in arr[] that is less than or equal to x. This element is called the floor of x. If such an
 * element does not exist, return -1.
 *
 * Note: In case of multiple occurrences of ceil of x, return the index of the last occurrence.
 *
 * Examples
 *
 * Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 5
 * Output: 1
 * Explanation: Largest number less than or equal to 5 is 2, whose index is 1.
 */
public class FloorInSortedArray {
    public int findFloor(int[] arr, int x) {
        int n = arr.length;
        if (arr[0] > x) return -1;

        int low = 0, high = n-1;
        int res = -1;

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (arr[mid] <= x) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        var obj = new FloorInSortedArray();

        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int x = 3;
        int floor = obj.findFloor(arr, x);
        System.out.println("floor = " + floor);
    }
}
