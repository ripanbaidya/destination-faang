package linkedlist.easy;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached
 * again by continuously following the next pointer. Internally, pos is used to denote the
 * index of the node that tail's next pointer is connected to. Note that pos is not passed
 * as a parameter.
 * - Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 */

import linkedlist.representation.singly.ListNode;

/**
 * // Brute force solution
 * public boolean hasCycle(ListNode head) {
 *         Set<ListNode> st = new HashSet<>();
 *
 *         // Iterate through the list and put node to the set
 *         while(head != null) {
 *             // Check whether the node is already in the set or not
 *             if(st.contains(head)) return true;
 *
 *             st.add(head);
 *
 *             // move to the next node
 *             head = head.next;
 *         }
 *
 *         return false;
 *     }
 */
public class DetectCycle {
    public boolean hasCycle(ListNode head) {
        // slow and fast pointer
        ListNode slow = head, fast = head;

        // Iterate through the list
        while(fast != null && fast.next != null) {
            // move slow pointer by one step
            slow = slow.next;

            // move first pointer by two-step
            fast = fast.next.next;

            // when slow and first are at the same place
            // that means there is a cycle
            if(slow == fast) {
                return true;
            }
        }

        // cycle not found
        return false;
    }
}
