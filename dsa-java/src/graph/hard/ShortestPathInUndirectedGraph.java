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
        int numVertices = adjList.size();

        // Array to store the shortest distance from the source to each node
        int[] shortestDistance = new int[numVertices];
        Arrays.fill(shortestDistance, Integer.MAX_VALUE);  // Initially, set all distances to infinity

        // Queue for BFS traversal: each element is {node, distance from source}
        Queue<int[]> queue = new LinkedList<>();
        shortestDistance[source] = 0;  // Distance to source is 0
        queue.offer(new int[]{source, 0});

        // (BFS)
        while (!queue.isEmpty()) {
            int currentNode = queue.peek()[0];
            int currentDistance = queue.peek()[1];
            queue.poll();

            int newDistance = currentDistance + 1;  // For unweighted graph, each edge adds +1

            // Traverse all adjacent nodes
            for (int neighbor : adjList.get(currentNode)) {
                // If a shorter path to neighbor is found
                if (newDistance < shortestDistance[neighbor]) {
                    shortestDistance[neighbor] = newDistance;
                    queue.offer(new int[]{neighbor, newDistance});
                }
            }
        }

        // Replace unreachable node distances with -1
        for (int i = 0; i < numVertices; i++) {
            if (shortestDistance[i] == Integer.MAX_VALUE) {
                shortestDistance[i] = -1;
            }
        }

        return shortestDistance;
    }

}
