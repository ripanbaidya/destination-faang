package array.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given an array arr[] containing integers and an integer k, your task is to find the length
 * of the longest subarray where the sum of its elements is equal to the given value k. If there
 * is no subarray with sum equal to k, return 0.
 *
 * Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
 * Output: 6
 * Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.
 */
public class LongestSubarrayWithSumK {
    // This code will work for both positive and negative integers in array.
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int longest = 0;

        Map<Integer, Integer> mp = new HashMap<>(); // {prefixSum, index}
        int prefSum = 0;

        for(int i = 0; i < n; i ++){
            // calculating the prefix sum
            prefSum += arr[i];

            // if the prefix sum is equal to k, then the longest subarray is from index 0 to i
            if(prefSum == k) longest = i+1;

            // if we have seen this remaining prefix sum before, it means there is a subarray
            int remaining = prefSum - k;

            if(mp.containsKey(remaining))
                longest = Math.max(longest, i - mp.get(remaining));

            if(!mp.containsKey(prefSum))
                mp.put(prefSum, i);
        }

        return longest;
    }

    public static void main(String[] args) {
        LongestSubarrayWithSumK obj = new LongestSubarrayWithSumK();

        int[] arr = {10, 5, 2, 7, 1, -10};
        int k = 15;

        int result = obj.longestSubarray(arr, k);
        System.out.println("Length of the longest subarray  is: " + result);
    }
}
