package bst.hard;

import bst.representation.Node;

/**
 * You're given a binary tree. Your task is to find the size of the largest subtree within this
 * binary tree that also satisfies the properties of a Binary Search Tree (BST). The size of a
 * subtree is defined as the number of nodes it contains.
 * Note: A subtree of the binary tree is considered a BST if for every node in that subtree,
 * the left child is less than the node, and the right child is greater than the node, without
 * any duplicate values in the subtree.
 *
 * Input: root = [5, 2, 4, 1, 3]
 * Output: 3
 * Explanation:The following sub-tree is a BST of size 3
 */
class NodeValue {
    int maxValue;
    int minValue;
    int size;

    public NodeValue(int minValue, int maxValue, int size) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.size = size;
    }
}
public class LargestBST {
    // Helper function to find the largest BST in a binary tree
    static NodeValue largestBstHelper(Node root) {
        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue left = largestBstHelper(root.left);
        NodeValue right = largestBstHelper(root.right);

        if (left.maxValue < root.data && root.data < right.minValue) {
            // It's a BST
            int minValue = Math.min(root.data, left.minValue);
            int maxValue = Math.max(root.data, right.maxValue);
            int totalSize = left.size + right.size + 1;

            return new NodeValue(minValue, maxValue, totalSize);
        }

        // Not a BST, return size of largest BST so far
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
    }

    static int largestBst(Node root) {
        return largestBstHelper(root).size;
    }
}
