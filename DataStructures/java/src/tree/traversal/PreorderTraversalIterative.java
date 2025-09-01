package tree.traversal;

import tree.representation.BinaryTreeMain;
import tree.representation.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 *
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 */
public class PreorderTraversalIterative {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        if(root == null) return preorder;

        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);

        while(!stk.isEmpty()) {
            TreeNode currNode = stk.pop();
            preorder.add(currNode.val);

            // Push right child first so that left child is processed first in the next iteration.
            if(currNode.right != null) stk.push(currNode.right);
            if(currNode.left != null) stk.push(currNode.left);
        }

        return preorder;
    }

    public static void main(String[] args) {
        PreorderTraversalIterative obj = new PreorderTraversalIterative();
        List<Integer> preorder = obj.preorderTraversal(BinaryTreeMain.buildTree());

        System.out.println(preorder);
    }
}
