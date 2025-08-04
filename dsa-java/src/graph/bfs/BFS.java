package graph.bfs;

import java.util.*;

/**
 * @author Ripan Baidya
 * @date 04-08-2025
 *
 * Given a connected undirected graph containing V vertices, represented by a 2-d adjacency list adj[][],
 * where each adj[i] represents the list of vertices connected to vertex i. Perform a Breadth First Search
 * (BFS) traversal starting from vertex 0, visiting vertices from left to right according to the given
 * adjacency list, and return a list containing the BFS traversal of the graph.
 *
 * Note: Do traverse in the same order as they are in the given adjacency list.
 *
 * Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]
 * Output: [0, 2, 3, 1, 4]
 * Explanation: Starting from 0, the BFS traversal will follow these steps:
 * Visit 0 → Output: 0
 * Visit 2 (first neighbor of 0) → Output: 0, 2
 * Visit 3 (next neighbor of 0) → Output: 0, 2, 3
 * Visit 1 (next neighbor of 0) → Output: 0, 2, 3,
 * Visit 4 (neighbor of 2) → Final Output: 0, 2, 3, 1, 4
 *
 * Time: O(V + E) where V is the number of vertices and E is the number of edges.
 * Space: O(V) for the visited array and queue.
 */
public class BFS {
    private ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adjList) {
        int V = adjList.size();
        int source = 0;

        ArrayList<Integer> res = new ArrayList<>(); // store bfs traversal order
        boolean[] vis = new boolean[V]; // visited array

        // A queue for BFS traversal
        Queue<Integer> q = new LinkedList<>();

        // mark source node as visited and put it into the queue
        vis[source] = true;
        q.offer(0);

        while(!q.isEmpty()) {
            int node = q.poll();
            res.add(node);

            // iterate through all adjacent vertices of the current vertex
            // if the adjacent vertex is not visited, mark it as visited and
            // add to queue, also add it to the bfs list
            for (int adjNode : adjList.get(node)) {
                if (!vis[adjNode]) {
                    vis[adjNode] = true;
                    q.offer(adjNode);
                }
            }
        }

        // return the BFS traversal of the graph
        return res;
    }

    public static void main(String[] args) {
        BFS obj = new BFS();

        // create the adjacency list: { {2, 3, 1}, {0}, {0, 4}, {0}, {2} }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(2)));


        ArrayList<Integer> ans = obj.bfs(adj);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
