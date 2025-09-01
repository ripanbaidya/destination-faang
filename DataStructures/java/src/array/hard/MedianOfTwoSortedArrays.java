package array.hard;

/**
 * @author Ripan Baidya
 * @date 18-08-2025
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, find the median
 * of the two sorted arrays.
 *
 * Example:
 * Input: nums1 = [1, 3], nums2 = [2]
 * Output: 2.00000
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // length of the arrays
        int n = nums1.length;
        int m = nums2.length;

        // Creating a new array, which will store
        // elements in sorted order
        int[] newArr = new int[n+m];
        int left = 0, right = 0;
        int it = 0; // iterator

        // Iterating over the two arrays and adding them
        // into newArr in sorted order
        while (left < n && right < m) {
            if (nums1[left] <= nums2[right]) {
                newArr[it ++] = nums1[left ++];
            } else {
                newArr[it ++] = nums2[right ++];
            }
        }

        // Elements left in nums1
        while (left < n) {
            newArr[it ++] = nums1[left ++];
        }

        // Elements left in nums2
        while (right < m) {
            newArr[it ++] = nums2[right ++];
        }

        // Calculating median index
        int midIdx = (n+m)/2;
        return (n+m) % 2 != 0
                ? (double) newArr[midIdx]
                : (double) (newArr[midIdx] + newArr[midIdx-1]) / 2;

    }
    public static void main(String[] args) {
        var obj = new MedianOfTwoSortedArrays();

        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        double median = obj.findMedianSortedArrays(nums1, nums2);
        System.out.println("Median: " + median);
    }
}
