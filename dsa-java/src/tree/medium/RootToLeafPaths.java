package tree.medium;

import tree.representation.BinaryTreeMain;
import tree.representation.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a Binary Tree, you need to find all the possible paths from the root node to all the leaf nodes of the binary tree.
 * Note: The paths should be returned such that paths from the left subtree of any node are listed first,
 * followed by paths from the right subtree.
 *
 * Input: root[] = [1, 2, 3, 4, 5, N, N]
 * Output: [[1, 2, 4], [1, 2, 5], [1, 3]]
 * Explanation: All the possible paths from root node to leaf nodes are: 1 -> 2 -> 4, 1 -> 2 -> 5 and 1 -> 3
 */
public class RootToLeafPaths {
    public void getPaths(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp, Node root) {
        if(root == null) return;
        temp.add(root.data);

        // when we reach a leaf node, we add the current path to the answer
        if(root.left == null && root.right == null) {
            ans.add(new ArrayList<>(temp));
        }

        // traverse left and right subtrees to find all paths from root to leaf nodes
        getPaths(ans, temp, root.left);
        getPaths(ans, temp, root.right);

        // backtrack to explore other paths and remove the last node from the current path
        temp.removeLast();
    }
    public ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        getPaths(result, temp, root);
        return result;
    }

    public static void main(String[] args) {
        RootToLeafPaths obj = new RootToLeafPaths();

        ArrayList<ArrayList<Integer>> result = obj.Paths(BinaryTreeMain.buildBinaryTree());
        System.out.println("All paths from root to leaf nodes: " + result);
    }
}
