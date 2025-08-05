package array.medium;

/**
 * @author Ripan Baidya
 * @date 30-07-2025
 *
 * Given an array arr[]. Rotate the array to the left (counter-clockwise direction) by d steps,
 * where d is a positive integer. Do the mentioned change in the array in place.
 * Note: Consider the array as circular.
 *
 * Input: arr[] = [1, 2, 3, 4, 5], d = 2
 * Output: [3, 4, 5, 1, 2]
 * Explanation: when rotated by 2 elements, it becomes 3 4 5 1 2.
 */
public class RotateArrayLeft {
    private void reverse(int[] nums, int s, int e){
        while(s <= e){
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;

            s ++;
            e --;
        }
    }
    public void rotateArr(int arr[], int d) {
        if (arr == null || arr.length == 0 || d <= 0) return; // No rotation needed
        int n = arr.length;
        d = d % n; // to handle cases where d >= n

        reverse(arr, 0, d-1);
        reverse(arr, d, n-1);
        reverse(arr, 0, n-1);
    }
}
