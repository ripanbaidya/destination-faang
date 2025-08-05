package tree.easy;

import tree.representation.BinaryTreeMain;
import tree.representation.TreeNode;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 */
public class DiameterOfBinaryTree {
    public int height(TreeNode root, int[] maxi) {
        if(root == null) return 0;

        int leftDepth = height(root.left, maxi);
        int rightDepth = height(root.right, maxi);

        // Update the maximum diameter found so far
        maxi[0] = Math.max(maxi[0], (leftDepth + rightDepth));

        return 1 + Math.max(leftDepth, rightDepth);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxi = new int[1];
        height(root, maxi);
        return maxi[0];
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree obj = new DiameterOfBinaryTree();

        int diameter = obj.diameterOfBinaryTree(BinaryTreeMain.buildTree());
        System.out.println("Diameter of the binary tree is: " + diameter);
    }
}
