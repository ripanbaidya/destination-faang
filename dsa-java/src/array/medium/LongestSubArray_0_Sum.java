package array.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given an array arr[] containing both positive and negative integers, the task is to find the
 * length of the longest subarray with a sum equals to 0.
 * Note: A subarray is a contiguous part of an array, formed by selecting one or more consecutive
 * elements while maintaining their original order.
 *
 * Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
 * Output: 5
 * Explanation: The longest subarray with sum equals to 0 is [-2, 2, -8, 1, 7].
 */
public class LongestSubArray_0_Sum {
    int maxLen(int nums[]) {
        int n = nums.length;
        int maxiLen = 0, prefSum = 0;
        Map<Integer, Integer> mp = new HashMap<>(); // {prefSum, index}

        for(int i = 0; i < n; i ++){
            prefSum += nums[i];

            if(prefSum == 0){
                maxiLen = i+1;
            } else {
                // check current prefix sum is present in hash map or not
                if(mp.containsKey(prefSum)){
                    // update the maximum length
                    maxiLen = Math.max(maxiLen, i-mp.get(prefSum));
                } else {
                    mp.put(prefSum, i);
                }
            }
        }

        return maxiLen;
    }

    public static void main(String[] args) {
        LongestSubArray_0_Sum obj = new LongestSubArray_0_Sum();

        int[] nums = {15, -2, 2, -8, 1, 7, 10, 23};
        int result = obj.maxLen(nums);

        System.out.println("Maximum length: " + result);
    }
}
