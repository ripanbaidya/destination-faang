package graph;

import java.util.Arrays;

/**
 * @author Ripan Baidya
 * @date 09-08-2025
 *
 * Given an weighted graph with V vertices numbered from 0 to V-1 and E edges, represented
 * by a 2d array edges[][], where edges[i] = [u, v, w] represents a direct edge from node u
 * to v having w edge weight. You are also given a source vertex src.
 *
 * Your task is to compute the shortest distances from the source to all other vertices. If
 * a vertex is unreachable from the source,its distance should be marked as 108.Additionally,
 * if the graph contains a negative weight cycle, return [-1] to indicate that shortest paths
 * cannot be reliably computed.
 *
 * Example:
 *
 * Input: V = 5, edges[][] = [[1, 3, 2], [4, 3, -1], [2, 4, 1], [1, 2, 1], [0, 1, 5]], src = 0
 *
 * Output: [0, 5, 6, 6, 7]
 * Explanation: Shortest Paths:
 * For 0 to 1 minimum distance will be 5. By following path 0 → 1
 * For 0 to 2 minimum distance will be 6. By following path 0 → 1  → 2
 * For 0 to 3 minimum distance will be 6. By following path 0 → 1  → 2 → 4 → 3
 * For 0 to 4 minimum distance will be 7. By following path 0 → 1  → 2 → 4
 */
public class BellmanFord {
    final int INF = (int) 1e8;

    public int[] bellmanFord(int V, int[][] edges, int src) {
        // Initially distance from source to all other vertices
        // is not known(Infinite).
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        // Relaxation of all the edges V times, not (V - 1) as we
        // need one additional relaxation to detect negative cycle
        for (int i = 0; i < V; i ++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int weight = edge[2];

                if (dist[u] != INF && dist[u]+weight < dist[v]) {

                    // If this is the Vth relaxation, then there is
                    // a negative cycle
                    if (i == V-1) {
                        return new int[]{-1};
                    }

                    // Update shortest distance to node v
                    dist[v] = dist[u]+weight;
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = new int[][]{{1, 3, 2}, {4, 3, -1}, {2, 4, 1}, {1, 2, 1}, {0, 1, 5}};
        int src = 0;

        int[] dist = new BellmanFord().bellmanFord(V, edges, src);

        // print shortest distances from source to all vertices
        for (int i = 0; i < V; i ++) {
            System.out.print(dist[i] + " ");
        }
    }
}
