package array.easy;

/**
 * @author Ripan Baidya
 * @date 30-07-2025
 *
 * Given an array, arr[] of n integers, and an integer element x, find whether element
 * x is present in the array. Return the index of the first occurrence of x in the array,
 * or -1 if it doesn't exist.
 *
 * Input: arr[] = [1, 2, 3, 4], x = 3
 * Output: 2
 * Explanation: For array [1, 2, 3, 4], the element to be searched is 3. Since 3 is present
 * at index 2, the output is 2
 */
public class LinearSearch {
    public int search(int[] arr, int x) {
        int n = arr.length;

        for (int i = 0; i < n; i ++){
            if (arr[i] == x){
                return i; // element found
            }
        }

        // element not found
        return -1;
    }

    public static void main(String[] args) {
        LinearSearch obj = new LinearSearch();

        int[] arr = {1, 2, 3, 4};
        int x = 3;

        int index = obj.search(arr, x);
        System.out.println("Index of target: "+ index);
    }
}
