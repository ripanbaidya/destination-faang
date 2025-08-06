package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Example :
 * Input: nums = [3,2,3]
 * Output: [3]
 */
public class MajorityElement2 {
    // optimal solution
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        int count1 = 0, count2 = 0; // count of element1 and element2
        int element1 = Integer.MIN_VALUE, element2 = Integer.MIN_VALUE;
        List<Integer> ans = new ArrayList<>(); // to store the majority elements

        for (int i = 0; i < n; i ++){
            if(count1 == 0 && nums[i] != element2){
                count1 = 1;
                element1 = nums[i];
            } else if(count2 == 0 && nums[i] != element1){
                count2 = 1;
                element2 = nums[i];
            } else if(element1 == nums[i]){
                count1 ++;
            } else if(element2 == nums[i]){
                count2 ++;
            } else {
                count1 --;
                count2 --;
            }
        }

        // resetting count of element1 and element2 to 0
        // to count the occurrence of element1 and element2 manually
        count1 = 0;
        count2 = 0;

        // counting the occurrence manually
        for(int num : nums){
            if(element1 == num) count1 ++;
            else if(element2 == num) count2 ++;
        }

        if(count1 > n/3) ans.add(element1);
        if(count2 > n/3) ans.add(element2);

        return ans;
    }

    public static void main(String[] args) {
        var obj = new MajorityElement2();

        int[] nums = {3, 2, 3};
        List<Integer> result = obj.majorityElement(nums);
        System.out.println(Arrays.toString(nums));
    }
}
