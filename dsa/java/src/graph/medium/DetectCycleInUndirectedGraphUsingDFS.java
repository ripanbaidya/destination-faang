package graph.medium;

import graph.representation.GraphMain;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an undirected graph with V vertices and E edges, represented as a 2D vector edges[][],
 * where each entry edges[i] = [u, v] denotes an edge between vertices u and v, determine whether
 * the graph contains a cycle or not.
 *
 * Input: V = 4, E = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
 * Output: true
 */
public class DetectCycleInUndirectedGraphUsingDFS {
    // Convert matrix into adjacency list
    private List<List<Integer>> convert(int[][] edges, int V) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i ++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }

    // Detect cycle using DFS
    private boolean detectCycle(int node, int parent, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true; // mark the node as visited

        // check all adjacent nodes
        for(int adjNode : adj.get(node)) {
            if(!vis[adjNode]) {
                // if the adjacent node is not visited, recursively call detectCycle
                // if it returns true, a cycle is detected
                if(detectCycle(adjNode, node, adj, vis))
                    return true;
            }
            // if the adjacent node is visited and is not the parent of the current node,
            else if (vis[adjNode] && parent != adjNode){
                return true;
            }
        }

        // if no cycle is detected, return false
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = convert(edges, V);
        boolean[] vis = new boolean[V];

        // iterate through all vertices
        for(int i = 0; i < V; i ++) {
            if(!vis[i]) {
                if(detectCycle(i, -1, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycleInUndirectedGraphUsingDFS obj = new DetectCycleInUndirectedGraphUsingDFS();

        int V = 5;
        boolean isCycle = obj.isCycle(V, GraphMain.buildGraphMatrix());
        System.out.println("Does the graph contain a cycle? " + isCycle);
    }
}

