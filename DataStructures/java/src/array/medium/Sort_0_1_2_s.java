package array.medium;

import java.util.Arrays;
/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that
 * objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue.
 * You must solve this problem without using the library's sort function.
 * Could you come up with a one-pass algorithm using only constant extra space?
 *
 * Example :
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */

/**
 * // using built in function
 * public void sortColors(int[] nums) {
 *         Arrays.sort(nums);
 * }
 */

/**
 * // better solution
 * public void sortColors(int[] nums) {
 *         int n = nums.length;
 *
 *         // we use c1, c2, c3 to denote three different colors
 *         int c1 = 0, c2 = 0, c3 = 0;
 *
 *         // count the occurrence of each color in the array
 *         for (int i = 0; i < n; i ++){
 *             if(nums[i] == 0) c1 ++;
 *             else if(nums[i] == 1) c2 ++;
 *             else if(nums[i] == 2) c3 ++;
 *         }
 *
 *         int it = 0;  // iterator
 *
 *         // replace the array elements with the three different colors
 *         while(c1 != 0){
 *             nums[it ++] = 0;
 *             c1 --;
 *         }
 *         while(c2 != 0){
 *             nums[it ++] = 1;
 *             c2 --;
 *         }
 *         while(c3 != 0){
 *             nums[it ++] = 2;
 *             c3 --;
 *         }
 *     }
 */

// optimal solution
public class Sort_0_1_2_s {
    // function to swap two numbers
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n-1;

        while (mid <= high){
            if (nums[mid] == 0){
                swap(nums, low, mid);
                low ++;
                mid ++;
            }
            else if (nums[mid] == 1){
                mid ++;
            }
            else {
                swap(nums, mid, high);
                high --;
            }
        }
    }

    public static void main(String[] args) {
        var obj = new Sort_0_1_2_s();

        int[] nums = {2,0,2,1,1,0};
        obj.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
