package array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Input: nums = [2,2,1]
 * Output: 1
 */

/**
 * // Brute Force Approach
 * class Solution {
 *     public int singleNumber(int[] nums) {
 *         Map<Integer, Integer> mp = new HashMap<>(); // {element, count}
 *
 *         // count the occurrence of each element
 *         for (int num : nums){
 *             mp.put(num, mp.getOrDefault(num, 0) + 1);
 *         }
 *
 *         // find element which has single occurrence
 *         for (int k : mp.keySet()){
 *             if (mp.get(k) == 1)
 *                 return k;
 *         }
 *
 *         // if no single element found, return -1
 *         return -1;
 *     }
 * }
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;

        // Using XOR operation to find the single number
        for(int num : nums){
            result ^= num;
        }

        return result;
    }
}
