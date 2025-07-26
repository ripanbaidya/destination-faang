package tree.traversal;

import tree.representation.BinaryTreeMain;
import tree.representation.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 *
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 */
public class PreorderTraversalRecursive {
    public void dfs(TreeNode root, List<Integer> preorder) {
        if(root == null) return;

        preorder.add(root.val);
        dfs(root.left, preorder);
        dfs(root.right, preorder);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    public static void main(String[] args) {
        PreorderTraversalRecursive obj = new PreorderTraversalRecursive();
        List<Integer> preorder = obj.preorderTraversal(BinaryTreeMain.buildTree());

        System.out.println(preorder);
    }
}
