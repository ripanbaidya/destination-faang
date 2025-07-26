package tree.traversal;

import tree.representation.BinaryTreeMain;
import tree.representation.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 */
public class InorderTraversalIterative {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        if(root == null) return inorder;

        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;

        while(curr != null || !st.isEmpty()) {
            // Traverse to the leftmost node
            while(curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            // Process the node
            curr = st.pop();
            inorder.add(curr.val);
            curr = curr.right;
        }

        return inorder;
    }

    public static void main(String[] args) {
        InorderTraversalIterative obj = new InorderTraversalIterative();
        List<Integer> inorder = obj.inorderTraversal(BinaryTreeMain.buildTree());

        System.out.println(inorder);
    }
}
