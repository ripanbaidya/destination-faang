package graph.hard;

class DisjointSet {
    int[] parent;
    int[] rank;
    int[] size;

    public DisjointSet(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        size = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }

    public int findParent(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = findParent(parent[node]); // path compression
    }

    // union by rank
    public void unionByRank(int u, int v) {
        // ultimate parent of u and v
        int pu = findParent(u);
        int pv = findParent(v);

        // if they are already in the same set
        if (pu == pv) return;

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pv] < rank[pu]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }

    // union by size
    public void unionBySize(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv) return;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        }
        else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}
public class UnionFind {
    public static void main(String[] args) {
        var ds = new DisjointSet(7);

        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same component");
        } else {
            System.out.println("Different components");
        }

        ds.unionBySize(3, 7);

        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same component");
        } else {
            System.out.println("Different components");
        }
    }
}
