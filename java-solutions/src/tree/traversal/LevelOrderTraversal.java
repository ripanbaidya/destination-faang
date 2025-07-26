package tree.traversal;

import tree.representation.BinaryTreeMain;
import tree.representation.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if(root == null) return levelOrder; // if root is null, return empty list

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int len = q.size();

            // create a temporary list to hold the current level's values
            List<Integer> temp = new ArrayList<>();

            for(int i = 0; i < len; i ++) {
                TreeNode currNode = q.poll();
                temp.add(currNode.val);

                // add the left and right children to the queue if they are not null
                if(currNode.left != null) q.add(currNode.left);
                if(currNode.right != null) q.add(currNode.right);
            }
            levelOrder.add(temp);
        }

        return levelOrder;
    }

    public static void main(String[] args) {
        LevelOrderTraversal obj = new LevelOrderTraversal();
        List<List<Integer>> result = obj.levelOrder(BinaryTreeMain.buildTree());

        for(List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
