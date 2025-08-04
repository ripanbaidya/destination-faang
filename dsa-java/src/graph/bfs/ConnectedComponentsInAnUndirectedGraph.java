package graph.bfs;

import java.util.*;

/**
 * @author Ripan Baidya
 * @date 04-08-2025
 *
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
 *
 * time: O(V + E)
 * space: O(V + E), Adjacency list: O(V + E), Visited array: O(V), Queue and result lists: O(V) in the worst
 * case (for a single component).
 */
public class ConnectedComponentsInAnUndirectedGraph {
    // convert the 2d matrix to adj list
    private List<List<Integer>> convertToAdjacencyList(int V, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < V; i++) adjList.add(new ArrayList<>());

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        return adjList;
    }

    private List<Integer> bfs(int source, List<List<Integer>> adj, boolean[] vis, List<Integer> result) {
        vis[source] = true; // mark node as visited

        Queue<Integer> q = new LinkedList<>();
        q.offer(source);

        while(!q.isEmpty()) {
            int node = q.poll();
            result.add(node);

            for(int adjNode : adj.get(node)) {
                if(!vis[adjNode]) {
                    q.offer(adjNode);
                    vis[adjNode] = true;
                }
            }
        }

        return result;
    }

    public List<List<Integer>> getComponents(int V, int[][] edges) {
        List<List<Integer>> adjList = convertToAdjacencyList(V, edges);

        // list of list to store the connected components
        List<List<Integer>> result = new ArrayList<>();
        boolean[] vis = new boolean[V];

        for(int i = 0; i < V; i ++) {
            if(!vis[i]) {
                List<Integer> temp = bfs(i, adjList, vis, new ArrayList<>());
                result.add(temp);
            }
        }

        return result;
    }
}
