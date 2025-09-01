package graph.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * @author Ripan Baidya
 * @date 03-08-2025
 *
 * You are given an adjacency list, adj of Undirected Graph having unit weight of the edges,
 * find the shortest path from src to all the vertex and if it is unreachable to reach any
 * vertex, then return -1 for that vertex.
 *
 * Input:
 * adj[][] = [[1, 3], [0, 2], [1, 6], [0, 4], [3, 5], [4, 6], [2, 5, 7, 8], [6, 8], [7, 6]]
 * src=0
 * Output: [0, 1, 2, 1, 2, 3, 3, 4, 4]
 *
 * time: O(V + E)
 * space: O(V + E)
 */
public class ShortestPathInUndirectedGraph {
    // Function to find the shortest path in an unweighted graph using BFS
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adjList, int source) {
        int V = adjList.size();

        // dist[i] will hold the shortest distance from source to i
        int[] dist = new int[V];

        // Initialize all distances as infinite
        Arrays.fill(dist, (int) 1e9);

        // Queue for BFS traversal: each element is {node, distance from source}
        Queue<int[]> queue = new LinkedList<>();

        // source to source is distance 0
        dist[source] = 0;
        queue.offer(new int[]{source, 0});

        // BFS
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int currNode = top[0];
            int currDist = top[1];

            // Traverse through all adjacent nodes
            for (int adjNode : adjList.get(currNode)) {
                // Edge weight is 1
                int newDistance = currDist + 1;

                if (newDistance < dist[adjNode]) {
                    dist[adjNode] = newDistance;
                    queue.offer(new int[]{adjNode, newDistance});
                }
            }
        }

        // Convert all infinite distances to -1
        IntStream.range(0, V).forEach(i -> {
           if (dist[i] == (int) 1e9) {
               dist[i] = -1;
           }
        });

        return dist;
    }

}
