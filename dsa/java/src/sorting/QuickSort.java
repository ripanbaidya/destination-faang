package sorting;

import java.util.Arrays;

/**
 * @author Ripan Baidya
 * @date 07-08-2025
 *
 * Given an array, arr[]. Sort the array using quick sort algorithm.
 *
 * Input: arr[] = [4, 1, 3, 9, 7]
 * Output: [1, 3, 4, 7, 9]
 */
public class QuickSort {
    public void quickSortHelper(int[] arr, int low, int high) {
        if(low < high){
            int partitionIndex = partition(arr, low, high);
            quickSortHelper(arr, low, partitionIndex-1);
            quickSortHelper(arr, partitionIndex+1, high);
        }
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j){
            while (arr[i] <= pivot && i <= high-1) {
                i++;
            }
            while (arr[j] > pivot && j >= low+1){
                j--;
            }

            if (i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

    public void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length-1);
    }

    public static void main(String[] args) {
        var obj = new QuickSort();

        int[] arr = { 21, 23, 2, 6, 3, 19, 5 };

        System.out.println("Before Sorting "+ Arrays.toString(arr));
        obj.quickSort(arr);
        System.out.println("After Sorting :"+ Arrays.toString(arr));
    }
}