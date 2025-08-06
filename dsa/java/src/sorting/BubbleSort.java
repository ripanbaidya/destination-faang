package sorting;

import java.util.Arrays;
/**
 * @author Ripan Baidya
 * @date 07-08-2025
 *
 * Given an array, arr[]. Sort the array using bubble sort algorithm.
 *
 * Input: arr[] = [4, 1, 3, 9, 7]
 * Output: [1, 3, 4, 7, 9]
 */
public class BubbleSort {
    public void bubbleSort(int[] arr) {
        int len = arr.length;

        for(int i = len-1; i >= 1 ; i --){
            for(int j = 0 ; j <= len - 2 ; j ++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        BubbleSort obj = new BubbleSort();

        int[] arr = {21, 23, 2, 6, 3, 19, 5};
        obj.bubbleSort(arr);
        System.out.println("After Sorting :"+ Arrays.toString(arr));
    }
}