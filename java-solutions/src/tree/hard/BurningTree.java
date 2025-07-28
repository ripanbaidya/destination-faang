package tree.hard;

import tree.representation.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree and a target node, determine the minimum time required to burn the entire tree
 * if the target node is set on fire. In one second, the fire spreads from a node to its left child, right child, and parent.
 * Note: The tree contains unique values.
 *
 * Input: root[] = [1, 2, 3, 4, 5, 6, 7], target = 2
 * Output: 3
 * Explanation: Initially 2 is set to fire at 0 sec
 * At 1 sec: Nodes 4, 5, 1 catches fire.
 * At 2 sec: Node 3 catches fire.
 * At 3 sec: Nodes 6, 7 catches fire.
 * It takes 3s to burn the complete tree.
 */
public class BurningTree {
    private void markParents(Node root, HashMap<Node, Node> mp){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i ++) {
                Node currNode = q.poll();

                // Add left and right children to queue if they exist
                // and mark their parent in the map, this will help us traverse up the tree
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
    public Node findTargetNode(Node root, int target) {
        if (root == null) return null;
        if (root.data == target) return root;

        Node left = findTargetNode(root.left, target);
        if (left != null) return left;

        return findTargetNode(root.right, target);
    }

    public int minTime(Node root, int target) {
        int miniTime = 0;
        if (root == null) return miniTime;

        // Map to store parent pointers for each node
        // This will help us traverse up the tree
        HashMap<Node, Node> mp = new HashMap<>();
        markParents(root, mp);

        Node targetNode = findTargetNode(root, target);

        // BFS to find the minimum time to burn the entire tree
        // We will use a queue to traverse the tree level by level
        // and a visited map to avoid cycles
        HashMap<Node, Boolean> visited = new HashMap<>(); // {node -> true/false}
        Queue<Node> q = new LinkedList<>();

        q.offer(targetNode);
        visited.put(targetNode, true);

        while (!q.isEmpty()) {
            int len = q.size();
            boolean flag = false;

            // Check for left, right, and parent nodes
            for (int i = 0; i < len; i ++) {
                Node currNode = q.poll();

                // left
                if (currNode.left != null && !visited.containsKey(currNode.left)) {
                    flag = true;
                    q.offer(currNode.left);
                    visited.put(currNode.left, true);
                }
                // right
                if (currNode.right != null && !visited.containsKey(currNode.right)) {
                    flag = true;
                    q.offer(currNode.right);
                    visited.put(currNode.right, true);
                }
                // parent
                if (mp.get(currNode) != null && !visited.containsKey(mp.get(currNode))) {
                    flag = true;
                    q.offer(mp.get(currNode));
                    visited.put(mp.get(currNode), true);
                }
            }
            if (flag) {
                miniTime ++;
            }
        }

        return miniTime;
    }
}
