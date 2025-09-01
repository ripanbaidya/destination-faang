package bst.medium;

import bst.representation.TreeNode;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value
 * (1-indexed) of all the values of the nodes in the tree.
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 */
public class KthSmallestElementInBST {
    // Here, we have used Morris Traversal to find the kth smallest element in a BST.
    public int kthSmallest(TreeNode root, int k) {
        int visitedNodes = 0; // Tracks the number of nodes visited in inorder traversal
        TreeNode currentNode = root;

        while (currentNode != null) {
            if (currentNode.left == null) {
                // Visit the node since there is no left subtree
                visitedNodes++;
                if (visitedNodes == k) {
                    return currentNode.val;
                }
                currentNode = currentNode.right;
            } else {
                // Find the inorder predecessor of currentNode
                TreeNode predecessor = currentNode.left;
                while (predecessor.right != null && predecessor.right != currentNode) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    // Establish a temporary link to return after left subtree
                    predecessor.right = currentNode;
                    currentNode = currentNode.left;
                } else {
                    // Remove the temporary link and visit the node
                    predecessor.right = null;
                    visitedNodes++;
                    if (visitedNodes == k) {
                        return currentNode.val;
                    }
                    currentNode = currentNode.right;
                }
            }
        }

        // If kth smallest is not found
        return -1;
    }
}
