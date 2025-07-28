package bst.easy;

import bst.representation.BinarySearchTreeMain;
import bst.representation.TreeNode;

/**
 * You are given the root of a binary search tree (BST) and an integer val.
 *
 * Find the node in the BST that the node's value equals val and return the
 * subtree rooted with that node. If such a node does not exist, return null.
 *
 * Input: root = [4,2,7,1,3], val = 2
 * Output: [2,1,3]
 */
public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int key) {
        while (root != null) {
            if (root.val == key) {
                return root;
            } else if (root.val > key){
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        SearchInABinarySearchTree obj = new SearchInABinarySearchTree();

        TreeNode result = obj.searchBST(BinarySearchTreeMain.buildBalancedBST(), 2);
        System.out.println(result);
    }
}
