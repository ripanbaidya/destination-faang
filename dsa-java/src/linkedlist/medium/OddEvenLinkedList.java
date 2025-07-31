package linkedlist.medium;

import linkedlist.representation.singly.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given the head of a singly linked list, group all the nodes with odd indices together followed
 * by the nodes with even indices, and return the reordered list.
 * - The first node is considered odd, and the second node is even, and so on.
 * - Note that the relative order inside both the even and odd groups should remain as it was in the input.
 * - You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 *
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 */

/**
 * // Brute force solution
 * class Solution {
 *     public ListNode oddEvenList(ListNode head) {
 *         // list to store odd and even values
 *         List<Integer> odd = new ArrayList<>();
 *         List<Integer> even = new ArrayList<>();
 *
 *         ListNode currNode = head;
 *         int index = 1;
 *
 *         while(currNode != null) {
 *             if (index % 2 == 0) even.add(currNode.val);
 *             else odd.add(currNode.val);
 *
 *             index += 1;
 *             currNode = currNode.next;
 *         }
 *
 *         // reset the currNode
 *         currNode = head;
 *
 *         // override the value, odd followed by even
 *         while (currNode != null) {
 *             for (int i = 0; i < odd.size(); i ++) {
 *                 currNode.val = odd.get(i);
 *                 currNode = currNode.next;
 *             }
 *
 *             for (int i = 0; i < even.size(); i ++) {
 *                 currNode.val = even.get(i);
 *                 currNode = currNode.next;
 *             }
 *         }
 *
 *         return head;
 *     }
 * }
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        // keep track of odd and even
        ListNode odd = head;
        ListNode even = head.next, evenHead = even;

        // iterate in the list, odd followed by even
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }
}
