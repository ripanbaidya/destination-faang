package linkedlist.representation.doubly;


/**
 * @author Ripan Baidya
 * @date 31-07-2025
 * <p>
 * In this program, we will create a Doubly Linked List and perform various operations on it.
 * We will create a ListNode class which will represent each node in the linked list.
 */
public class ListNode {
    public int data;
    public ListNode next;
    public ListNode prev;

    public ListNode() {}
    public ListNode(int data) {
        this.data = data;
    }

    public ListNode(int data, ListNode next, ListNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
