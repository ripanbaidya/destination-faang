package tree.traversal;

import tree.representation.BinaryTreeMain;
import tree.representation.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 */
public class InorderTraversalRecursive {
    public void dfs(TreeNode root, List<Integer> inorder) {
        if(root == null) return;

        dfs(root.left, inorder);
        inorder.add(root.val);
        dfs(root.right, inorder);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    public static void main(String[] args) {
        InorderTraversalRecursive obj = new InorderTraversalRecursive();
        List<Integer> inorder = obj.inorderTraversal(BinaryTreeMain.buildTree());

        System.out.println(inorder);
    }
}
