package bst.medium;

import bst.representation.TreeNode;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 *
 * 1. Search for a node to remove.
 * 2. If the node is found, delete the node.
 *
 * Input: root = [5,3,6,2,4,null,7], key = 3
 * Output: [5,4,6,2,null,null,7]
 * Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
 * One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
 * Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
 */
public class DeleteNodeInBST {
    // This function finds the rightmost node in the left subtree
    // which will be the largest node in that subtree.
    private TreeNode findRight(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }

        return root;
    }
    // This function handles the deletion of a node
    private TreeNode helper(TreeNode root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            TreeNode rightChild = root.right;
            TreeNode leftExtremeRight = findRight(root.left);
            leftExtremeRight.right = rightChild;
            return root.left;
        }
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null; // base case
        if(root.val == key) return helper(root); // if the root is the node to be deleted

        // create a temporary pointer to traverse the tree
        TreeNode temp = root;

        while (temp != null) {
            if (temp.val > key) {
                if (temp.left != null && temp.left.val == key) {
                    temp.left = helper(temp.left);
                    break;
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right != null && temp.right.val == key) {
                    temp.right = helper(temp.right);
                    break;
                } else {
                    temp = temp.right;
                }
            }
        }

        return root;
    }
}
