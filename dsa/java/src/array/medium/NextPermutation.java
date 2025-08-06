package array.medium;

import java.util.Arrays;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 * For example, for arr = [1,2,3], permutations: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
 *
 * The next permutation of an array of integers is the next lexicographically greater permutation of its
 * integer. More formally, if all the permutations of the array are sorted in one container according to
 * their lexicographical order, then the next permutation of that array is the permutation that follows it
 * in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest
 * possible order (i.e., sorted in ascending order).
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 */
public class NextPermutation {
    // swap two numbers
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    // reverse array
    private void reverse(int[] nums, int left, int right){
        while(left <= right){
            swap(nums, left ++, right --);
        }
    }

    // optimal solution
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;

        // find the pivot
        for(int i = n-2; i >= 0; i --){
            if(nums[i] < nums[i+1]){
                pivot = i;
                break;
            }
        }

        // when no pivot found
        if(pivot == -1){
            reverse(nums, 0, n-1);
            return;
        }

        // find the first greater element from the end
        for(int i = n-1; i >= pivot; i --){
            if(nums[i] > nums[pivot]){
                swap(nums, i, pivot);
                break;
            }
        }

        // reverse
        reverse(nums, pivot+1, n-1);
    }

    public static void main(String[] args) {
        var obj = new NextPermutation();

        int[] nums = {1, 3, 2};

        obj.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
