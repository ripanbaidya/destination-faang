package linkedlist.easy;

import linkedlist.representation.singly.Node;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given head of a singly linked list. The task is to find the length of the linked list,
 * where length is defined as the number of nodes in the linked list.
 *
 * Input: head : 1->2->3->4->5
 * Output: 5
 * Explanation: Length of the linked list is 5, as there
 * are 5 nodes present in it.
 */
public class FindLinkedListLength {
    // Function to count nodes of a linked list.
    public int getCount(Node head) {
        Node temp = head; // temporary pointer
        int len = 0; // count linked list length

        while(temp != null){
            len ++;
            temp = temp.next;
        }

        return len;
    }
}
