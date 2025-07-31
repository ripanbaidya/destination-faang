package linkedlist.easy;

import linkedlist.representation.singly.ListNode;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by
 * splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 */
public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode dummy = new ListNode(-1); // dummy node
        ListNode head = dummy;

        // iterate through both lists and add the smaller element
        // to the dummy node, then move to the next node of that list
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

        // add the remaining elements of A or B
        dummy.next = (A == null) ? B : A;

        return head.next;
    }
}
