package array.easy;

/**
 * @author Ripan Baidya
 * @date 30-07-2025
 *
 * Given an array arr[]. The task is to find the largest element and return it.
 *
 * Example:
 * Input: arr[] = [1, 8, 7, 56, 90]
 * Output: 90
 * Explanation: The largest element of the given array is 90.
 */
public class LargestElement {
    public int largest(int[] arr) {
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;

        for (int val : arr){
            if (val > maxi) {
                maxi = val;
            }
        }

        return maxi;
    }

    public static void main(String[] args) {
        LargestElement obj = new LargestElement();

        int[] arr = {1, 8, 7, 56, 90};
        System.out.println(obj.largest(arr));
    }
}
