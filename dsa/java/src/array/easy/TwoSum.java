package array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that
 * they add up to target. You may assume that each input would have exactly one solution, and you may
 * not use the same element twice. You can return the answer in any order.
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

/**
 * // brute force approach
 * class Solution {
 *     public int[] twoSum(int[] nums, int target) {
 *         int n = nums.length;
 *
 *         // try all possible pair
 *         for(int i = 0; i < n; i ++){
 *             for(int j = i+1 ; j < n; j ++){
 *                 if(nums[i] + nums[j] == target){
 *                     return new int[]{i, j}; // pair found
 *                 }
 *             }
 *         }
 *
 *         // pair not found
 *         return new int[]{-1, -1};
 *     }
 * }
 */
public class TwoSum {
    // Optimal solution - using hashmap
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>(); // {element, index}

        for (int i = 0; i < n; i ++){
            // calculate the required element to form the target sum
            int required = target - nums[i];

            // check whether required element already exist
            // in the hashmap or not.
            if (mp.containsKey(required)){
                // if it exists, then we have found the pair
                return new int[]{i, mp.get(required)};
            }

            // put the current element and its index in the hashmap
            mp.put(nums[i], i);
        }

        // pair not found
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] pair = obj.twoSum(nums, target);
        System.out.println(Arrays.toString(pair));
    }
}
