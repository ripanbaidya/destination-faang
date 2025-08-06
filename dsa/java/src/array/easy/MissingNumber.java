package array.easy;

/**
 * @author Ripan Baidya
 * @date 30-07-2025
 *
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number
 * in the range that is missing from the array.
 *
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the
 * missing number in the range since it does not appear in nums.
 */

/**
 * // Better solution
 * class Solution {
 *     public int missingNumber(int[] nums) {
 *         int n = nums.length;
 *         boolean[] hash = new boolean[n+1];
 *
 *         // mark elements that are present in array
 *         for(int i = 0; i < n; i ++){
 *             hash[nums[i]] = true;
 *         }
 *
 *         // find the missing element
 *         for(int i = 0; i < n+1; i ++){
 *             if(!hash[i]){
 *                 return i;
 *             }
 *         }
 *
 *         return -1;
 *     }
 * }
 */
public class MissingNumber {
    // Optimal solution
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sumN = (n* (n+1))/2; // Sum of first n natural numbers
        int actualSum = 0; // store the sum of elements in nums

        for(int num : nums){
            actualSum += num;
        }

        // The missing number is the difference between the expected sum and the actual sum
        return sumN - actualSum;
    }

    public static void main(String[] args) {
        MissingNumber obj = new MissingNumber();

        int[] nums = {3,0,1};
        int missingNumber = obj.missingNumber(nums);

        System.out.println("Missing number: "+ missingNumber);
    }
}
