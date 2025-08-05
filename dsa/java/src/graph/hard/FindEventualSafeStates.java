package graph.hard;

import java.util.*;

/**
 * @author Ripan Baidya
 * @date 01-08-2025
 *
 * There is a directed graph of n nodes with each node labeled from 0 to n - 1.
 * The graph is represented by a 0-indexed 2D integer array graph where graph[i]
 * is an integer array of nodes adjacent to node i, meaning there is an edge from
 * node i to each node in graph[i].
 *
 * A node is a terminal node if there are no outgoing edges. A node is a safe node
 * if every possible path starting from that node leads to a terminal node (or another
 * safe node).
 *
 * Return an array containing all the safe nodes of the graph. The answer should be
 * sorted in ascending order.
 *
 * Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
 * Output: [4]
 * Explanation:
 * Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
 */

// solve using bfs - kahn's algorithm
public class FindEventualSafeStates {
    // convert graph to reverse graph, while changing edge direction
    public List<Integer>[] convertToReverseGraph(int[][] graph) {
        int V = graph.length;
        List<Integer>[] adj = new ArrayList[V];

        for(int i = 0; i < V; i ++) {
            adj[i] = new ArrayList<>();
        }

        for (int u = 0; u < V; u ++) {
            for (int v : graph[u]) {
                adj[v].add(u);
            }
        }

        return adj;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;

        // grpah with edge in reversed direction
        List<Integer>[] adjList = convertToReverseGraph(graph);
        int[] indegree = new int[V];

        // count indegree of each node
        for (int i = 0; i < V; i ++) {
            for (int adjNode : adjList[i]) {
                indegree[adjNode] ++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // add element to queue, which has indegree 0
        for (int i = 0; i < V; i ++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);

            for (int adjNode : adjList[node]) {
                indegree[adjNode] --;

                if(indegree[adjNode] == 0) {
                    q.offer(adjNode);
                }
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }

    public static void main(String[] args) {
        FindEventualSafeStates obj = new FindEventualSafeStates();

        int[][] graph = {{1,2,3,4},{1,2},{3,4},{0,4},{}};
        System.out.println(obj.eventualSafeNodes(graph));
    }
}
