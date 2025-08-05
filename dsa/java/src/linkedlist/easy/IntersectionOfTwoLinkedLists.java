package linkedlist.easy;

import linkedlist.representation.singly.ListNode;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given two linked lists head1 and head2, find the intersection of two linked lists.
 * Each of the two linked lists contains distinct node values.
 * Note: The order of nodes in this list should be the same as the order in which those
 * particular nodes appear in input head1 and return null if no common element is present.
 *
 * Examples:
 */

/**
 * // Brute Force Solution
 * public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
 *         Set<ListNode> st = new HashSet<>();
 *
 *         while(headA != null) {
 *             st.add(headA);
 *             headA = headA.next;
 *         }
 *         while(headB != null) {
 *             if(st.contains(headB)) {
 *                 return headB;
 *             }
 *
 *             st.add(headB);
 *             headB = headB.next;
 *         }
 *
 *         return null;
 *     }
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;

        while(a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }
}
