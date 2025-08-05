package tree.medium;

import tree.representation.BinaryTreeMain;
import tree.representation.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, imagine yourself standing on the left side of it, return the values of
 * the nodes you can see ordered from top to bottom.
 *
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,2,5]
 */
public class LeftViewOfBinaryTree {
    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int len = q.size();

            for(int i = 0; i < len; i ++) {
                TreeNode currNode = q.poll();

                // Whoever is the first node in the level, that is the leftmost node
                if(i == 0) result.add(currNode.val);

                // Add left and right children to the queue
                if(currNode.left != null) q.add(currNode.left);
                if(currNode.right != null) q.add(currNode.right);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LeftViewOfBinaryTree obj = new LeftViewOfBinaryTree();

        List<Integer> leftView = obj.leftSideView(BinaryTreeMain.buildTree());
        System.out.println("Left View of Binary Tree: " + leftView);
    }
}
