package bst.hard;

import bst.representation.TreeNode;

/**
 * You are given the root of a binary search tree (BST), where the values of exactly
 * two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
 *
 * Input: root = [1,3,null,null,2]
 * Output: [3,1,null,null,2]
 * Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
 */
class RecoverBinarySearchTree {
    private TreeNode previousNode;
    private TreeNode firstWrongNode, secondWrongNode, middleNode;

    // Swap values of two tree nodes
    public void swap(TreeNode nodeA, TreeNode nodeB) {
        int temp = nodeA.val;
        nodeA.val = nodeB.val;
        nodeB.val = temp;
    }

    // Inorder traversal to detect misplaced nodes in the BST
    public void inorderTraverse(TreeNode currentNode) {
        if(currentNode == null) {
            return;
        }

        // Traverse left subtree
        inorderTraverse(currentNode.left);

        // Detect a violation of the BST property
        if(previousNode != null && currentNode.val < previousNode.val) {
            // First violation
            if(firstWrongNode == null) {
                firstWrongNode = previousNode;
                middleNode = currentNode;
            } else {
                // Second violation
                secondWrongNode = currentNode;
            }
        }

        // Update the previous node
        previousNode = currentNode;

        // Traverse right subtree
        inorderTraverse(currentNode.right);
    }

    // Main function to recover the tree
    public void recoverTree(TreeNode root) {
        // Initialize pointers
        firstWrongNode = middleNode = secondWrongNode = null;
        previousNode = new TreeNode(Integer.MIN_VALUE);  // Sentinel node for comparison

        // Perform inorder traversal to find the wrong nodes
        inorderTraverse(root);

        // Fix the swapped nodes
        if(firstWrongNode != null && secondWrongNode != null) {
            swap(firstWrongNode, secondWrongNode);
        } else if (firstWrongNode != null && middleNode != null) {
            swap(firstWrongNode, middleNode);
        }
    }
}
