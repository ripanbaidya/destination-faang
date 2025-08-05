package tree.medium;

import tree.representation.TreeNode;

import java.util.HashMap;

/**
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a
 * binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 *
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 */
public class ConstructBinaryTreeFromPostorderAndInorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length)
            return null;

        // Map to store the index of each value in inorder array
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < inorder.length; i ++) {
            mp.put(inorder[i], i);
        }

        return buildTreeHelper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, mp);
    }

    public TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd,
                                    HashMap<Integer, Integer> mp) {

        if(inStart > inEnd || postStart > postEnd)
            return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int inPos = mp.get(rootVal);
        int remaining = inPos - inStart;

        // Recursively construct the left and right subtrees
        root.left = buildTreeHelper(inorder, inStart, inPos-1, postorder, postStart, postStart+remaining-1, mp);
        root.right = buildTreeHelper(inorder, inPos+1, inEnd, postorder, postStart+remaining, postEnd-1, mp);

        return root;
    }
}