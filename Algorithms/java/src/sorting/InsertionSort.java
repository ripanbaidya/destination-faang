package sorting;

import java.util.Arrays;
/**
 * @author Ripan Baidya
 * @date 07-08-2025
 *
 * Given an array, arr[]. Sort the array using insertion sort algorithm.
 *
 * Input: arr[] = [4, 1, 3, 9, 7]
 * Output: [1, 3, 4, 7, 9]
 */
public class InsertionSort {
    public void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0 ; i <= n -1 ; i ++){
            int j = i ;

            while (j > 0 && arr[j-1] > arr[j]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j --;
            }
        }
    }

    public static void main(String[] args) {
        var obj = new InsertionSort();

        int[] arr = {21, 23, 2, 6, 3, 19, 5};
        obj.insertionSort(arr);
        System.out.println("After Sorting :"+ Arrays.toString(arr));
    }
}