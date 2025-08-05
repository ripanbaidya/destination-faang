package graph.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given a Graph with V vertices (Numbered from 0 to V-1) and E edges. Check whether the graph is bipartite or not.
 * A bipartite graph can be colored with two colors such that no two adjacent vertices share the same color. This
 * means we can divide the graph’s vertices into two distinct sets where:
 *
 * All edges connect vertices from one set to vertices in the other set.
 * No edges exist between vertices within the same set.
 *
 * Input: V = 3, edges[][] = [[0, 1], [1,2]], Bipartite-Graph
 * Output: true
 * Explanation: The given graph can be colored in two colors so, it is a bipartite graph.
 */
public class BipartiteGraph {
    // Convert the edge list to an adjacency list representation
    private List<List<Integer>> convertToAdjList(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i ++) adj.add(new ArrayList<>());

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u); // remove this if directed
        }

        return adj;
    }
    private boolean dfs(int src, int color, List<List<Integer>> adjList, int[] colors) {
        colors[src] = color;

        for (int adjNode : adjList.get(src)) {
            if (colors[adjNode] == -1) {
                // If we found any node return false means it is not bipartite
                // we also return false to its parent node
                if (!dfs(adjNode, color^1, adjList, colors))
                    return false;
            }
            // When the adjacent node is already colored with the same color
            else if (colors[adjNode] == color) {
                return false;
            }
        }

        // bipartite graph is possible
        return true;
    }
    public boolean isBipartite(int V, int[][] edges) {
        List<List<Integer>> adj = convertToAdjList(V, edges);
        int[] colors = new int[V];
        Arrays.fill(colors, -1);

        for (int i = 0; i < V; i ++) {
            if (colors[i] == -1) {
                if (!dfs(i, 0, adj, colors))
                    return false;
            }
        }

        return true;
    }
}
