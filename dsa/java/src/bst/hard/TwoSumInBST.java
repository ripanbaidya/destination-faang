package bst.hard;

import bst.representation.TreeNode;

import java.util.Stack;

/**
 * Given the root of a binary search tree and an integer k, return true if there exist two
 * elements in the BST such that their sum is equal to k, or false otherwise.
 *
 * Input: root = [5,3,6,2,4,null,7], k = 9
 * Output: true
 */
class BSTIterator {
    private boolean isForward; // true for ascending, false for descending
    private Stack<TreeNode> st;

    public BSTIterator(TreeNode root, boolean isForward) {
        this.isForward = isForward;
        this.st = new Stack<>();
        pushAll(root);
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public int next() {
        TreeNode node = st.pop();
        if (isForward) {
            pushAll(node.right);
        } else {
            pushAll(node.left);
        }
        return node.val;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            st.push(node);
            node = isForward ? node.left : node.right;
        }
    }
}
public class TwoSumInBST {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        BSTIterator left = new BSTIterator(root, true);   // inorder
        BSTIterator right = new BSTIterator(root, false); // reverse inorder

        int i = left.next();
        int j = right.next();

        while (i < j) {
            int sum = i + j;

            if (sum == k) return true;
            else if (sum < k) {
                if (left.hasNext()) i = left.next();
                else return false;
            } else {
                if (right.hasNext()) j = right.next();
                else return false;
            }
        }

        return false;
    }
}
