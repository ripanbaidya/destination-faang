package linkedlist.medium;

import linkedlist.representation.singly.Node;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given the head of a linked list, determine whether the list contains a loop.
 * If a loop is present, return the number of nodes in the loop, otherwise return 0.
 * - Note: 'c' is the position of the node which is the next pointer of the last node
 * of the linked list. If c is 0, then there is no loop.
 *
 * Input: head: 1 → 2 → 3 → 4 → 5, c = 2
 * Output: 4
 * Explanation: There exists a loop in the linked list and the length of the loop is 4
 */
public class FindCycleLength {
    // Function to find the length of a loop in the linked list.
    public int countNodesInLoop(Node head) {
        Node slow = head, fast = head;
        int length = 0;

        // Iterate through the list
        while(fast != null && fast.next != null) {
            slow = slow.next; // move by one step
            fast = fast.next.next; // move by two-step

            // if theirs is a cycle/loop
            if(slow == fast) {
                // take a 'temp' node, which is next node of slow or fast
                Node temp = slow.next;
                length = 1;

                // find the length of the loop
                while(temp != fast) {
                    length ++;
                    temp = temp.next;
                }

                // make sure break the loop otherwise it would result as TLE
                break;
            }
        }

        // loop length
        return length;
    }
}
