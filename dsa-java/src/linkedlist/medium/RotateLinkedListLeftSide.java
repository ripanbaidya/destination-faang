package linkedlist.medium;

import linkedlist.representation.singly.Node;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given the head of a singly linked list, your task is to left rotate the linked list k times.
 *
 * Input: head = 10 -> 20 -> 30 -> 40 -> 50, k = 4
 * Output: 50 -> 10 -> 20 -> 30 -> 40
 * Explanation:
 * Rotate 1: 20 -> 30 -> 40 -> 50 -> 10
 * Rotate 2: 30 -> 40 -> 50 -> 10 -> 20
 * Rotate 3: 40 -> 50 -> 10 -> 20 -> 30
 * Rotate 4: 50 -> 10 -> 20 -> 30 -> 40
 */
public class RotateLinkedListLeftSide {
    // find length of linked list
    public int getLength(Node head) {
        int linkedListLength = 0;

        while(head != null) {
            linkedListLength ++;
            head = head.next;
        }

        return linkedListLength;
    }

    public Node rotate(Node head, int k) {
        if(head == null || head.next == null) {
            return head;
        }

        int linkedListLength = getLength(head);

        // adjust the length
        k = k % linkedListLength;

        // no need to do anything
        if(k == 0 || k == linkedListLength) {
            return head;
        }

        Node kthNode = head;

        // move to the kth node
        for(int i = 1; i <= k-1; i ++) {
            kthNode = kthNode.next;
        }

        // whatever the next of kth node would be the new head
        Node newHead = kthNode.next;

        // make kth-Node point to null
        kthNode.next = null;

        Node temp = newHead;
        while(temp.next != null) {
            temp = temp.next;
        }
        // make the newHead's next point to the original head
        temp.next = head;

        return newHead;
    }
}
