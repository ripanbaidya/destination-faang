package bst.medium;

import bst.representation.TreeNode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p
 * and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant
 * of itself).”
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 */
public class LCAofBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        while (root != null) {
            int currVal = root.val;
            if (currVal > p.val && currVal > q.val) {
                root = root.left;
            } else if (currVal < p.val && currVal < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }

        return null;
    }
}
