package array.easy;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 *
 * Example :
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 */

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        // assuming our first element is the majority element
        int major = nums[0];

        // count the occurrence of majority element
        int count = 1;

        // counting thr frequency of each element
        for (int i = 1; i < n; i ++){
            // when no majority element exist, set current element as majority element
            // set the majority count to 1
            if(count == 0){
                major = nums[i];
                count = 1;
            }

            // when current element is equivalent to major increase the count
            else if(nums[i] == major) count ++;

            // when current element is not equivalent to major
            // decrease the count
            else if (nums[i] != major) count --;
        }

        // reset the count, to count the occurrence of new majoritu element
        count = 0;

        // re-ensure that the major element is actually appear > n/2 times
        for (int num : nums){
            if (num == major)
                count ++;
        }

        // return the majority element and if not found then -1
        return count > n/2 ? major : -1;
    }

    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();

        int[] nums = {2,2,1,1,1,2,2};

        int majorityElement = obj.majorityElement(nums);
        System.out.println("Majority element: "+ majorityElement);
    }
}
