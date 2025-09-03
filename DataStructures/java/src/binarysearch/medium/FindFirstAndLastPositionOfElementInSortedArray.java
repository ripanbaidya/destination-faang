package binarysearch.medium;

import java.util.Arrays;

/**
 * @author Ripan Baidya
 * @date 03-09-2025
 *
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending
 * position of a given target value. If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    /*
    // Naive Solution
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return new int[]{-1, -1};

        int firstOcr = -1, lastOcr = -1;

        // find the first occurance
        for (int i = 0; i < n; i ++) {
            if (nums[i] == target) {
                firstOcr = i;
                break;
            }
        }

        // find the last occurance
        for (int i = n-1; i >= 0; i --) {
            if (nums[i] == target) {
                lastOcr = i;
                break;
            }
        }

        return new int[]{firstOcr, lastOcr};
    }
    */
    public int getFirstOcr(int[] nums, int n, int target) {
        int low = 0, high = n-1;
        int firstOcr = -1;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if (nums[mid] == target) {
                firstOcr = mid;
                high = mid-1;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return firstOcr;
    }
    public int getLastOcr(int[] nums, int n, int target) {
        int low = 0, high = n-1;
        int lastOcr = -1;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if (nums[mid] == target) {
                lastOcr = mid;
                low = mid + 1;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return lastOcr;
    }
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return new int[]{-1, -1};

        int firstOcr = getFirstOcr(nums, n, target);
        int lastOcr = getLastOcr(nums, n, target);

        return new int[]{firstOcr, lastOcr};
    }

    public static void main(String[] args) {
        var obj = new FindFirstAndLastPositionOfElementInSortedArray();

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] range = obj.searchRange(nums, target);
        System.out.println(Arrays.toString(range));
    }
}
