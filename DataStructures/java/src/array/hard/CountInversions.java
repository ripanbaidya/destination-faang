package array.hard;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given an array of integers arr[]. You have to find the Inversion Count of the array.
 * Note : Inversion count is the number of pairs of elements (i, j) such that i < j and
 * arr[i] > arr[j].
 *
 * Example:
 * Input: arr[] = [2, 4, 1, 3, 5]
 * Output: 3
 * Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
 */
public class CountInversions {
    public int merge(int[] arr, int low, int mid, int high) {
        // Create a temporary array to store the sorted elements
        // make sure define the size in a correct way, or else TLE will occur
        int[] temp = new int[high - low + 1];
        int left = low, right = mid + 1;
        int k = 0;

        // Count total number of inversions
        int count = 0;

        // Merge the sorted halves
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                // Inversion occurs, as arr[left] > arr[right]
                temp[k++] = arr[right++];
                count += (mid - left + 1);
            }
        }

        // Copy remaining elements from the left half
        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        // Copy remaining elements from the right half
        while (right <= high) {
            temp[k++] = arr[right++];
        }

        // Copy the sorted elements back to the original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }

        // Return the total number of inversions
        return count;
    }

    public int mergeSort(int[] arr, int left, int right) {
        int count = 0;
        if (left >= right) return count;

        int mid = (left + right) / 2;
        count += mergeSort(arr, left, mid);
        count += mergeSort(arr, mid + 1, right);
        count += merge(arr, left, mid, right);

        return count;
    }

    public int inversionCount(int arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        CountInversions obj = new CountInversions();

        int[] arr = {2, 4, 1, 3, 5};
        int count = obj.inversionCount(arr);

        System.out.println("Inversion count: "+ count);
    }
}