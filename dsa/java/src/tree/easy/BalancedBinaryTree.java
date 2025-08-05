package tree.easy;

import tree.representation.BinaryTreeMain;
import tree.representation.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 *
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 */
public class BalancedBinaryTree {
    public int height(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;

        // check if left and right subtrees are balanced, if not balanced, return -1
        int leftDepth = height(root.left);
        int rightDepth = height(root.right);

        // Tree is not balanced
        if(leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1)
            return -1;

        // When the tree is balanced, return the height of the tree
        return 1 + Math.max(leftDepth, rightDepth);
    }
    public boolean isBalanced(TreeNode root) {
        // If the height of the tree is -1, it means the tree is not balanced
        // Otherwise, it is balanced
        return height(root) != -1;
    }

    public static void main(String[] args) {
        BalancedBinaryTree obj = new BalancedBinaryTree();

        boolean isBalanced = obj.isBalanced(BinaryTreeMain.buildTree());
        System.out.println("Is the binary tree balanced? " + isBalanced);
    }
}
