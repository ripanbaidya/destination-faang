package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * @author Ripan Baidya
 * @date 09-08-2025
 *
 * Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges,
 * represented by 2d array edges[][], where edges[i]=[u, v, w] represents the edge between
 * the nodes u and v having w edge weight.
 * Find the shortest distance of all the vertices from the source vertex src, and return an
 * array of integers where the ith element denotes the shortest distance between ith node
 * and source vertex src.
 * Note: The Graph is connected and doesn't contain any negative weight edge.
 *
 * Input: V = 5, edges[][] = [[0, 1, 4], [0, 2, 8], [1, 4, 6], [2, 3, 2], [3, 4, 10]], src = 0
 * Output: [0, 4, 8, 10, 10]
 *
 * Explanation:
 * For 0 to 1 minimum distance will be 4. By following path 0 -> 1
 * For 0 to 2 minimum distance will be 8. By following path 0 -> 2
 * For 0 to 3 minimum distance will be 10. By following path 0 -> 2 -> 3
 * For 0 to 4 minimum distance will be 10. By following path 0 -> 1 -> 4
 *
 * time complexity: O(E * logV)
 * space complexity: O(V)
 */
public class DijkstraUsingSet {
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

    // Dijkstra Algorithm using priority queue(min-heap)
    public int[] dijkstra(int V, int[][] edges, int src) {
        List<List<int[]>> adj = convertToAdjList(V, edges);

        // each element will be {distance, node}
        // sort based on distance, if equal then based on node.
        TreeSet<int[]> st = new TreeSet<>((a, b) -> {
            return (a[0] != b[0]) ? Integer.compare(a[0], b[0])
                                  : Integer.compare(a[1], b[1]);
        });

        // declare and initialize distance array
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);

        // put the source into priority queue and set its distance to 0
        dist[src] = 0;
        st.add(new int[]{0, src});

        while (!st.isEmpty()) {
            int[] top = st.pollFirst();
            int currDist = top[0];
            int currNode = top[1];

            for (int[] neighbor : adj.get(currNode)) {
                int adjNode = neighbor[0];
                int edgeWeight = neighbor[1];

                if ((currDist + edgeWeight) < dist[adjNode]) {
                    // remove the node from the set
                    if (dist[adjNode] != (int) 1e9) {
                        st.remove(new int[]{dist[adjNode], adjNode});
                    }

                    // update the distance & add it to set
                    dist[adjNode] = currDist + edgeWeight;
                    st.add(new int[]{dist[adjNode], adjNode});
                }
            }
        }

        // set all unreachable nodes to -1
        IntStream.range(0, V).forEach(i -> {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        });

        return dist;
    }

    public static void main(String[] args) {
        var obj = new DijkstraUsingSet();

        int[][] edges = {
                {0, 1, 4},
                {0, 2, 8},
                {1, 4, 6},
                {2, 3, 2},
                {3, 4, 10}
        };
        int V = edges.length;
        int source = 0;

        int[] shortestPath = obj.dijkstra(V, edges, source);
        System.out.println(Arrays.toString(shortestPath));
    }
}
