package linkedlist.medium;

import linkedlist.representation.singly.ListNode;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 */
public class RotateLinkedListRightSide {
    public int getLength(ListNode head) {
        int length = 0;

        while(head != null) {
            length ++;
            head = head.next;
        }

        return length;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int length = getLength(head);
        k = k % length;

        if(k == length || k == 0) {
            return head;
        }

        ListNode kthNodePrev = head;
        ListNode kthNode = head;

        // traverse to the kth node from the end
        for(int i = 1; i <= (length-k-1); i ++) {
            kthNodePrev = kthNodePrev.next;
        }

        kthNode = kthNodePrev.next;
        ListNode newHead = kthNode;

        // make prev of kth node to null
        kthNodePrev.next = null;

        // move kth node to the last node
        while(kthNode.next != null) {
            kthNode = kthNode.next;
        }

        kthNode.next = head;

        return newHead;
    }
}
