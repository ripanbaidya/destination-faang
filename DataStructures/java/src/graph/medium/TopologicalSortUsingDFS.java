package graph.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Ripan Baidya
 * @date 01-08-2025
 *
 * Given a Directed Acyclic Graph (DAG) of V (0 to V-1) vertices and E edges represented as a 2D list of edges[][],
 * where each entry edges[i] = [u, v] denotes a directed edge u -> v. Return the topological sort for the given graph.
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed
 * edge u -> v, vertex u comes before v in the ordering.
 * Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological
 * sort is correct then the output will be true else false.
 *
 * Input: V = 6, E = 6, edges[][] = [[1, 3], [2, 3], [4, 1], [4, 0], [5, 0], [5,2]]
 * Output: true
 * Explanation: The output true denotes that the order is valid. Few valid Topological orders for the graph are:
 * [4, 5, 0, 1, 2, 3]
 * [5, 2, 4, 0, 1, 3]
 *
 * time: O(V + E)
 * space: O(V)
 */
public class TopologicalSortUsingDFS {
    // Convert the edge list to an adjacency list representation
    private List<List<Integer>> convertToAdjList(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i ++) adj.add(new ArrayList<>());

        for (int []edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v); // directed
        }

        return adj;
    }

    // DFS
    private void dfs(int node, List<List<Integer>> adjList, int[] vis, Stack<Integer> st) {
        vis[node] = 1;

        for (int adjNode : adjList.get(node)) {
            if (vis[adjNode] == 0) {
                dfs(adjNode, adjList, vis, st);
            }
        }

        // push the current node to the stack, to store the topo sort
        st.push(node);
    }

    // Topological sort
    public List<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> adj = convertToAdjList(V, edges);

        Stack<Integer> st = new Stack<>();
        int[] vis = new int[V]; // visited array

        for (int i = 0; i < V; i ++) {
            if (vis[i] == 0) {
                dfs(i, adj, vis, st);
            }
        }

        // create a list to store the topo sort
        ArrayList<Integer> topo = new ArrayList<>();
        while(!st.isEmpty()) {
            topo.add(st.pop());
        }

        return topo;
    }

    public static void main(String[] args) {
        TopologicalSortUsingDFS obj = new TopologicalSortUsingDFS();

        int V = 6, E = 6;
        int[][] edges = {{1, 3}, {2, 3}, {4, 1}, {4, 0}, {5, 0}, {5, 2}};

        System.out.println(obj.topoSort(V, edges));
    }
}
