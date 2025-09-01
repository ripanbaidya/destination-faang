package tree.easy;

import tree.representation.BinaryTreeMain;
import tree.representation.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * A leaf is a node with no children.
 *
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 */
public class BinaryTreePaths {
    public boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public void getPaths(TreeNode root, List<String> paths, StringBuilder path) {
        if(root == null) return;

        int prevLength = path.length();
        path.append(root.val);

        // leaf node
        if(isLeaf(root)) {
            paths.add(path.toString());
        } else {
            path.append("->");
            getPaths(root.left, paths, path);
            getPaths(root.right, paths, path);
        }

        // backtrack
        path.setLength(prevLength);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        getPaths(root, paths, new StringBuilder());
        return paths;
    }

    public static void main(String[] args) {
        BinaryTreePaths obj = new BinaryTreePaths();

        List<String> paths = obj.binaryTreePaths(BinaryTreeMain.buildTree());
        System.out.println(paths);
    }
}

