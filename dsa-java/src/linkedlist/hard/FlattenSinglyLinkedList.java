package linkedlist.hard;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given a linked list containing n head nodes where every node in the linked list contains two pointers:
 * (i) next points to the next node in the list.
 * (ii) bottom pointer to a sub-linked list where the current node is the head.
 * Each of the sub-linked lists nodes and the head nodes are sorted in ascending order based on their data.
 * Your task is to flatten the linked list such that all the nodes appear in a single level while maintaining
 * the sorted order.
 *
 * Note:
 * 1. ↓ represents the bottom pointer and -> represents the next pointer.
 * 2. The flattened list will be printed using the bottom pointer instead of the next pointer.
 */


public class FlattenSinglyLinkedList {
    static class Node {
        int data;
        Node next, bottom;
        Node(int x) {
            data = x;
            next = null;
            bottom = null;
        }
    }

    public Node mergeTwoList(Node a, Node b) {
        Node dummy = new Node(-1);
        Node temp = dummy;

        while(a != null && b != null) {
            if(a.data <= b.data) {
                temp.bottom = a;
                a = a.bottom;
            } else {
                temp.bottom = b;
                b = b.bottom;
            }
            temp = temp.bottom;
            temp.next = null;
        }
        temp.bottom = (a == null) ? b : a;

        return dummy.bottom;
    }
    public Node flatten(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node mergedHead = flatten(head.next);
        return mergeTwoList(head, mergedHead);
    }
}
