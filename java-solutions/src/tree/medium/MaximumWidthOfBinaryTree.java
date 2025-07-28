package tree.medium;

import tree.representation.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the maximum width of the given tree.
 * The maximum width of a tree is the maximum width among all levels.
 * The width of one level is defined as the length between the end-nodes (the leftmost and
 * rightmost non-null nodes), where the null nodes between the end-nodes that would be present
 * in a complete binary tree extending down to that level are also counted into the length calculation.
 * It is guaranteed that the answer will in the range of a 32-bit signed integer.
 *
 * Input: root = [1,3,2,5,null,null,9,6,null,7]
 * Output: 7
 * Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
 */
public class MaximumWidthOfBinaryTree {
    static class NodeIndexPair {
        TreeNode node;
        int index;

        public NodeIndexPair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        if (root == null) return maxWidth;

        Queue<NodeIndexPair> queue = new LinkedList<>();
        queue.offer(new NodeIndexPair(root, 1));

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int firstIndex = 0, lastIndex = 0;
            int minIndex = queue.peek().index;

            for (int i = 0; i < levelSize; i++) {
                NodeIndexPair currentPair = queue.poll();
                TreeNode currentNode = currentPair.node;
                int currentIndex = currentPair.index;

                if (i == 0) firstIndex = currentIndex;
                if (i == levelSize - 1) lastIndex = currentIndex;

                // Add children to the queue with adjusted indices
                // We subtract minIndex to avoid overflow and keep indices manageable
                if (currentNode.left != null)
                    queue.offer(new NodeIndexPair(currentNode.left, 2 * currentIndex - minIndex));
                if (currentNode.right != null)
                    queue.offer(new NodeIndexPair(currentNode.right, 2 * currentIndex + 1 - minIndex));
            }
            // Calculate the width of the current level
            maxWidth = Math.max(maxWidth, lastIndex - firstIndex + 1);
        }

        return maxWidth;
    }
}