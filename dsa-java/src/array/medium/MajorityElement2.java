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
        List<Integer> ans = new ArrayList<Integer>();

        int cnt1 = 0, cnt2 = 0;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i ++){
            if(cnt1 == 0 && nums[i] != ele2){
                cnt1 = 1;
                ele1 = nums[i];
            } else if(cnt2 == 0 && nums[i] != ele1){
                cnt2 = 1;
                ele2 = nums[i];
            } else if(ele1 == nums[i]){
                cnt1 ++;
            } else if(ele2 == nums[i]){
                cnt2 ++;
            } else {
                cnt1 --;
                cnt2 --;
            }
        }

        // reset the counts
        cnt1 = 0;
        cnt2 = 0;

        // counting the occurrence manually
        for(int num : nums){
            if(ele1 == num) cnt1 ++;
            else if(ele2 == num) cnt2 ++;
        }

        if(cnt1 > n/3) ans.add(ele1);
        if(cnt2 > n/3) ans.add(ele2);

        return ans;
    }

    public static void main(String[] args) {
        MajorityElement2 obj = new MajorityElement2();

        int[] nums = {3, 2, 3};
        List<Integer> result = obj.majorityElement(nums);

        System.out.println(Arrays.toString(nums));
    }
}
