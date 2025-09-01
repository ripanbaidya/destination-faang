package sorting;

import java.util.Arrays;
/**
 * @author Ripan Baidya
 * @date 07-08-2025
 *
 * Given an array, arr[]. Sort the array using selection sort algorithm.
 *
 * Input: arr[] = [4, 1, 3, 9, 7]
 * Output: [1, 3, 4, 7, 9]
 */
public class SelectionSort {
    public void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0 ; i <= n - 2 ; i ++) {
            int min = i ;

            for (int j = i ; j <= n -1 ; j ++){
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        var obj = new SelectionSort();

        int[] arr = {21, 23, 2, 6, 19};
        obj.selectionSort(arr);
        System.out.println("After Sorting :"+ Arrays.toString(arr));
    }
}