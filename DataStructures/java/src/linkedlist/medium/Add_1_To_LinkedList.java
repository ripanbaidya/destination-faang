package linkedlist.medium;

import linkedlist.representation.singly.Node;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * You are given a linked list where each element in the list is a node and have an integer data.
 * You need to add 1 to the number formed by concatinating all the list node numbers together and
 * return the head of the modified linked list.
 * Note: The head represents the first element of the given array.
 *
 * Input: LinkedList: 4->5->6
 * Output: 457
 * Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457.
 */
public class Add_1_To_LinkedList {
    public Node reverseList(Node head) {
        if(head == null || head.next == null) return head;
        Node curr = head, prev = null;

        while(curr != null) {
            Node front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
        return prev;
    }
    public Node addOne(Node head) {
        Node revHead = reverseList(head);

        Node curr = revHead;
        int carry = 1;

        while(curr != null) {
            int sum = carry + curr.data;

            curr.data = (sum % 10);
            carry = (sum / 10);

            if(carry == 0 || curr.next == null) {
                break;
            }

            // move to the next element
            curr = curr.next;
        }

        if(carry > 0) {
            curr.next = new Node(carry);
        }

        return reverseList(revHead);
    }
}
