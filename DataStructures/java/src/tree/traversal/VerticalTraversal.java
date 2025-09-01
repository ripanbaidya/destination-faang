package tree.traversal;

import tree.representation.BinaryTreeMain;
import tree.representation.TreeNode;

import java.util.*;

/**
 * Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
 * For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1)
 * and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
 * The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index
 * starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the
 * same row and same column. In such a case, sort these nodes by their values.
 * Return the vertical order traversal of the binary tree.
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 */
public class VerticalTraversal {
    static class Tuple {
        int row;
        int col;
        TreeNode node;

        public Tuple(int row, int col, TreeNode node) {
            this.row = row;
            this.col = col;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        // {column -> {row -> priority queue of values}}
        // Using TreeMap to maintain the order of columns and rows
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(0, 0, root));

        while(!q.isEmpty()) {
            int len = q.size();

            for(int i = 0; i < len; i ++) {
                Tuple curr = q.poll();

                TreeNode currNode = curr.node;
                int currRow = curr.row;
                int currCol = curr.col;

                // Push left and right children into the queue if they exist
                if(currNode.left != null) q.offer(new Tuple(currRow+1, currCol-1, currNode.left));
                if(currNode.right != null) q.offer(new Tuple(currRow+1, currCol+1, currNode.right));

                // add the column if it doesn't exist
                if(!mp.containsKey(currCol)) mp.put(currCol, new TreeMap<>());

                // add the row if it doesn't exist
                if(!mp.get(currCol).containsKey(currRow)) mp.get(currCol).put(currRow, new PriorityQueue<>());

                // add the value to the priority queue for that column and row
                mp.get(currCol).get(currRow).offer(currNode.val);
            }
        }

        // Iterate through the TreeMap to construct the result
        for(TreeMap<Integer, PriorityQueue<Integer>> row : mp.values()) {
            result.add(new ArrayList<>());
            for(PriorityQueue<Integer> val : row.values()) {
                while(!val.isEmpty()) {
                    result.get(result.size()-1).add(val.poll());
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        VerticalTraversal obj = new VerticalTraversal();

        List<List<Integer>> result = obj.verticalTraversal(BinaryTreeMain.buildTree());

        for(List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
