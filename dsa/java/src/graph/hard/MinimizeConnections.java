package graph.hard;

/**
 * @author Ripan Baidya
 * @date 15-08-2025
 *
 * Given an integer N, denoting the number of computers connected by cables forming a network
 * and a 2d array connections[][], with each row (i, j) representing a connection between ith
 * and jth computer, the task is to connect all the computers either directly or   indirectly
 * by removing any of the given connections and connecting two disconnected computers.
 * If its not possible to connect all the computers, return -1. Otherwise, return the minimum
 * number of such operations required.
 *
 * Example:
 *
 * Input: N = 4, connections[][] = {{0, 1}, {0, 2}, {1, 2}}
 * Output: 1
 */
class DSU {
    int[] rank;
    int[] parent;
    public DSU(int n) {
        rank = new int[n+1];
        parent = new int[n+1];

        for (int i = 0; i <= n; i ++) {
            rank[i] = 0;
            parent[i] = i;
        }
    }

    public int findParent(int n) {
        if (n == parent[n])
            return n;

        return parent[n] = findParent(parent[n]);
    }

    public void union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv) return;
        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu] ++;
        }
    }
}
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
                dsu.union(u, v);
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
