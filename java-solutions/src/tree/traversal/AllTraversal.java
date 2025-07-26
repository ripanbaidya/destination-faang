package tree.traversal;

import tree.representation.BinaryTreeMain;
import tree.representation.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, the task is to print all the nodes of the binary tree in Pre-order, Post-order,
 * and In-order iteratively using only one stack traversal.
 */
public class AllTraversal {
    // helper class to represent a node with its status
    static class Pair {
        Node node;
        int status; // status code, 1, 2, 3

        public Pair(Node node, int status) {
            this.node = node;
            this.status = status;
        }
    }

    static void allTraversals(Node root) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        while (!st.isEmpty()) {
            // Use peek to get the current node without removing it from the stack
            Pair currNode = st.peek();

            if (currNode.status == 1) {
                // pre-order traversal
                pre.add(currNode.node.data);
                currNode.status++;

                // Push left child first to ensure it is processed before the right child
                if (currNode.node.left != null) st.push(new Pair(currNode.node.left, 1));
            }
            else if (currNode.status == 2) {
                // in-order traversal
                in.add(currNode.node.data);
                currNode.status++;

                // Push right child to ensure it is processed after the current node
                if (currNode.node.right != null) st.push(new Pair(currNode.node.right, 1));
            }
            else {
                // post-order traversal
                post.add(currNode.node.data);

                // remove node after postorder is done
                st.pop();
            }
        }

        System.out.println("Preorder: " + pre);
        System.out.println("Inorder: " + in);
        System.out.println("Postorder: " + post);
    }

    public static void main(String[] args) {
        AllTraversal obj = new AllTraversal();

        obj.allTraversals(BinaryTreeMain.buildBinaryTree());
    }
}
