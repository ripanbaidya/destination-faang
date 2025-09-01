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
 * An element is considered a leader if it is greater than or equal to all elements to its right. The
 * rightmost element is always a leader.
 *
 * Examples:
 * Input: arr = [16, 17, 4, 3, 5, 2]
 * Output: [17, 5, 2]
 * Explanation: Note that there is nothing greater on the right side of 17, 5 and, 2
 */
public class LeadersInArray {
    public List<Integer> leaders(int arr[]) {
        int n = arr.length;
        List<Integer> leaders = new ArrayList<>();

        // last element in array is always considered as leader
        // because it is greater than all the elements to its right
        int rightMaxi = arr[n-1];
        leaders.add(arr[n-1]);

        // finding leader from the end.
        for(int i = n-2; i >= 0; i --){
            if(arr[i] >= rightMaxi){
                leaders.add(arr[i]); // adding leader
                rightMaxi = arr[i]; // updating rightMax
            }
        }

        Collections.reverse(leaders);
        return leaders;
    }

    public static void main(String[] args) {
        var obj = new LeadersInArray();

        int[] arr = {16, 17, 4, 3, 5, 2};
        List<Integer> leaders = obj.leaders(arr);

        System.out.println("Leaders are: "+ leaders);
    }
}
