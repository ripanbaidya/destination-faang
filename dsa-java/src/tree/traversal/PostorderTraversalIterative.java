package tree.traversal;

import tree.representation.BinaryTreeMain;
import tree.representation.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 *
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
 */
public class PostorderTraversalIterative {
    // Here, we use two stacks to achieve the postorder traversal iteratively.
    public List<Integer> postorderTraversal(TreeNode node) {
        ArrayList<Integer> postorder = new ArrayList<Integer>();
        if(node == null) return postorder;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(node);

        while(!s1.isEmpty()) {
            node = s1.pop();

            s2.push(node);

            // Push left and right children to the first stack
            // so that they can be processed in the correct order
            if(node.left != null) s1.push(node.left);
            if(node.right != null) s1.push(node.right);
        }

        // Pop all elements from the second stack to get postorder traversal
        while(!s2.isEmpty()) {
            postorder.add(s2.pop().val);
        }

        return postorder;
    }

    public static void main(String[] args) {
        PostorderTraversalIterative obj = new PostorderTraversalIterative();
        List<Integer> postorder = obj.postorderTraversal(BinaryTreeMain.buildTree());

        System.out.println(postorder);
    }
}
