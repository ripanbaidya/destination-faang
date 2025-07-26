package tree.medium;

import tree.representation.BinaryTreeMain;
import tree.representation.Node;

import java.util.*;

/**
 * You are given a binary tree, and your task is to return its top view. The top view of a binary tree
 * is the set of nodes visible when the tree is viewed from the top.
 *
 * Note:
 * Return the nodes from the leftmost node to the rightmost node.
 * If two nodes are at the same position (horizontal distance) and are outside the shadow of the tree,
 * consider the leftmost node only.
 *
 * Input: root[] = [1, 2, 3]
 * Output: [2, 1, 3]
 */
public class TopViewOfBinaryTree {
    class Tuple {
        Node node;
        int row;
        int col;

        public Tuple(Node node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;

        TreeMap<Integer, Integer> mp = new TreeMap<>(); // {col, topValue}
        Queue<Tuple> q = new LinkedList<>(); // Tuple: {node, row, col}
        q.offer(new Tuple(root, 0, 0));

        while(!q.isEmpty()) {
            Tuple curr = q.poll();

            Node currNode = curr.node;
            int currRow = curr.row;
            int currCol = curr.col;

            // top view
            mp.putIfAbsent(currCol, currNode.data);

            // Push left and right children into the queue, when they exist
            if(currNode.left != null) q.offer(new Tuple(currNode.left, currRow+1, currCol-1));
            if(currNode.right != null) q.offer(new Tuple(currNode.right, currRow+1, currCol+1));
        }

        // Extracting values from the TreeMap to maintain order
        result.addAll(mp.values());

        return result;
    }

    public static void main(String[] args) {
        TopViewOfBinaryTree obj = new TopViewOfBinaryTree();

        List<Integer> topView = obj.topView(BinaryTreeMain.buildBinaryTree());
        System.out.println("Top view of the binary tree: " + topView);
    }
}
