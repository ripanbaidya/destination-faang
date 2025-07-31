package linkedlist.medium;

import linkedlist.representation.singly.ListNode;
import linkedlist.representation.singly.Node;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given the head of a linked list where nodes can contain values 0s, 1s, and 2s only.
 * Your task is to rearrange the list so that all 0s appear at the beginning, followed
 * by all 1s, and all 2s are placed at the end.
 *
 * Input: head = 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2
 * Output: 0 → 1 → 1 → 2 → 2 → 2 → 2 → 2
 * Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in between.
 */
public class SortLinkedList_0_1_2_s {
    public Node segregate(Node head) {
        Node curr = head;
        Node zero = new Node(-1), one = new Node(-1), two = new Node(-1);
        Node zHead = zero, oHead = one, tHead = two;

        while(curr != null) {
            if (curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.data == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }

        // Connect the three lists
        zero.next = oHead.next != null ? oHead.next : tHead.next;
        one.next = tHead.next;
        two.next = null;  // terminate

        return zHead.next;
    }
}
