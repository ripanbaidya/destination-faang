package graph.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an undirected graph with V vertices numbered from 0 to V-1 and E edges, represented as a 2D array edges[][],
 * where each entry edges[i] = [u, v] denotes an edge between vertices u and v.
 *
 * Your task is to return a list of all connected components. Each connected component should be represented as a list
 * of its vertices, with all components returned in a collection where each component is listed separately.
 *
 * Note: You can return the components in any order, driver code will print the components in sorted order.
 *
 * Input: V = 5, edges[][] = [[0, 1], [2, 1], [3, 4]]
 * Output: [[0, 1, 2], [3, 4]]
 */
public class ConnectedComponentsInAnUndirectedGraph {
    private ArrayList<ArrayList<Integer>> convertToAdjacencyList(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }

    private ArrayList<Integer> bfs(int node, ArrayList<ArrayList<Integer>> adj,
                                   boolean[] vis, ArrayList<Integer> res) {
        Queue<Integer> q = new LinkedList<>();

        // mark the node as visited and add it to the queue
        vis[node] = true;
        q.offer(node);

        while(!q.isEmpty()) {
            node = q.poll();
            res.add(node);

            for(int it : adj.get(node)) {
                if(!vis[it]) {
                    q.offer(it);
                    vis[it] = true;
                }
            }
        }

        return res;
    }

    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = convertToAdjacencyList(V, edges);

        // to store the connected components
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        boolean[] vis = new boolean[V];

        for(int i = 0; i < V; i ++) {
            if(!vis[i]) {
                ArrayList<Integer> temp = bfs(i, adj, vis, new ArrayList<>());
                res.add(temp);
            }
        }

        return res;
    }
}
