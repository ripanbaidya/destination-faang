package tree.medium;

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
public class MorrisPreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                preorder.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode temp = curr.left;

                // go extreme right of left subtree
                while (temp.right != null && temp.right != curr) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = curr;
                    preorder.add(curr.val);
                    curr = curr.left;
                } else {
                    temp.right = null;
                    curr = curr.right;
                }
            }
        }
        return preorder;
    }

    public static void main(String[] args) {
        MorrisPreorderTraversal obj = new MorrisPreorderTraversal();
        List<Integer> preorder = obj.preorderTraversal(BinaryTreeMain.buildTree());

        System.out.println(preorder);
    }
}
