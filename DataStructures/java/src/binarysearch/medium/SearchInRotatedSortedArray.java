package binarysearch.medium;

/**
 * @author Ripan Baidya
 * @date 03-09-2025
 *
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly left rotated at an unknown index k
 * (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1],
 * nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left
 * rotated by 3 indices and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target, return the index of
 * target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n-1;

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (nums[mid] == target) {
                return mid;
            }
            // low ... mid is sorted
            else if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1; // target is on the left half
                } else {
                    low = mid + 1; // target is on the right half
                }
            }
            // mid ... high is sorted
            else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1; // target is on the right half
                } else {
                    high = mid - 1; // target is on the left half
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        var obj = new SearchInRotatedSortedArray();

        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int index = obj.search(nums, target);

        System.out.println("index = " + index);
    }
}
