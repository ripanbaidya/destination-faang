package tree.easy;

import tree.representation.BinaryTreeMain;
import tree.representation.TreeNode;

/**
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the
 * root node down to the farthest leaf node.
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;

        // Recursively find the maximum depth of the left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree obj = new MaximumDepthOfBinaryTree();

        int maximumDepth = obj.maxDepth(BinaryTreeMain.buildTree());
        System.out.println("Maximum Depth of Binary Tree: " + maximumDepth);
    }
}
