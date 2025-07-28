package tree.easy;

import tree.representation.TreeNode;

/**
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 * According to Wikipedia, every level, except possibly the last, is completely filled in
 * a complete binary tree, and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 * Design an algorithm that runs in less than O(n) time complexity.
 *
 * Input: root = [1,2,3,4,5,6]
 * Output: 6
 */
public class CountNodesInCompleteBinaryTree {
    public int findLeftHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }

    public int findRightHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.right;
        }
        return height;
    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int left = findLeftHeight(root);
        int righeight = findRightHeight(root);

        if (left == righeight)
            return (1 << left) - 1; // 2^left - 1

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
