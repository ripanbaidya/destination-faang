package array.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * Example
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int prefSum = 0, totalCnt = 0;

        mp.put(0, 1); // to handle case when prefix sum itself is equal to k

        for (int i = 0; i < n; i++) {
            prefSum += nums[i];
            int remaining = prefSum - k;

            if (mp.containsKey(remaining)) {
                totalCnt += mp.get(remaining);
            }

            mp.put(prefSum, mp.getOrDefault(prefSum, 0) + 1);
        }

        return totalCnt;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK obj = new SubarraySumEqualsK();

        int[] arr = {1,1,1};
        int k = 2;

        int count = obj.subarraySum(arr, k);
        System.out.println("Subarray count: "+ count);
    }
}
