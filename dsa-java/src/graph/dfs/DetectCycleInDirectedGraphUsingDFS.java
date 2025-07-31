package graph.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges,
 * check whether it contains any cycle or not. The graph is represented as a 2D vector
 * edges[][], where each entry edges[i] = [u, v] denotes an edge from vertices u to v.
 *
 * Input: V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 0], [2, 3]]
 * Output: true
 * Explanation: The diagram clearly shows a cycle 0 → 2 → 0
 */
public class DetectCycleInDirectedGraphUsingDFS {
    // Convert the edge list to an adjacency list representation
    // To solve dfs/bfs problems, we need to convert the edge list to an adjacency list
    private List<List<Integer>> convertToAdjList(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i ++) adj.add(new ArrayList<>());

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v); // directed
        }

        return adj;
    }
    private boolean dfs(int node, List<List<Integer>> adjList, int[] vis, int[] visPath) {
        // Mark the current node & current path as visited
        vis[node] = 1;
        visPath[node] = 1;

        for (int adjNode : adjList.get(node)) {
            // If the adjacent node is not visited, then do a dfs on it
            if (vis[adjNode] != 1) {
                if (dfs(adjNode, adjList, vis, visPath))
                    return true;
            }
            // If the adjacent node is visited and is part of the current path,
            // then we have found a cycle
            else if (visPath[adjNode] == 1 && vis[adjNode] == 1) {
                return true;
            }
        }

        // Backtrack: unmark the current node from the current path
        visPath[node] = 0;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adjList = convertToAdjList(V, edges);
        int[] vis = new int[V];
        int[] visPath = new int[V];

        for (int i = 0; i < V; i ++) {
            if (vis[i] != 1) {
                if (dfs(i, adjList, vis, visPath))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        DetectCycleInDirectedGraphUsingDFS obj = new DetectCycleInDirectedGraphUsingDFS();

        int V = 5;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}};

        boolean isCycle = obj.isCyclic(V, edges);
        System.out.println("Does the graph contain a cycle? " + isCycle);
    }
}

