package graph.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges,
 * check whether it contains any cycle or not. The graph is represented as a 2D
 * vector edges[][], where each entry edges[i] = [u, v] denotes an edge from
 * vertices u to v.
 *
 * Input: V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 0], [2, 3]]
 * Output: true
 * Explanation: The diagram clearly shows a cycle 0 → 2 → 0
 */

/**
 * Here, we use BFS to detect cycle in a directed graph. usually the kann's algorithms,
 * which used to find topological sort of a graph. as we know that topological sort is
 * applicable only on DAG (Directed Acyclic Graph). So we if a graph has cycle then topological
 * sort will not be possible. and this is the intuition behind solving this proble using BFS.
 *
 * time: O(V + E)
 * space: O(V + E)
 */
public class DetectCycleInDirectedGraphUsingBFS {
    // Convert the edge list to an adjacency list representation
    private static List<Integer>[] constructAdj(int V, int[][] edges) {
        List<Integer>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i ++) adj[i] = new ArrayList<>();

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v); // directed edge
        }

        return adj;
    }

    public boolean isCyclic(int V, int[][] edges) {
        List<Integer>[] adj = constructAdj(V, edges);

        // array to store the in-degree of each vertex
        int[] indegree = new int[V];

        // count the in-degree of each vertex
        for (int i = 0; i < V; i ++) {
            for (int adjNode : adj[i]) {
                indegree[adjNode] ++;
            }
        }

        int count = 0; // count element for topologically sorted element
        Queue<Integer> q = new LinkedList<>();

        // Iterate over the indegreeree array
        // and put all the element into queue which has indegree 0
        for (int i = 0; i < V; i ++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // bfs
        while (!q.isEmpty()) {
            int node = q.poll();
            count ++;

            for (int adjNode : adj[node]) {
                indegree[adjNode] --;

                if (indegree[adjNode] == 0) {
                    q.offer(adjNode);
                }
            }
        }

        // count represent the number of topologically sorted element
        // if count is equal to V then there is no cycle
        // else there is a cycle
        return count == V ? false : true;
    }

    public static void main(String[] args) {
        DetectCycleInDirectedGraphUsingBFS obj = new DetectCycleInDirectedGraphUsingBFS();

        int V = 5;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}};

        boolean isCycle = obj.isCyclic(V, edges);
        System.out.println("Does the graph contain a cycle? " + isCycle);
    }
}

