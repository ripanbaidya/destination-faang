package tree.medium;

import tree.representation.BinaryTreeMain;
import tree.representation.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a binary tree with ‘N’ number of nodes and a node ‘X’. Your task is to print the path
 * from the root node to the given node ‘X’.
 * A binary tree is a hierarchical data structure in which each node has at most two children.
 */
public class RootToNodePath {
    public boolean findPath(TreeNode root, int x, ArrayList<Integer> result) {
        if(root == null) return false;

        // Add the current node's value to the path
        result.add(root.val);

        // If the current node is the target node, or any of its children contain the target node,
        // return true to indicate that the path has been found.
        if(root.val == x || findPath(root.left, x, result) || findPath(root.right, x, result))
            return true;

        // If the target node is not found in the current path, remove the current node's value
        // from the path and return false.
        result.removeLast();
        return false;
    }
    public ArrayList<Integer> pathInATree(TreeNode root, int x) {
        ArrayList<Integer> result = new ArrayList<>();
        findPath(root, x, result);
        return result;
    }

    public static void main(String[] args) {
        RootToNodePath obj = new RootToNodePath();

        List<Integer> result = obj.pathInATree(BinaryTreeMain.buildTree(), 5);
        System.out.println("Path from root to node 5: " + result);
    }
}
