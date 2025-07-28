package tree.medium;

import tree.representation.Node;

/**
 * Given a binary tree having n nodes. Check whether all of its nodes have a value equal to the sum
 * of their child nodes. Return 1 if all the nodes in the tree satisfy the given properties, else it
 * returns 0. For every node, the data value must be equal to the sum of the data values in the left
 * and right children. Consider the data value 0 for a NULL child. Also, leaves are considered to
 * follow the property.
 *
 * Input: Binary tree
 *        35
 *       /  \
 *      20   15
 *     / \   / \
 *    15  5 10  5
 *
 * Output: 1
 * Explanation: Here, every node is sum of its left and right child.
 */
public class ChildrenSumInBinaryTree {
    public boolean isSumPropertyHelper(Node root) {
        if (root == null || (root.left == null && root.right == null))
            return true;

        int leftVal = (root.left != null) ? root.left.data : 0;
        int rightVal = (root.right != null) ? root.right.data : 0;


        if ((leftVal + rightVal) == root.data && isSumPropertyHelper(root.left) && isSumPropertyHelper(root.right))
            return true;

        return false;
    }
    public int isSumProperty(Node root) {
        return isSumPropertyHelper(root) ? 1 : 0;
    }
}
