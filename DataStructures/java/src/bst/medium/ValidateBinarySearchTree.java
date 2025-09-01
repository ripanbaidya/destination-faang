package bst.medium;

import bst.representation.TreeNode;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * The left subtree of a node contains only nodes with keys strictly less than the node's key.
 * The right subtree of a node contains only nodes with keys strictly greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */

/**
 * // Brute force Approach:
 * class Solution {
 *     private void dfs(TreeNode root, List<Integer> li) {
 *         if(root == null) return;
 *
 *         dfs(root.left, li);
 *         li.add(root.val);
 *         dfs(root.right, li);
 *     }
 *     public boolean isValidBST(TreeNode root) {
 *         List<Integer> inorder = new ArrayList<>();
 *         dfs(root, inorder);
 *
 *         if(inorder.size() < 2) return true; // A single node or empty tree is a valid BST
 *
 *         // Check if the inorder traversal is sorted in strictly increasing order
 *         for(int i = 0; i < inorder.size()-1; i ++) {
 *             if(inorder.get(i) >= inorder.get(i+1)) {
 *                 return false;
 *             }
 *         }
 *
 *         return true;
 *     }
 * }
 */
public class ValidateBinarySearchTree {
    public boolean validateBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val <= minVal || root.val >= maxVal) return false;
        return validateBST(root.left, minVal, root.val)
                && validateBST(root.right, root.val, maxVal);
    }
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
