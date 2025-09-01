package linkedlist.easy;

import linkedlist.representation.singly.Node;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given a linked list of n nodes and a key, the task is to check if the key is present in the linked list or not.
 *
 * Input: n = 4, key = 3
 * 1->2->3->4
 * Output: true
 * Explanation: 3 is present in Linked List, so the function returns true.
 */
public class SearchInLinkedList {
    public boolean searchKey(int n, Node head, int key) {
        Node temp = head;
        while(temp != null){
            if(temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }
}
