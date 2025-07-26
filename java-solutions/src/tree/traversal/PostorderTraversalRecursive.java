package tree.traversal;

import tree.representation.BinaryTreeMain;
import tree.representation.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 *
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
 */
public class PostorderTraversalRecursive {
    public void dfs(TreeNode root, List<Integer> postorder) {
        if(root == null) return;

        dfs(root.left, postorder);
        dfs(root.right, postorder);
        postorder.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    public static void main(String[] args) {
        PostorderTraversalRecursive obj = new PostorderTraversalRecursive();
        List<Integer> postorder = obj.postorderTraversal(BinaryTreeMain.buildTree());

        System.out.println(postorder);
    }
}
