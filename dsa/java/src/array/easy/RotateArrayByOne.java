package array.easy;

/**
 * @author Ripan Baidya
 * @date 30-07-2025
 *
 * Given an array arr, rotate the array by one position in clockwise direction.
 *
 * Input: arr[] = [1, 2, 3, 4, 5]
 * Output: [5, 1, 2, 3, 4]
 * Explanation: If we rotate arr by one position in clockwise 5 come to the front and remaining those are shifted to the end.
 */
public class RotateArrayByOne {
    private void reverse(int[] arr, int s, int e) {
        while(s <= e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;

            s ++;
            e --;
        }
    }
    public void rotate(int[] arr) {
        int n = arr.length;

        reverse(arr, 0, n-2);
        reverse(arr, 0, n-1);
    }
}
