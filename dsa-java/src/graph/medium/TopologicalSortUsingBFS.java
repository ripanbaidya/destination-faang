package graph.medium;

import java.util.*;

/**
 * @author Ripan Baidya
 * @date 01-08-2025
 *
 * Given a Directed Acyclic Graph (DAG) of V (0 to V-1) vertices and E edges represented as a 2D list of edges[][],
 * where each entry edges[i] = [u, v] denotes a directed edge u -> v. Return the topological sort for the given graph.
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed
 * edge u -> v, vertex u comes before v in the ordering.
 * Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological
 * sort is correct then the output will be true else false.
 *
 * Input: V = 6, E = 6, edges[][] = [[1, 3], [2, 3], [4, 1], [4, 0], [5, 0], [5,2]]
 * Output: true
 * Explanation: The output true denotes that the order is valid. Few valid Topological orders for the graph are:
 * [4, 5, 0, 1, 2, 3]
 * [5, 2, 4, 0, 1, 3]
 *
 * time: O(V + E)
 * space: O(V)
 */

// We will solve this problem using Breadth First Search (BFS).
// Fromally known as kahn's algorithm
public class TopologicalSortUsingBFS {
    // Convert the edge list to an adjacency list representation
    private static List<Integer>[] constructAdj(int V, int[][] edges) {
        List<Integer>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i ++) adj[i] = new ArrayList<>();

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v); // directed
        }

        return adj;
    }

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<Integer>[] adj = constructAdj(V, edges);

        // Create an in-degree array to store the in-degree of each vertex
        int[] indegree = new int[V];

        // count the in-degree of each vertex
        for (int i = 0; i < V; i ++) {
            for (int adjNode : adj[i]) {
                indegree[adjNode] ++;
            }
        }

        // create a list to store the topo sort
        ArrayList<Integer> topo = new ArrayList<>();

        // A queue for BFS
        Queue<Integer> q = new LinkedList<>();

        // If the in-degree of a vertex is 0, add it to the queue
        for (int i = 0; i < V; i ++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // BFS
        while (!q.isEmpty()) {
            int node = q.poll(); // dequeue
            topo.add(node); // add the node to the topo array

            for (int adjNode : adj[node]) {
                // decrease the in-degree of the adjacent node
                indegree[adjNode] --;

                // if the in-degree of the adjacent node becomes 0, add it to the queue
                if (indegree[adjNode] == 0) {
                    q.offer(adjNode);
                }
            }
        }

        return topo;
    }

    public static void main(String[] args) {
        TopologicalSortUsingBFS obj = new TopologicalSortUsingBFS();

        int V = 6, E = 6;
        int[][] edges = {{1, 3}, {2, 3}, {4, 1}, {4, 0}, {5, 0}, {5, 2}};

        System.out.println(obj.topoSort(V, edges));
    }
}
