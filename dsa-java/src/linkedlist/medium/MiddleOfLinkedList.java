package linkedlist.medium;

import linkedlist.representation.singly.ListNode;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 *
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 */

/**
 * // Better solution
 * class Solution {
 *     public int getLength(ListNode head){
 *         int length = 0;
 *         while(head != null){
 *             length ++;
 *             head = head.next;
 *         }
 *         return length;
 *     }
 *
 *     public ListNode middleNode(ListNode head) {
 *         int n = getLength(head); // get linked list length
 *
 *         // get the middle element
 *         for(int i = 0; i < n/2; i ++){
 *             head = head.next;
 *         }
 *         return head;
 *     }
 * }
 */
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        // slow and fast pointer
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            // move slow pointer by one step
            slow = slow.next;

            // move fast pointer by two-step
            fast = fast.next.next;
        }

        // slow would be the middle
        return slow;
    }
}

