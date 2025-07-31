package array.medium;

import java.util.Arrays;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 *
 * Example:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class LongestConsecutiveSequence {
    // optimal solution
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;

        Arrays.sort(nums);
        int longestSeq = 1; // length of the longest consecutive sequence
        int currElement = nums[0], currCount = 1;

        for (int num : nums){
            // when sequence is consecutive
            if(num == currElement+1) {
                // update the current sequence count
                currCount ++;

                // update the longest consecutive sequence count
                longestSeq = Math.max(longestSeq, currCount);

                // update the current element
                currElement = num;
            } else if(num == currElement) {
                // in case of duplicates, skip them
                continue;
            } else {
                // reset the current count and update the current element
                currCount = 1;
                currElement = num;
            }
        }

        return longestSeq;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();

        int length = obj.longestConsecutive(new int[]{100,4,200,1,3,2});
        System.out.println("Length of longest consecutive sequence: "+ length);
    }
}
