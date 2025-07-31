package linkedlist.medium;

import linkedlist.representation.singly.ListNode;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 */
public class ReverseLinkedListRecursive {
    // Recursive solution
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        // reverse the linked list
        ListNode newNode = reverseList(head.next);

        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newNode;
    }
}
