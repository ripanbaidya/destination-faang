package graph.hard;

import java.util.*;

/**
 * @author Ripan Baidya
 * @date 06-08-2025
 *
 * You are given a weighted undirected graph having n vertices numbered from 1 to n and m edges
 * along with their weights. Find the shortest weight path between the vertex 1 and the vertex n,
 * if there exists a path, and return a list of integers whose first element is the weight of the
 * path, and the rest consist of the nodes on that path. If no path exists, then return a list
 * containing a single element -1.
 *
 * The input list of edges is as follows - {a, b, w}, denoting there is an edge between a and b,
 * and w is the weight of that edge.
 *
 * Note: The driver code here will first check if the weight of the path returned is equal to the
 * sum of the weights along the nodes on that path, if equal it will output the weight of the path,
 * else -2. In case the list contains only a single element (-1) it will simply output -1.
 *
 * Examples :
 * Input: n = 5, m= 6, edges = [[1, 2, 2], [2, 5, 5], [2, 3, 4], [1, 4, 1], [4, 3, 3], [3, 5, 1]]
 * Output: 5
 * Explanation: Shortest path from 1 to n is by the path 1 4 3 5 whose weight is 5.
 */
public class ShortestPathInWeightedUndirectedGraph {
    // convert edge list into an adjacency list
    private List<List<int[]>> convertToAdjList(int V, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();

        // initialize adjacency list
        for (int i = 0; i < V; i ++) {
            adj.add(new ArrayList<>());
        }

        // add directed edges with weights to the list
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], weight = edge[2];
            adj.get(u).add(new int[]{v, weight});
        }

        return adj;
    }
    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        List<List<int[]>> adj = convertToAdjList(n, edges);

        // declare and initialize distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int) 1e9);

        // declare and initialize parent array
        // where, parent[i] is the parent of node i (i.e. node itself its own parent)
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // each element will be {distance, node}
        // sort based on distance, if equal then based on node.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return (a[0] != b[0]) ? Integer.compare(a[0], b[0])
                    : Integer.compare(a[1], b[1]);
        });

        // put the source into priority queue and set its distance to 0
        dist[1] = 0;
        pq.offer(new int[]{0, 1});

        // BFS
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int currDist = top[0];
            int currNode = top[1];

            for (int[] neighbor : adj.get(currNode)) {
                int adjNode = neighbor[0];
                int edgeWeight = neighbor[1];

                if ((currDist + edgeWeight) < dist[adjNode]) {
                    dist[adjNode] = currDist + edgeWeight; // update distance
                    parent[adjNode] = currNode; // update parent
                    pq.offer(new int[]{dist[adjNode], adjNode}); // add to priority queue
                }
            }
        }

        // when distincation(n) is unreachable, return -1
        if (dist[n] == (int) 1e9) {
            return List.of(-1);
        }

        // reconstruct path
        // n -> . -> . -> . -> 1
        List<Integer> path = new ArrayList<>();
        int node = n;

        while (node != parent[node]) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);

        // Prepend total weight to path list
        List<Integer> result = new ArrayList<>();
        result.add(dist[n]); // total weight
        result.addAll(path);

        return result;
    }
}
