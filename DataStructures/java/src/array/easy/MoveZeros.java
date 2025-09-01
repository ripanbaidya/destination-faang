package array.easy;

import java.util.Arrays;

/**
 * @author Ripan Baidya
 * @date 30-07-2025
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order
 * of the non-zero elements. Note that you must do this in-place without making a copy of the array.
 *
 * Example:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int n = nums.length;

        // Initialize a pointer to keep track of the position
        // of the next non-zero element.
        int front = 0;

        // Traverse the array. If the current element is not zero, place it at the 'front' position
        // and move the 'front' pointer to the next position.
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[front++] = nums[i];
            }
        }
        
        // After placing all non-zero elements at the beginning, fill the rest of the array
        // with zeros starting from the 'front' position.
        for (int i = front; i < n; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeros obj = new MoveZeros();

        int[] nums = {0, 1, 0, 3, 12};
        obj.moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }
}
