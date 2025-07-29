package bst.medium;

import bst.representation.Node;

import java.util.ArrayList;

/**
 * You are given root node of the BST and an integer key. You need to find the in-order successor
 * and predecessor of the given key. If either predecessor or successor is not found, then set it to NULL.
 * Note:- In an inorder traversal the number just smaller than the target is the predecessor and the number
 * just greater than the target is the successor.
 *
 * Input: root[] = [8, 1, 9, N, 4, N, 10, 3, N, N, N], key = 8
 * Output: 4 9
 * Explanation: In the given BST the inorder predecessor of 8 is 4 and inorder successor of 8 is 9.
 */
public class PredecessorAndSuccessor {
    // method to find the predecessor of a given key in a BST
    public Node findPredecessor(Node root, int key) {
        Node pre = null;

        while (root != null) {
            if (root.data < key) {
                pre = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return pre;
    }
    // method to find the successor of a given key in a BST
    public Node findSuccessor(Node root, int key) {
        Node suc = null;

        while(root != null) {
            if(root.data > key) {
                suc = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return suc;
    }

    // main method to find both predecessor and successor of a given key in a BST
    public ArrayList<Node> findPredecessorSuc(Node root, int key) {
        // find the predecessor and successor of the given key
        Node predecessor = findPredecessor(root, key);
        Node successor = findSuccessor(root, key);

        // add the predecessor and successor to an ArrayList
        ArrayList<Node> result = new ArrayList<>();
        result.add(predecessor);
        result.add(successor);

        return result;
    }
}
