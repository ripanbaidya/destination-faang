package array.medium;

import java.util.Arrays;

/**
 * @author Ripan Baidya
 * @date 30-07-2025
 *
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class RotateArrayRight {
    // reverse array
    private void reverse(int[] nums, int s, int e){
        while(s <= e){
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;

            s ++;
            e --;
        }
    }
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return; // No rotation needed
        int n = nums.length;
        k = k % n; // to handle cases where k >= n

        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);
    }

    public static void main(String[] args) {
        var obj = new RotateArrayRight();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        obj.rotate(nums, 3);

        System.out.println(Arrays.toString(nums));
    }
}
