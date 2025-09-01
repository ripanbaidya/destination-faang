package linkedlist.medium;

import linkedlist.representation.singly.ListNode;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 */

/**
 * // Brute force solution
 * class Solution {
 *     public int getLength(ListNode head) {
 *         int length = 0;
 *         while(head != null) {
 *             length ++;
 *             head = head.next;
 *         }
 *         return length;
 *     }
 *
 *     public ListNode removeNthFromEnd(ListNode head, int n) {
 *         int length = getLength(head); // get linked list length
 *         ListNode temp = head; // temp node to traverse
 *
 *         // if n is equal to length, remove the first node
 *         if(length == n) return head.next;
 *
 *         // if linked list is empty or has only one node, return head
 *         if(head == null || head.next == null) return head;
 *
 *         // traverse to the node before the node to be removed
 *         for(int i = 1; i <= length-n-1; i ++) {
 *             temp = temp.next;
 *         }
 *         temp.next = temp.next.next;
 *
 *         return head;
 *     }
 * }
 */
public class Remove_N_th_Node_FromEnd {
    // Optimal solution
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;

        // move the fist pointer by n steps
        for(int i = 1; i <= n; i ++) {
            fast = fast.next;
        }

        // if fast pointer is at the end, remove the first node
        if(fast == null) return head.next;

        // move both pointers by one step
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // remove the nth node, by skipping the next node
        slow.next = slow.next.next;

        return head;
    }
}
