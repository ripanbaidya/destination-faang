package tree.medium;

import tree.representation.BinaryTreeMain;
import tree.representation.Node;

import java.util.*;

/**
 * Given a binary tree, return an array where elements represent the bottom view of the binary tree from left to right.
 * Note: If there are multiple bottom-most nodes for a horizontal distance from the root, then the later one in the
 * level order traversal is considered. For example, in the below diagram, 7 and 34 both are the bottommost nodes
 * at a horizontal distance of 0 from the root, here 34 will be considered.
 *
 * Input: root[] = [1, 3, 2]
 * Output: [3 1 2]
 * Explanation: First case represents a tree with 3 nodes and 2 edges where root is 1, left child of 1 is 3 and right child of 1 is 2.
 */
public class BottomViewOfBinaryTree {
    static class Tuple {
        Node node;
        int row, col;

        public Tuple(Node node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public ArrayList<Integer> bottomView(Node root) {
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

            // Whatever the last value at this column is, it will be the bottom view
            mp.put(currCol, currNode.data);

            // Add left and right children to the queue with updated row and column values
            if(currNode.left != null) q.offer(new Tuple(currNode.left, currRow+1, currCol-1));
            if(currNode.right != null) q.offer(new Tuple(currNode.right, currRow+1, currCol+1));
        }

        result.addAll(mp.values());

        return result;
    }

    public static void main(String[] args) {
        BottomViewOfBinaryTree obj = new BottomViewOfBinaryTree();

        List<Integer> bottomView = obj.bottomView(BinaryTreeMain.buildBinaryTree());
        System.out.println("Bottom view of the binary tree: " + bottomView);
    }
}
