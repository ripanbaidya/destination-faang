package array.easy;

/**
 * @author Ripan Baidya
 * @date 30-07-2025
 *
 * Given an array of integers nums[], the task is to check whether the array is sorted and rotated or not.
 * An array is said to be sorted and rotated if it is sorted in ascending order and then rotated some number
 * of times.
 *
 * Example:
 * Input: nums[] = [3, 4, 5, 1, 2]
 * Output: true
 * Explanation: The array is sorted and rotated.
 */
public class IsArraySortedAndRotated {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 1;

        for (int i = 1; i < 2*n; i ++){
            // count the number of sorted elements
            if (nums[(i-1)%n] <= nums[i%n]){
                count += 1;
            } else {
                count = 1;
            }

            // If we have found a point where the order breaks
            // and the count of sorted elements is equal to n,
            // it means the array is sorted and rotated.
            if(count == n) return true;
        }

        return n == 1;
    }

    public static void main(String[] args) {
        IsArraySortedAndRotated obj = new IsArraySortedAndRotated();

        int[] nums = {3, 4, 5, 1, 2};
        boolean result = obj.check(nums);

        System.out.println("Is array sorted and rotated: "+ result);
    }
}
