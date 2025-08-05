package bst.medium;

import bst.representation.TreeNode;

/**
 * Given an array of integers preorder, which represents the preorder traversal of a BST
 * (i.e., binary search tree), construct the tree and return its root.
 * It is guaranteed that there is always possible to find a binary search tree with the given
 * requirements for the given test cases.
 * A binary search tree is a binary tree where for every node, any descendant of Node.left has
 * a value strictly less than Node.val, and any descendant of Node.right has a value strictly
 * greater than Node.val.
 * A preorder traversal of a binary tree displays the value of the node first, then traverses
 * Node.left, then traverses Node.right.
 *
 * Input: preorder = [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 */
public class ConstructBSTFromPreorderTraversal {
    public TreeNode insertNode(TreeNode root, int key) {
        TreeNode newNode = new TreeNode(key); // create a new node with value key
        if(root == null) return newNode; // base case, if the tree is empty, return the new node as root

        // Create a temporary pointer to traverse the tree
        TreeNode temp = root;

        while (true) {
            if (temp.val > key) {
                if (temp.left == null) {
                    temp.left = newNode;
                    break;
                } else {
                    temp = temp.left;
                }
            }
            else {
                if (temp.right == null) {
                    temp.right = newNode;
                    break;
                } else {
                    temp = temp.right;
                }
            }
        }
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]); // Create the root node with the first element of the preorder array

        // If the preorder array has only one element, return the root
        if(preorder.length == 1) return root;

        // Insert the rest of the elements in the preorder array into the BST
        TreeNode temp = root;
        for(int i = 1; i < preorder.length; i ++) {
            temp = insertNode(temp, preorder[i]);
        }

        // Return the root of the constructed BST
        return root;
    }
}
