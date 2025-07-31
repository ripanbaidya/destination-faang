package linkedlist.medium;

import linkedlist.representation.singly.ListNode;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 */

/**
 * // Brute force solution
 * class Solution {
 *     public ListNode sortList(ListNode head) {
 *         List<Integer> li = new ArrayList<>();
 *         ListNode curr = head;
 *
 *         // store the value in a list
 *         while(curr != null) {
 *             li.add(curr.val);
 *             curr = curr.next;
 *         }
 *
 *         // sort them in ascending order
 *         Collections.sort(li);
 *
 *         int it = 0;
 *         curr = head;
 *         // replace the current list value by sorted value
 *         while(curr != null) {
 *             curr.val = li.get(it ++);
 *             curr = curr.next;
 *         }
 *
 *         return head;
 *     }
 * }
 */

public class SortLinkedList {
    public ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while(A != null && B != null) {
            if (A.val <= B.val) {
                dummy.next = A;
                A = A.next;
            } else {
                dummy.next = B;
                B = B.next;
            }

            dummy = dummy.next;
        }

        // elements present in either A or B
        dummy.next = (A == null) ? B : A;

        return head.next;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        // find the mid
        ListNode mid = findMid(head);
        ListNode leftHead = head, rightHead = mid.next;
        mid.next = null;

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);

        return mergeTwoLists(leftHead, rightHead);
    }
}
