package tree.easy;

import tree.representation.BinaryTreeMain;
import tree.representation.TreeNode;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 *
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 */
public class SymmetricTree {
    public boolean isSame(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        if(p.val != q.val) return false;

        return isSame(p.left, q.right) && isSame(p.right, q.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root.left == null && root.right == null) return true;

        return isSame(root.left, root.right);
    }

    public static void main(String[] args) {
        SymmetricTree obj = new SymmetricTree();

        boolean isSymmetric = obj.isSymmetric(BinaryTreeMain.buildTree());
        System.out.println("Is the tree symmetric? " + isSymmetric);
    }
}
