package graph.hard;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author Ripan Baidya
 * @date 03-08-2025
 *
 * Given a Directed Acyclic Graph of V vertices from 0 to n-1 and a 2D Integer array(or vector) edges[ ][ ] of length E,
 * where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.
 * Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1
 * for that vertex.
 *
 * Input: V = 6, E = 7, edges = [[0,1,2], [0,4,1], [4,5,4], [4,2,2], [1,2,3], [2,3,6], [5,3,1]]
 * Output: [0, 2, 3, 6, 1, 5]
 * Explanation: Shortest path from 0 to 1 is 0->1 with edge weight 2. Shortest path from 0 to 2 is 0->4->2 with edge weight 1+2=3.
 * Shortest path from 0 to 3 is 0->4->5->3 with edge weight 1+4+1=6. Shortest path from 0 to 4 is 0->4 with edge weight 1.Shortest
 * path from 0 to 5 is 0->4->5 with edge weight 1+4=5.
 */
public class ShortestPathInDirectedAcyclicGraph {
    // Function to convert edge list into an adjacency list
    private List<List<int[]>> convertToAdjList(int V, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Add directed edges with weights to the list
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new int[]{v, wt});
        }

        return adj;
    }

    // Recursive function to perform Topological Sort using DFS
    private void topoSort(int node, Stack<Integer> st, int[] vis, List<List<int[]>> adjList) {
        vis[node] = 1;

        // Visit all unvisited neighbors
        for (int[] neighbor : adjList.get(node)) {
            int adjNode = neighbor[0];
            if (vis[adjNode] == 0) {
                topoSort(adjNode, st, vis, adjList);
            }
        }

        // Push current node to stack after processing all neighbors
        st.push(node);
    }

    // Main function to find the shortest path in a DAG from source node (0)
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Step 1: Build adjacency list
        List<List<int[]>> adj = convertToAdjList(V, edges);

        // Step 2: Perform Topological Sort
        Stack<Integer> st = new Stack<>();
        int[] vis = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                topoSort(i, st, vis, adj);
            }
        }

        // Step 3: Initialize distance array
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9); // Use large value to represent infinity
        dist[0] = 0; // Source node distance is 0

        // Step 4: Relax edges in topological order
        while (!st.isEmpty()) {
            int node = st.pop();

            // If node is reachable
            if (dist[node] != (int) 1e9) {
                for (int[] edge : adj.get(node)) {
                    int v = edge[0], wt = edge[1];

                    // Relaxation condition
                    if (dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt;
                    }
                }
            }
        }

        // Step 5: Replace unreachable node distances with -1
        IntStream.range(0, V).forEach(i -> {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        });

        return dist;
    }

}
