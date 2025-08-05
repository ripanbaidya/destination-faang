package graph.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ripan Baidya
 * @date 03-08-2025
 *
 * You are given an adjacency list, adj of Undirected Graph having unit weight of the edges, find the shortest
 * path from src to all the vertex and if it is unreachable to reach any vertex, then return -1 for that vertex.
 *
 * Input: adj[][] = [[1, 3], [0, 2], [1, 6], [0, 4], [3, 5], [4, 6], [2, 5, 7, 8], [6, 8], [7, 6]], src=0
 * Output: [0, 1, 2, 1, 2, 3, 3, 4, 4]
 *
 * time: O(V + E)
 * space: O(V + E)
 */
public class ShortestPathInUndirectedGraph {
    // Function to find the shortest path in an unweighted graph using BFS
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adjList, int source) {
        int V = adjList.size();

        // distance array to store the shortest distance from the source to each currNode
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);  // Initially, set all distances to infinity

        // Queue for BFS traversal: each element is {node, distance from source}
        Queue<int[]> queue = new LinkedList<>();
        dist[source] = 0;  // source to source is distance 0
        queue.offer(new int[]{source, 0});

        // bfs
        while (!queue.isEmpty()) {
            int node = queue.peek()[0];
            int currDist = queue.peek()[1];
            queue.poll();

            int newDistance = currDist + 1;  // For unweighted graph, each edge adds +1

            // Traverse all adjacent nodes
            for (int adjNode : adjList.get(node)) {

                // If a shorter path to adjNode is found
                if (newDistance < dist[adjNode]) {
                    dist[adjNode] = newDistance;
                    queue.offer(new int[]{adjNode, newDistance});
                }
            }
        }

        // Replace unreachable currNode distances with -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }

}
