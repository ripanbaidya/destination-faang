package array.easy;

/**
 * @author Ripan Baidya
 * @date 30-07-2025
 *
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 *
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The
 * maximum number of consecutive 1s is 3.
 */
public class MaximumConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxiCount = 0, currCount = 0;

        for (int i = 0; i < n; i ++){
            if (nums[i] == 1){
                currCount ++;

                // update the maximum count
                maxiCount = Math.max(maxiCount, currCount);
            } else {
                // reset the current count
                currCount = 0;
            }
        }

        return maxiCount;
    }

    public static void main(String[] args) {
        MaximumConsecutiveOnes obj = new MaximumConsecutiveOnes();

        int[] nums = {1,1,0,1,1,1};
        int maximumConsecutiveOnes = obj.findMaxConsecutiveOnes(nums);

        System.out.println(maximumConsecutiveOnes);
    }
}
