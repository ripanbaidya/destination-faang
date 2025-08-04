package graph.dfs;

import java.util.*;

/**
 * @author Ripan Baidya
 * @date 04-08-2025
 *
 * Given a connected undirected graph containing V vertices represented by a 2-d adjacency list adj[][],
 * where each adj[i] represents the list of vertices connected to vertex i. Perform a Depth First Search
 * (DFS) traversal starting from vertex 0, visiting vertices from left to right as per the given adjacency
 * list, and return a list containing the DFS traversal of the graph.
 *
 * Note: Do traverse in the same order as they are in the given adjacency list.
 *
 * Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]
 * Output: [0, 2, 4, 3, 1]
 * Explanation: Starting from 0, the DFS traversal proceeds as follows:
 * Visit 0 → Output: 0
 * Visit 2 (the first neighbor of 0) → Output: 0, 2
 * Visit 4 (the first neighbor of 2) → Output: 0, 2, 4
 * Backtrack to 2, then backtrack to 0, and visit 3 → Output: 0, 2, 4, 3
 * Finally, backtrack to 0 and visit 1 → Final Output: 0, 2, 4, 3, 1
 */
public class DFS {
    private void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] vis, ArrayList<Integer> result) {
        // mark the current node as visited and add it to the result list
        vis[node] = true;
        result.add(node);

        // iterate through all adjacent vertices of the current vertex
        // if the vertex is not visited, recursively call dfs on it
        for(int adjNode : adjList.get(node)) {
            if(!vis[adjNode]) {
                dfs(adjNode, adjList, vis, result);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int source = 0;

        // list to store dfs traversal order
        ArrayList<Integer> result = new ArrayList<>();

        // visited array
        boolean[] vis = new boolean[V];

        // start DFS from the source node
        dfs(source, adj, vis, result);

        return result;
    }

    public static void main(String[] args) {
        DFS obj = new DFS();

        // create the adjacency list: { {2, 3, 1}, {0}, {0, 4}, {0}, {2} }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(2)));

        ArrayList<Integer> ans = obj.dfs(adj);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
