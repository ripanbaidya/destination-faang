package graph.hard;

public class MinimizeConnections {
    public static int minimumConnections(int n, int[][] connections) {
        // base case
        if (connections.length < n - 1) return -1;

        DSU dsu = new DSU(n);
        int cable = 0; // cables we can extract from the network
        int components = 0; // number of components

        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];

            if (dsu.findParent(u) == dsu.findParent(v)) {
                cable++;  // extra cable (cycle)
            } else {
                dsu.unionByRank(u, v);
            }
        }

        // counting the number of components
        for (int i = 0; i < n; i++) {
            if (dsu.findParent(i) == i) {
                components++;
            }
        }

        int cablesRequired = components - 1;
        return cable >= cablesRequired ? cablesRequired : -1;
    }
}
