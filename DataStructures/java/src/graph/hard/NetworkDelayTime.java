package graph.hard;

import java.util.*;
/**
 * @author Ripan Baidya
 * @date 07-08-2025
 *
 * Given a network of V nodes (numbered from 0 to V-1) and E number of directed connections, described
 * by an array edges[], where each element {u, v, w} specifies that a signal requires w units of time
 * to propagate from node u to node v.
 * A signal is transmitted from the source node src. Return the minimum time it takes for all the nodes
 * to receive the signal. If any node remains unreachable, return -1.
 * Note: There are no multiple edge connections in the network.
 *
 * Examples:
 *
 * Input: V = 3, edges[][] = [[0, 2, 1], [2, 1, 2], [0, 1, 4]], src = 0
 * Output: 3
 * Explanation: In 3 units of time the signal can cover all the nodes by following this path: 0 -> 2 -> 1
 */
public class NetworkDelayTime {
    // convert edge list into an adjacency list
    private List<List<int[]>> convertToAdjList(int V, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[]{v, w});
        }

        return adj;
    }

    public int findDelayTime(int V, int[][] edges, int src) {
        List<List<int[]>> adj = convertToAdjList(V, edges);

        // declare and initialize distance array
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);

        // each element will be {distance, node}
        // sort based on distance, if equal then based on node.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return (a[0] != b[0]) ? Integer.compare(a[0], b[0])
                                  : Integer.compare(a[1], b[1]);
        });
        dist[src] = 0;
        pq.offer(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int currDist = top[0];
            int currNode = top[1];

            // Skip if we've already found a shorter path
            if (currDist > dist[currNode]) continue;

            for (int[] neighbor : adj.get(currNode)) {
                int adjNode = neighbor[0];
                int edgeWeight = neighbor[1];

                if (currDist + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = currDist + edgeWeight;
                    pq.offer(new int[]{dist[adjNode], adjNode});
                }
            }
        }

        // get maximum distance
        int minTime = 0;
        for (int d : dist) {
            if (d == (int) 1e9) {
                return -1; // unreachable node
            }
            minTime = Math.max(minTime, d);
        }

        return minTime;
    }

    public static void main(String[] args) {
        var obj = new NetworkDelayTime();

        int[][] edges = {{0, 2, 1}, {2, 1, 2}, {0, 1, 4}};
        int V = 3, src = 0;

        int delayTime = obj.findDelayTime(V, edges, src);
        System.out.println("Minimum time taken to reach all nodes: " + delayTime);
    }
}
