package array.medium;

import java.util.*;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 */

/**
 * // better approach
 * class Solution {
 *     public List<List<Integer>> threeSum(int[] nums) {
 *         int n = nums.length;
 *
 *         // set to avoid duplicates
 *         Set<List<Integer>> resSet = new HashSet<>();
 *
 *         for (int i = 0; i < n; i ++){
 *             Set<Integer> st = new HashSet<>();
 *             for (int j = i+1; j < n; j ++){
 *                 int third = -(nums[i] + nums[j]);
 *
 *                 if(st.contains(third)){
 *                     List<Integer> triplet = Arrays.asList(nums[i], nums[j], third);
 *                     Collections.sort(triplet);
 *                     resSet.add(triplet);
 *                 }
 *                 st.add(nums[j]);
 *             }
 *         }
 *         return new ArrayList<>(resSet);
 *     }
 * }
 */
public class ThreeSum {
    // optimal solution
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums); // sort the array
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i ++){
            // skip element if it is same as previous
            if(i != 0 && nums[i] == nums[i-1]) continue;

            int j = i+1;
            int k = n-1;

            while (j < k){
                int total = nums[i] + nums[j] + nums[k];

                if(total < 0){
                    j ++;
                } else if (total > 0){
                    k --;
                } else {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    result.add(temp);

                    // update j and k
                    j ++;
                    k --;

                    // skip duplicates
                    while(j < k && nums[j] == nums[j-1]) j ++;
                    while(j < k && nums[k] == nums[k+1]) k --;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();

        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = obj.threeSum(nums);
        System.out.println(result);
    }
}
