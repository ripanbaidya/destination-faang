package tree.medium;

import tree.representation.TreeNode;

import java.util.HashMap;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a
 * binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length != preorder.length)
            return null;

        // Map to store the index of each value in inorder array
        HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeRecursive(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1, inorderIndexMap);
    }

    public TreeNode buildTreeRecursive(int[] inorder, int[] preorder, int inorderStart, int inorderEnd, int preorderStart, int preorderEnd,
                                       HashMap<Integer, Integer> inorderIndexMap) {

        if (inorderStart > inorderEnd || preorderStart > preorderEnd) return null;

        int rootValue = preorder[preorderStart];
        TreeNode root = new TreeNode(rootValue);

        int rootIndexInInorder = inorderIndexMap.get(rootValue);
        int leftSubtreeSize = rootIndexInInorder - inorderStart;

        // Recursively construct the left and right subtrees
        root.left = buildTreeRecursive(inorder, preorder, inorderStart, rootIndexInInorder - 1,
                preorderStart + 1, preorderStart + leftSubtreeSize, inorderIndexMap);
        root.right = buildTreeRecursive(inorder, preorder, rootIndexInInorder + 1, inorderEnd,
                preorderStart + leftSubtreeSize + 1, preorderEnd, inorderIndexMap);

        return root;
    }
}