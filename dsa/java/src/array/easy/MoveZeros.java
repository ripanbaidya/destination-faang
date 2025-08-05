package array.easy;

/**
 * @author Ripan Baidya
 * @date 30-07-2025
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int front = 0;

        for (int i = 0; i < n; i ++){
            if (nums[i] != 0){
                nums[front ++] = nums[i];
            }
        }
        for (int i = front; i < n; i ++){
            nums[i] = 0;
        }
    }
}
