package tree.hard;

import tree.representation.BinaryTreeMain;
import tree.representation.TreeNode;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an
 * edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * The path sum of a path is the sum of the node's values in the path.
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 *
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 */
public class MaximumPathSum {
    public int maxPathSumHelper(TreeNode node, int[] maxi) {
        if(node == null) return 0;

        // Calculate the maximum path sum for the left and right subtrees
        // If the path sum is negative, we consider it as 0 (we don't take negative paths)
        int left = Math.max(0, maxPathSumHelper(node.left, maxi));
        int right = Math.max(0, maxPathSumHelper(node.right, maxi));

        // Update the maximum path sum found so far
        maxi[0] = Math.max(maxi[0], (node.val + left + right));

        // Return the maximum path sum including the current node
        // We can only take one side (left or right) to continue the path
        return node.val + Math.max(left, right);
    }
    public int maxPathSum(TreeNode root) {
        int[] maxiSum = new int[1];
        maxiSum[0] = Integer.MIN_VALUE;

        maxPathSumHelper(root, maxiSum);
        return maxiSum[0];
    }

    public static void main(String[] args) {
        MaximumPathSum obj = new MaximumPathSum();

        int maximumPathSum = obj.maxPathSum(BinaryTreeMain.buildTree());
        System.out.println("Maximum Path Sum: " + maximumPathSum);
    }
}
