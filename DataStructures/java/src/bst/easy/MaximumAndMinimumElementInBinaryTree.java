package bst.easy;

import bst.representation.BinarySearchTreeMain;
import bst.representation.Node;

/**
 * Given a Binary Tree, find maximum and minimum elements in it.
 *
 * Input:
 *            6
 *         / \
 *        5   8
 *       /
 *      2
 * Output: 8 2
 * Explanation: The maximum and minimum element in this binary tree is 8 and 2 respectively.
 */
public class MaximumAndMinimumElementInBinaryTree {
    private void getMaxi(Node root, int[] maxi) {
        if (root == null) return;

        maxi[0] = Math.max(maxi[0], root.data);
        getMaxi(root.left, maxi);
        getMaxi(root.right, maxi);
    }

    private void getMini(Node root, int[] mini) {
        if(root == null) return;

        mini[0] = Math.min(mini[0], root.data);
        getMini(root.left, mini);
        getMini(root.right, mini);
    }

    public int findMax(Node root) {
        int[] maxi = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        getMaxi(root, maxi);
        return maxi[0];
    }

    public int findMin(Node root) {
        int[] mini = new int[1];
        mini[0] = Integer.MAX_VALUE;
        getMini(root, mini);
        return mini[0];
    }

    public static void main(String[] args) {
        MaximumAndMinimumElementInBinaryTree obj = new MaximumAndMinimumElementInBinaryTree();

        int maximum = obj.findMax(BinarySearchTreeMain.buildBST());
        int minimum = obj.findMin(BinarySearchTreeMain.buildBST());

        System.out.println("Maximum: " + maximum);
        System.out.println("Minimum: " + minimum);
    }
}
