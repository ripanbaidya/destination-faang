package graph.hard;

import java.util.Arrays;

/**
 * @author Ripan Baidya
 * @date 14-08-2025
 *
 * Given a weighted, undirected, and connected graph with V vertices and E edges, the  task
 * is to find the sum of the weights of the edges in the Minimum Spanning Tree (MST) of the
 * graph using Kruskal's Algorithm. The graph is represented as an edge list edges[][],where
 * edges[i] = [u, v, w] denotes an undirected edge between u and v with weight w.
 *
 * Input: V = 3, E = 3, edges[][] = [[0, 1, 5], [1, 2, 3], [0, 2, 1]]
 * Output: 4
 *
 * time: O(ElogE+E⋅α(V)) ~ O(ElogE)
 * space: O(V+E)
 */

class DSU {
    int[] parent;
    int[] rank;

    // constructor
    public DSU(int n) {
        parent = new int[n+1];
        rank = new int[n+1];

        for (int i = 0; i <= n; i ++) {
            rank[i] = 0;
            parent[i] = i;
        }
    }

    // find parent
    public int findParent(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findParent(parent[node]);
    }

    // union by rank
    public void union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv) return;

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pv] < rank[pu]) {
            parent[pv] = pu;
        } else {
            parent[pu] = pv;
            rank[pv] ++;
        }
    }
}

public class MinimumSpanningTreeKruskalsAlgorithm {
    int kruskalsMST(int V, int[][] edges) {
        DSU dsu = new DSU(V);

        // sort edges based on weight
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        int mst = 0;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];

            if (dsu.findParent(u) != dsu.findParent(v)) {
                dsu.union(u, v);
                mst += wt;
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        var obj = new MinimumSpanningTreeKruskalsAlgorithm();

        int V = 3;
        int[][] edges = {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}}; // MST = 4

        int mst = obj.kruskalsMST(V, edges);
        System.out.println(mst);
    }
}
