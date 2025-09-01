package graph.hard;

import java.util.Arrays;

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
