package graph.hard;

/**
 * @author Ripan Baidya
 * @date 15-08-2025
 *
 * There are n cities. Some of them are connected, while some are not. If city an  is
 * connected directly with city b, and city b is connected directly with city c, then
 * city an is connected indirectly with city c.
 * A province is a group of directly or indirectly connected cities and no other cities
 * outside the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1,if the ith city
 * and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
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
public class NumberOfProvincesUsingDisjointSet {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);
        int components = 0; // number of provinces

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (isConnected[i][j] == 1
                        && dsu.findParent(i) != dsu.findParent(j))
                    dsu.union(i, j);
            }
        }

        // counting the number of components
        for (int i = 0; i < n; i++) {
            if (dsu.findParent(i) == i) {
                components++;
            }
        }

        return components;
    }
}
