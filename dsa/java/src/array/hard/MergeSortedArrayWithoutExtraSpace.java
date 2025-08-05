package array.hard;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, representing the number of elements in nums1 and nums2
 * respectively. Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored
 * inside the array nums1. To accommodate this, nums1 has a length of m + n, where the
 * first m elements denote the elements that should be merged, and the last n elements
 * are set to 0 and should be ignored. nums2 has a length of n.
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 */
public class MergeSortedArrayWithoutExtraSpace {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m + n];
        int i = 0, j = 0;
        int index = 0;

        // Merge the arrays
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[index++] = nums1[i++];
            } else {
                merged[index++] = nums2[j++];
            }
        }

        // Add the remaining elements of nums1
        while (i < m) {
            merged[index++] = nums1[i++];
        }

        // Add the remaining elements of nums2
        while (j < n) {
            merged[index++] = nums2[j++];
        }

        // Copy the merged array back to nums1
        for (i = 0; i < m + n; ++i) {
            nums1[i] = merged[i];
        }
    }

    public static void main(String[] args) {
        MergeSortedArrayWithoutExtraSpace obj = new MergeSortedArrayWithoutExtraSpace();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        obj.merge(nums1, 3, nums2, 3);
    }
}
