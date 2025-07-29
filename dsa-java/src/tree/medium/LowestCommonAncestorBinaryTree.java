package tree.medium;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
 * between two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 */

import tree.representation.TreeNode;

/**
 * // Brute force Approach
 * class Solution {
 *     public boolean getPath(TreeNode root, TreeNode dest, List<TreeNode> path) {
 *         if(root == null) return false;
 *         path.add(root);
 *
 *         if(root == dest) return true;
 *
 *         if(getPath(root.left, dest, path) || getPath(root.right, dest, path))
 *             return true;
 *
 *         path.remove(path.size()-1);
 *         return false;
 *     }
 *     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
 *         if(root == null) return root;
 *
 *         // path for p & q node from root
 *         List<TreeNode> p1 = new ArrayList<>();
 *         List<TreeNode> q1 = new ArrayList<>();
 *
 *         getPath(root, p, p1);
 *         getPath(root, q, q1);
 *
 *         int i = 0;
 *         while(i < p1.size() && i < q1.size() && p1.get(i)==q1.get(i)) {
 *             i ++;
 *         }
 *
 *         return p1.get(i-1);
 *     }
 * }
 */
public class LowestCommonAncestorBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        // Recur for left and right subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are not null, then root is the LCA
        // If one of them is null, then return the other one
        if(left == null) return right;
        else if (right == null) return left;
        else return root;
    }
}
