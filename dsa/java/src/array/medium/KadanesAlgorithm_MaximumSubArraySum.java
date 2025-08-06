package array.medium;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 * In interview, you might ask to print the sub-array which gives us the maximum sum.
 *
 * Example:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 */
public class KadanesAlgorithm_MaximumSubArraySum {
    // optimal solution
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int currentSum = 0;
        int maxiSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i ++){
            currentSum += nums[i];

            // update the maximum sum
            maxiSum = Math.max(maxiSum, currentSum);

            // reset the sum when it becomes negative
            if(currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxiSum;
    }
    public static void main(String[] args) {
        var obj = new KadanesAlgorithm_MaximumSubArraySum();

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int maximumSum = obj.maxSubArray(nums);

        System.out.println(maximumSum);
    }
}
