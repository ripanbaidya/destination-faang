package array.easy;

/**
 * @author Ripan Baidya
 * @date 30-07-2025
 *
 * Given an array of positive integers arr[], return the second largest element from the array.
 * If the second largest element doesn't exist then return -1.
 * Note: The second largest element should not be equal to the largest element.
 *
 * Input: arr[] = [12, 35, 1, 10, 34, 1]
 * Output: 34
 * Explanation: The largest element of the array is 35 and the second largest element is 34.
 */
public class SecondLargestElement {
    public int getSecondLargest(int[] arr) {
        int n = arr.length;
        int maxi = -1, secMaxi = -1;

        for (int i = 0; i < n; i ++){
            // when current element is greater than the maximum
            if (arr[i] > maxi){
                // update the maximum and second maximum
                secMaxi = maxi;
                maxi = arr[i];
            }
            // when current is greater tha the second maximum
            // and this is not equivalent to the maximum
            else if (arr[i] > secMaxi && arr[i] != maxi){
                secMaxi = arr[i];
            }
        }

        return secMaxi;
    }

    public static void main(String[] args) {
        SecondLargestElement obj = new SecondLargestElement();

        int[] arr = {12, 35, 1, 10, 34, 1};
        int secondLargest = obj.getSecondLargest(arr);

        System.out.println("Second largest element: "+ secondLargest);
    }
}
