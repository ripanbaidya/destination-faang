package linkedlist.easy;

import linkedlist.representation.singly.ListNode;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 *
 * Input: head = [1,2,2,1]
 * Output: true
 */

/**
 * // Brute force solution
 * public boolean isPalindrome(ListNode head) {
 *         if(head == null || head.next == null) return true;
 *
 *         ListNode currNode = head; // To iterate in the list
 *         Stack<Integer> stk = new Stack<>(); // To store elements
 *
 *         // Push all elements of the list to the stack
 *         while(currNode != null) {
 *             stk.push(currNode.val);
 *             currNode = currNode.next;
 *         }
 *
 *         // Iterate in the list again and check
 *         // by popping from the stack
 *         currNode = head;
 *
 *         //
 *         while(currNode != null) {
 *             if(currNode.val != stk.pop()) {
 *                 return false;
 *             }
 *             currNode = currNode.next;
 *         }
 *
 *         return true;
 *     }
 */
public class PalindromeLinkedList {
    // function to reverse the linked list
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }

        return prev;
    }

    // function to check if the linked list is palindrome
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head;

        // find the middle of the linked list
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the last/second half
        ListNode tail = reverseList(slow);

        // compare the first and second half
        while(tail != null) {
            if(head.val != tail.val) return false;

            // move both pointers
            head = head.next;
            tail = tail.next;
        }

        return true; // palindrome
    }
}
