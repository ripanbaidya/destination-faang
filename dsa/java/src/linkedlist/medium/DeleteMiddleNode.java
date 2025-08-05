package linkedlist.medium;

import linkedlist.representation.singly.ListNode;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
 * The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋
 * denotes the largest integer less than or equal to x.
 *
 * For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 *
 * Input: head = [1,3,4,7,1,2,6]
 * Output: [1,3,4,1,2,6]
 * Explanation:
 * The above figure represents the given linked list. The indices of the nodes are written below.
 * Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
 * We return the new list after removing this node.
 */
public class DeleteMiddleNode {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode fast = head, slow = head;
        ListNode midPrev = head;

        while(fast != null && fast.next != null) {
            // store the previous node, which is the middle
            midPrev = slow;

            slow = slow.next; // move slow pointer by one step
            fast = fast.next.next; // move fast pointer by two-step
        }

        // remove the middle node
        midPrev.next = midPrev.next.next;

        return head;
    }
}
