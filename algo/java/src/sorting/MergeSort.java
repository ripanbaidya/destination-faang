package sorting;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Ripan Baidya
 * @date 07-08-2025
 *
 * Given an array, arr[]. Sort the array using merge sort algorithm.
 *
 * Input: arr[] = [4, 1, 3, 9, 7]
 * Output: [1, 3, 4, 7, 9]
 */
public class MergeSort {
    public void merge(int[] arr, int low, int mid, int high) {
        // Create a temporary ArrayList to store the merged subarray
        ArrayList<Integer> temp = new ArrayList<>();

        int left = low; // starting index of the first subarray
        int right = mid + 1; // starting index of the second subarray

        // Merge the two subarrays into the temporary ArrayList
        while (left <= mid && right <= high) {
            // Compare elements from the two subarrays and add the smaller one to the temporary ArrayList
            if (arr[left] <= arr[right]) {
                temp.add(arr[left++]); // increment left index
            } else {
                temp.add(arr[right++]); // increment right index
            }
        }

        // Add any remaining elements from the first subarray to the temporary ArrayList
        while (left <= mid) {
            temp.add(arr[left++]);
        }

        // Add any remaining elements from the second subarray to the temporary ArrayList
        while (right <= high) {
            temp.add(arr[right++]);
        }

        // Copy the merged subarray back into the original array
        for (int i = low; i <= high; i++) {
            // adjust index to match original array
            arr[i] = temp.get(i - low);
        }
    }

    public void mergeSort(int[] arr, int low, int high) {
        // Base case: if the subarray has only one element, it is already sorted
        if (low >= high) {
            return;
        }

        // Find the middle index of the subarray
        int mid = (low + high) / 2;

        mergeSort(arr, low, mid); // sort left subarray
        mergeSort(arr, mid + 1, high); // sort right subarray

        // Merge the two sorted subarrays
        merge(arr, low, mid, high);
    }

    public static void main(String[] args) {
        var obj = new MergeSort();
        int[] arr = {21, 23, 2, 6, 3, 19, 5};

        System.out.println("Before Sorting: " + Arrays.toString(arr));
        obj.mergeSort(arr, 0, arr.length - 1);
        System.out.println("After Sorting: " + Arrays.toString(arr));
    }
}