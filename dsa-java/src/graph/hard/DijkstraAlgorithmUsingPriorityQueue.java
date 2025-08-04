package graph.hard;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.stream.IntStream;
/**
 * @author Ripan Baidya
 * @date 04-08-2025
 *
 * Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by 2d array edges[][],
 * where edges[i]=[u, v, w] represents the edge between the nodes u and v having w edge weight.
 * Find the shortest distance of all the vertices from the source vertex src, and return an array of integers where the ith
 * element denotes the shortest distance between ith node and source vertex src.
 * Note: The Graph is connected and doesn't contain any negative weight edge.
 *
 * Input: V = 5, edges[][] = [[0, 1, 4], [0, 2, 8], [1, 4, 6], [2, 3, 2], [3, 4, 10]], src = 0
 * Output: [0, 4, 8, 10, 10]
 * Explanation:
 *
 * Shortest Paths:
 * For 0 to 1 minimum distance will be 4. By following path 0 -> 1
 * For 0 to 2 minimum distance will be 8. By following path 0 -> 2
 * For 0 to 3 minimum distance will be 10. By following path 0 -> 2 -> 3
 * For 0 to 4 minimum distance will be 10. By following path 0 -> 1 -> 4
 *
 * time complexity: O(E * logV)
 * space complexity: O(V)
 */

public class DijkstraAlgorithmUsingPriorityQueue {
    // convert 2D matrix to adjacency list
    private List<List<int[]>> convertToAdjList(int V, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < V; i ++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], weight = edge[2];
            adj.get(u).add(new int[]{v, weight});
        }

        return adj;
    }
    // dijkstra algorithm using priority queue(min-heap)
    public int[] dijkstra(int V, int[][] edges, int src) {
        List<List<int[]>> adj = convertToAdjList(V, edges);

        // {distance, node}
        // sort based on distance, if equal then based on node.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]); // Compare distance
            return Integer.compare(a[1], b[1]); // Tie-break: compare node
        });

        int[] dist = new int[V]; // distance array
        Arrays.fill(dist, (int) 1e9); // initialize all distances to infinity(1e9)
        dist[src] = 0; // source to source is distance 0
        pq.offer(new int[]{0, src}); // {distance, node}

        // bfs
        while (!pq.isEmpty()) {
            int edgeWeight = pq.peek()[0];
            int node = pq.peek()[1];

            pq.poll();

            // traverse through all adjacent nodes
            for (int[] neighbor : adj.get(node)) {
                int v = neighbor[0];
                int wt = neighbor[1];

                if (edgeWeight + wt < dist[v]) {
                    dist[v] = edgeWeight + wt; // update distance with shorter distance
                    pq.offer(new int[]{(edgeWeight + wt), v}); // put the new distance and node in the priority queue
                }
            }
        }

        // vertex that are unreachable from source will have distance -1
        IntStream.range(0, V).forEach(i -> {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        });

        return dist;
    }
    public static void main(String[] args) {
        var obj = new DijkstraAlgorithmUsingPriorityQueue();

        int[][] edges = {
                {0, 1, 4},
                {0, 2, 8},
                {1, 4, 6},
                {2, 3, 2},
                {3, 4, 10}
        };
        int V = edges.length;

        int[] shortestPath = obj.dijkstra(V, edges, 0); // V, edges, source
        System.out.println(Arrays.toString(shortestPath));
    }
}
