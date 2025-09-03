package binarysearch.medium;

/**
 * @author Ripan Baidya
 * @date 03-09-2025
 *
 * Given a sorted array, arr[] and a number target, you need to find the number of
 * occurrences of target in arr[].
 *
 * Examples :
 *
 * Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
 * Output: 4
 * Explanation: target = 2 occurs 4 times in the given array so the output is 4.
 */
public class NumberOfOccurrence {
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

    int countFreq(int[] nums, int target) {
        int n = nums.length;
        int first = getFirstOcr(nums, n, target);
        if (first == -1) return 0;
        int last = getLastOcr(nums, n, target);

        return last-first+1;
    }

    public static void main(String[] args) {
        var obj = new NumberOfOccurrence();

        int[] nums = {1, 1, 2, 2, 2, 2, 3};
        int target = 2;
        int count = obj.countFreq(nums, target);
        System.out.println("count = " + count);
    }
}
