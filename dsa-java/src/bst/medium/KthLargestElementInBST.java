package bst.medium;

import bst.representation.Node;

/**
 * Given a Binary Search Tree. Your task is to complete the function which will return the
 * kth largest element without doing any modification in the Binary Search Tree.

 * Input:
 *       4
 *     /   \
 *    2     9
 * k = 2
 * Output: 4
 * Explanation: 2nd Largest element in BST is 4
 */
public class KthLargestElementInBST {
    // Here, we will use Reverse Morris Traversal to find the kth largest element in a BST.
    public int kthLargest(Node root, int k) {
        int count = 0; // This variable will keep track of the number of nodes visited in reverse inorder traversal
        Node curr = root;

        while (curr != null) {
            if (curr.right == null) {
                count ++;
                if (count == k) {
                    return curr.data;
                }
                curr = curr.left;
            } else {
                Node temp = curr.right;

                // Find the inorder predecessor of curr
                while (temp.left != null && temp.left != curr) {
                    temp = temp.left;
                }
                if (temp.left == null) {
                    temp.left = curr;
                    curr = curr.right;
                } else {
                    temp.left = null;
                    count ++;
                    if(count == k) {
                        return curr.data;
                    }
                    curr = curr.left;
                }
            }
        }

        return -1;
    }
}
