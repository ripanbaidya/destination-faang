package graph.medium;

import graph.representation.GraphMain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an undirected graph with V vertices and E edges, represented as a 2D vector edges[][],
 * where each entry edges[i] = [u, v] denotes an edge between vertices u and v, determine whether
 * the graph contains a cycle or not.
 *
 * Input: V = 4, E = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
 * Output: true
 */
public class DetectCycleInUndirectedGraphUsingBFS {
    static class Pair {
        int node;
        int parent;

        public Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
    private List<List<Integer>> convert(int[][] edges, int V) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i ++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }

    private boolean detectCycle(int src, int V, List<List<Integer>> adj, boolean[] vis) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src, -1));
        vis[src] = true;

        while(!q.isEmpty()) {
            Pair curr = q.poll();

            int node = curr.node;
            int parent = curr.parent;

            for(var adjNode : adj.get(node)) {
                if(!vis[adjNode]) {
                    q.offer(new Pair(adjNode, node));
                    vis[adjNode] = true;
                }
                else if (vis[adjNode] && adjNode != parent) {
                    return true; // cycle found
                }
            }
        }

        return false; // no cycle found
    }
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = convert(edges, V);
        boolean[] vis = new boolean[V];

        // check for component
        for(int i = 0; i < V; i ++) {
            if(!vis[i]) {
                if(detectCycle(i, V, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycleInUndirectedGraphUsingBFS obj = new DetectCycleInUndirectedGraphUsingBFS();

        int V = 5;
        boolean isCycle = obj.isCycle(V, GraphMain.buildGraphMatrix());
        System.out.println("Does the graph contain a cycle? " + isCycle);
    }
}
