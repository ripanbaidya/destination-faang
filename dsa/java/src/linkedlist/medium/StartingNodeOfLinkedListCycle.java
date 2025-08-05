package linkedlist.medium;

import linkedlist.representation.singly.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
 * following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
 * is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 * - Do not modify the linked list.
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 */

/**
 * // Brute force solution
 * public ListNode detectCycle(ListNode head) {
 *         if(head == null || head.next == null) return null;
 *         Set<ListNode> st = new HashSet<>();
 *
 *         while(head != null) {
 *             if(st.contains(head)) return head;
 *             st.add(head);
 *
 *             head = head.next;
 *         }
 *
 *         return null;
 *     }
 */
public class StartingNodeOfLinkedListCycle {
    // Optimal solution
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            // move slow pointer by one step
            slow = slow.next;

            // move fist pointer by two-step
            fast = fast.next.next;

            // when there is a cycle
            if(slow == fast) {
                // reset any one of the pointer
                // here, we are resetting slow pointer
                slow = head;

                // move slow and fast one by one step until they met
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // we can return either slow or fast
                // both would be point to the stating of the cycle
                return slow;
            }
        }

        // cycle not found
        return null;
    }
}
