package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * You are given an array arr of positive integers. Your task is to find all the leaders in the array.
 * An element is considered a leader if it is greater than or equal to all elements to its right.
 * The rightmost element is always a leader.
 *
 * Examples:
 * Input: arr = [16, 17, 4, 3, 5, 2]
 * Output: [17, 5, 2]
 * Explanation: Note that there is nothing greater on the right side of 17, 5 and, 2
 */
public class LeadersInArray {
    // optimal solution
    public List<Integer> leaders(int arr[]) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<Integer>(); // leaders

        // last element in array always leader
        int rightMaxi = arr[n-1]; // largest element from the right side
        ans.add(arr[n-1]);

        // finding leader from the end.
        for(int i = n-2; i >= 0; i --){
            if(arr[i] >= rightMaxi){
                ans.add(arr[i]);
                rightMaxi = arr[i];
            }
        }

        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        LeadersInArray obj = new LeadersInArray();

        int[] arr = {16, 17, 4, 3, 5, 2};

        List<Integer> leaders = obj.leaders(arr);
        System.out.println("Leaders are: "+ leaders);
    }
}
