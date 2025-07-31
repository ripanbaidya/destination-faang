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

/**
 * // Brute force solution: stack based
 * public ListNode reverseList(ListNode head) {
 *         ListNode temp = head;
 *         Stack<Integer> stk = new Stack<>();
 *
 *         // push node's value into stack
 *         while(temp != null){
 *             stk.push(temp.val);
 *             temp = temp.next;
 *         }
 *
 *         // reset the temp to head
 *         temp = head;
 *
 *         // replace node's value by the elements stores in stack
 *         while(temp != null) {
 *             temp.val = stk.pop();
 *             temp = temp.next;
 *         }
 *
 *         return head;
 *     }
 */
public class ReverseLinkedListIterative {
    // Iterative solution
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode temp = head;

        // reverse the linked list
        while(temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        // prev would be the head of reversed linked list
        return prev;
    }
}
