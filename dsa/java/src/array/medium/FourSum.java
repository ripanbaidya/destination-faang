package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given an array nums of n integers, return an array of all the unique quadruplets
 * [nums[a], nums[b], nums[c], nums[d]] such that:
 * - 0 <= a, b, c, d < n
 * - a, b, c, and d are distinct.
 * - nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the result  wer in any order.
 *
 * Example:
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;

        // sort the array
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i ++){
            // skip element if it is same as previous
            if (i > 0 && nums[i] == nums[i-1]) continue;

            for (int j = i+1; j < n; j ++){
                // skip element if it is same as previous
                if (j > i+1 && nums[j] == nums[j-1]) continue;

                int k = j+1;
                int l = n-1;

                while (k < l){
                    long sum = (long) nums[i] + nums[j];
                    sum += nums[k];
                    sum += nums[l];

                    if(sum == target){
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        result.add(temp);

                        // update k and l
                        k ++;
                        l --;

                        // skip duplicates for k and l
                        while(k < l && nums[k] == nums[k-1]) k ++;
                        while(k < l && nums[l] == nums[l+1]) l --;
                    } else if(sum < target) {
                        k ++;
                    } else {
                        l --;
                    }
                }
            }
        }

        return result ;
    }

    public static void main(String[] args) {
        FourSum obj = new FourSum();

        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;

        List<List<Integer>> result = obj.fourSum(nums, target);
        System.out.println(result);
    }
}
