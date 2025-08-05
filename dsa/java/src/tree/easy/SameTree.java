package tree.easy;

import tree.representation.BinaryTreeMain;
import tree.representation.TreeNode;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true; // Both trees are empty, hence they are the same
        if(p == null || q == null) return false; // One tree is empty and the other is not, hence they are not the same

        // values of the current nodes must be equal for the trees to be the same
        if(p.val != q.val) return false;

        // Recursively check the left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        SameTree obj = new SameTree();

        boolean isSame = obj.isSameTree(BinaryTreeMain.buildTree(), BinaryTreeMain.buildTree());
        System.out.println("Are the two trees same? " + isSame);
    }
}
