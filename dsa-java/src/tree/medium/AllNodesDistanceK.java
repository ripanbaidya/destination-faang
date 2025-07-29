package tree.medium;

import tree.representation.TreeNode;

import java.util.*;

/**
 * Given the root of a binary tree, the value of a target node target, and an integer k,
 * return an array of the values of all nodes that have a distance k from the target node.
 * You can return the answer in any order.
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
 * Output: [7,4,1]
 * Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
 */
public class AllNodesDistanceK {
    private void markParents(TreeNode root, HashMap<TreeNode, TreeNode> mp){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i ++) {
                TreeNode currNode = q.poll();

                // Add left and right children to queue if they exist
                if (currNode.left != null) {
                    mp.put(currNode.left, currNode);
                    q.offer(currNode.left);
                }
                if (currNode.right != null) {
                    mp.put(currNode.right, currNode);
                    q.offer(currNode.right);
                }
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        // Map to store parent pointers for each node
        // This will help us traverse up the tree
        HashMap<TreeNode, TreeNode> mp = new HashMap<>();
        markParents(root, mp);

        // BFS to find all nodes at distance k from target
        // We will use a queue to traverse the tree level by level
        // and a visited map to avoid cycles
        HashMap<TreeNode, Boolean> visited = new HashMap<>(); // {node -> true/false}
        Queue<TreeNode> q = new LinkedList<>();

        int countDistance = 0;
        q.offer(target);
        visited.put(target, true);

        while (!q.isEmpty()) {
            int len = q.size();
            if (countDistance == k) break;

            countDistance ++;

            // Check for left, right, and parent nodes
            for (int i = 0; i < len; i ++) {
                TreeNode currNode = q.poll();

                // left
                if (currNode.left != null && !visited.containsKey(currNode.left)) {
                    q.offer(currNode.left);
                    visited.put(currNode.left, true);
                }
                // right
                if (currNode.right != null && !visited.containsKey(currNode.right)) {
                    q.offer(currNode.right);
                    visited.put(currNode.right, true);
                }
                // parent
                if (mp.get(currNode) != null && !visited.containsKey(mp.get(currNode))) {
                    q.offer(mp.get(currNode));
                    visited.put(mp.get(currNode), true);
                }
            }
        }

        // Iterate through the queue and add all nodes at distance k to the result
        while (!q.isEmpty()) {
            result.add(q.poll().val);
        }

        return result;
    }
}
