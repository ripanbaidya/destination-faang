package bst.medium;

import bst.representation.Node;

/**
 * Given a BST and a number X, find Ceil of X.
 * Note: Ceil(X) is a number that is either equal to X or is immediately greater than X.
 * If Ceil could not be found, return -1.
 *
 * Input: root = [5, 1, 7, N, 2, N, N, N, 3], X = 3
 * Output: 3
 * Explanation: We find 3 in BST, so ceil of 3 is 3.
 */
public class CeilInBST {
    int findCeil(Node root, int key) {
        int ceil = -1;

        while (root != null) {
            if (root.data == key) {
                return root.data;
            } else if (root.data > key) {
                ceil = root.data;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return ceil;
    }
}
