package tree.hard;

import tree.representation.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it
 * can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed
 * later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can
 * be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 */
public class SerializeAndDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder data = new StringBuilder();

        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();

            if(curr == null) {
                data.append("n ");
                continue;
            }
            q.offer(curr.left);
            q.offer(curr.right);
            data.append(curr.val + " ");
        }
        return data.toString();
    }

    public TreeNode deserialize(String data) {
        if(data == "") return null;
        String[] values = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);

        for(int i = 1; i < values.length; i ++) {
            TreeNode parent = q.poll();
            if(!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if(!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}
