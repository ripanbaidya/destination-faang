package tree.traversal;

import tree.representation.BinaryTreeMain;
import tree.representation.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order:
 *
 * a. Left Boundary: This includes all the nodes on the path from the root to the leftmost leaf node.
 * You must prefer the left child over the right child when traversing. Do not include leaf nodes in this section.
 * b. Leaf Nodes: All leaf nodes, in left-to-right order, that are not part of the left or right boundary.
 * c. Reverse Right Boundary: This includes all the nodes on the path from the rightmost leaf node to the root,
 * traversed in reverse order. You must prefer the right child over the left child when traversing. Do not include the root in this section if it was already included in the left boundary.
 *
 * Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary.
 *
 * Input: root[] = [1, 2, 3, 4, 5, 6, 7, N, N, 8, 9, N, N, N, N]
 * Output: [1, 2, 4, 8, 9, 6, 7, 3]
 */
public class BoundaryTraversal {
    // check if the node is a leaf node
    public boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }

    // add left boundary nodes
    public void addLeftNodes(Node node, ArrayList<Integer> li) {
        while(node != null) {
            if(!isLeaf(node))
                li.add(node.data);

            node = (node.left != null) ? node.left : node.right;
        }
    }

    // add right boundary nodes in reverse order
    // we use a stack to reverse the order of right boundary nodes
    public void addRightNodes(Node node, ArrayList<Integer> li) {
        Stack<Integer> st = new Stack<>();

        while(node != null) {
            if(!isLeaf(node))
                st.push(node.data);

            node = (node.right != null) ? node.right : node.left;
        }

        // restore element from stack to list
        while(!st.isEmpty()) {
            li.add(st.pop());
        }
    }

    // add leaf nodes
    public void addLeafNodes(Node node, ArrayList<Integer> li) {
        if(node == null) return;

        if(isLeaf(node)){
            li.add(node.data);
            return;
        }

        addLeafNodes(node.left, li);
        addLeafNodes(node.right, li);
    }
    public ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> result = new ArrayList<>();

        if(node == null) return result;
        if(!isLeaf(node)) result.add(node.data);

        addLeftNodes(node.left, result);
        addLeafNodes(node, result);
        addRightNodes(node.right, result);

        return result;
    }

    public static void main(String[] args) {
        BoundaryTraversal obj = new BoundaryTraversal();

        List<Integer> result = obj.boundaryTraversal(BinaryTreeMain.buildBinaryTree());
        System.out.println("Boundary Traversal: " + result);
    }
}
