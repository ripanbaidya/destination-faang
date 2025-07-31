package linkedlist.hard;

import linkedlist.representation.singly.ListNode;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given the head of a linked list, reverse the nodes of the list k at a time, and
 * return the modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should
 * remain as it is.
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 */
public class ReverseNodesKGroup {
    // reverse the linked list
    public void reverseList(ListNode current) {
        if(current == null || current.next == null) return;
        ListNode prev = null;
        ListNode next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
    }

    // find kth node of the linked list
    public ListNode getKthNode(ListNode currentNode, int k) {
        k -= 1; // adjust the k
        while(currentNode != null && k != 0) {
            k --;
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    // reverse the k group - main function
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode currentNode = head;
        ListNode previousNode = null; // this is the node which is going to point to the next group

        while(currentNode != null) {
            ListNode kthNode = getKthNode(currentNode, k);

            // when there is no group of size k
            if(kthNode == null) {
                if(previousNode != null) {
                    previousNode.next = currentNode;
                    break;
                }
            }

            // next node of the kth node
            ListNode nextNodeOfKthNode = kthNode.next;

            // make kth next points to null, to segrigate it from the ll
            kthNode.next = null;

            // reverse the k group
            reverseList(currentNode);

            if(head == currentNode) {
                // this is the first group
                head = kthNode;
            } else {
                // make previous node points to next
                previousNode.next = kthNode;
            }

            // store the kth node as previous it will help at
            // the next step to make the connection with the other kth group
            previousNode = currentNode;

            // update the temp to point starting of the new k group
            currentNode = nextNodeOfKthNode;
        }

        return head;
    }
}
