package bst.medium;

import bst.representation.TreeNode;

/**
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree.
 * Return the root node of the BST after the insertion. It is guaranteed that the new value does
 * not exist in the original BST.
 * Notice that there may exist multiple valid ways for the insertion, as long as the tree remains
 * a BST after insertion. You can return any of them.
 *
 * Input: root = [4,2,7,1,3], val = 5
 * Output: [4,2,7,1,3,5], there might be multiple valid ways for the insertion,
 */
public class InsertNodeInBST {
    public TreeNode insertIntoBST(TreeNode root, int x) {
        TreeNode newNode = new TreeNode(x); // create a new node with value x
        if (root == null)  return newNode; // base case

        // create a temporary pointer to traverse the tree
        TreeNode temp = root;

        while (true) {
            if (temp.val > x) {
                if (temp.left != null) {
                    temp = temp.left;
                } else {
                    temp.left = newNode;
                    break;
                }
            } else {
                if (temp.right != null) {
                    temp = temp.right;
                } else {
                    temp.right = newNode;
                    break;
                }
            }
        }

        return root;
    }
}
