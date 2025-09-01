package tree.traversal;

import tree.representation.BinaryTreeMain;
import tree.representation.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 */
public class ZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        // flag, this will decide from which side element will be added, initially left to right
        boolean flag = true;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int len = q.size();

            // use LinkedList to add element from both sides
            // if flag is true, add from left side, else add from right side, this will give us the zigzag effect
            List<Integer> temp = new LinkedList<>();

            for(int i = 0; i < len; i ++) {
                TreeNode currNode = q.poll();

                // add left and right children if they are not null
                if(currNode.left != null) q.add(currNode.left);
                if(currNode.right != null) q.add(currNode.right);

                if(flag == true) temp.addLast(currNode.val);
                else temp.addFirst(currNode.val);
            }
            result.add(temp);
            flag = !flag; // toggle the flag for next level
        }

        return result;
    }

    public static void main(String[] args) {
        ZigZagLevelOrderTraversal obj = new ZigZagLevelOrderTraversal();
        List<List<Integer>> result = obj.zigzagLevelOrder(BinaryTreeMain.buildTree());

        for(List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
