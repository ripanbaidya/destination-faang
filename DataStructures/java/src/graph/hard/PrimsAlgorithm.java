package graph.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Ripan Baidya
 * @date 12-08-2025
 *
 * Given a weighted, undirected, and connected graph with V vertices and E edges, your task is
 * to find the sum of the weights of the edges in the Minimum Spanning Tree (MST) of the graph.
 * The graph is provided as a list of edges, where each edge  is  represented  as
 * [u, v, w], indicating an edge between vertex u and vertex v with edge weight w.
 *
 * Input: V = 3, E = 3, Edges = [[0, 1, 5], [1, 2, 3], [0, 2, 1]]
 * Output: 4
 *
 * time: O((V + E) * logV), for both the adjacency list construction and the priority queue operations.
 * space: O(V + E), due to the adjacency list and the priority queue storage.
 */
public class PrimsAlgorithm {
    // convert edge list into an adjacency list
    private List<List<int[]>> constructAdj(int V, int[][] edges) {
        List<List<int[] >> adj = new ArrayList<>();
        for (int i = 0; i < V; i ++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];

            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }

        return adj;
    }
    public int spanningTree(int V, int[][] edges) {
        int ans = 0; // minimum spanning tree
        List<List<int[]>> adj = constructAdj(V, edges);

        // each element will be {distance, node}
        // sort based on distance, if equal then based on node.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return (a[0] != b[0]) ? Integer.compare(a[0], b[0])
                                  : Integer.compare(a[1], b[1]);
        });
        int[] vis = new int[V]; // visited array

        // put the source node with distance 0 into priority queue
        pq.offer(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int currDist = top[0];
            int currNode = top[1];

            // when node is already visited then skip it
            if (vis[currNode] == 1) continue;

            ans += currDist;
            vis[currNode] = 1;
            for (int[] neighbour : adj.get(currNode)) {
                int adjNode = neighbour[0];
                int edgeWt = neighbour[1];

                if (vis[adjNode] == 0) {
                    pq.offer(new int[]{edgeWt, adjNode});
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        var obj = new PrimsAlgorithm();

        int V = 3, E = 3;
        int[][] edges = {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}};
        System.out.println(obj.spanningTree(V, edges));
    }
}