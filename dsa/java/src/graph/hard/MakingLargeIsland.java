package graph.hard;

import java.util.*;
/**
 * @author Ripan Baidya
 * @date 16-08-2025
 *
 * You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
 * Return the size of the largest island in grid after applying this operation. An island  is
 * a 4-directionally connected group of 1s.
 *
 * Example:
 *
 * Input: grid = [[1,0],[0,1]]
 * Output: 3
 * Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
 */
class DSU {
    int[] parent;
    int[] size;

    public DSU(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findParent(parent[node]);
    }

    public void unionBySize(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv)
            return;
        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}
public class MakingLargeIsland {
    private boolean isValid(int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    /**
     * Find the largest island by changing 0's to 1's while ensuring that all
     * 1's are connected.
     *
     * @param grid the grid of 0's and 1's
     * @return the size of the largest island
     */
    public int largestIsland(int[][] grid) {
        int n = grid.length; // number of rows
        DSU ds = new DSU(n * n); // union-find data structure

        int[] delRow = { -1, 0, 1, 0 }; // delta row indices
        int[] delCol = { 0, 1, 0, -1 }; // delta col indices

        // Connect all adjacent 1's
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0)
                    continue; // skip 0's
                else {
                    // Union adjacent 1's
                    for (int i = 0; i < 4; i++) {
                        int nrow = row + delRow[i];
                        int ncol = col + delCol[i];

                        if (isValid(nrow, ncol, n) && grid[nrow][ncol] == 1) {
                            int curNodeId = row * n + col;
                            int adjNodeId = nrow * n + ncol;

                            ds.unionBySize(curNodeId, adjNodeId);
                        }
                    }
                }
            }
        }

        int mxSize = 0; // maximum island size
        // For each 0, try to change it to 1 and find size
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                HashSet<Integer> nodes = new HashSet<>(); // set of node ids
                int curSize = 0; // current island size

                if (grid[row][col] == 1)
                    continue; // skip 1's
                else {
                    // Union adjacent 1's
                    for (int i = 0; i < 4; i++) {
                        int nrow = row + delRow[i];
                        int ncol = col + delCol[i];

                        if (isValid(nrow, ncol, n) && grid[nrow][ncol] == 1) {
                            int curNodeId = row * n + col;
                            int adjNodeId = nrow * n + ncol;

                            if (!nodes.contains(ds.findParent(adjNodeId))) {
                                curSize += ds.size[ds.findParent(adjNodeId)];
                                nodes.add(ds.findParent(adjNodeId));
                            }
                        }
                    }
                }
                mxSize = Math.max(mxSize, curSize + 1);
            }
        }

        // Edge case: All 1's
        for (int cell = 0; cell < n * n; cell++) {
            mxSize = Math.max(mxSize, ds.size[ds.findParent(cell)]);
        }

        return mxSize;
    }

    public static void main(String[] args) {
        var obj = new MakingLargeIsland();

        int[][] grid = {{1, 0}, {0, 1}};
        int maxIslandSize = obj.largestIsland(grid);
        System.out.println("Maximum island size: " + maxIslandSize);
    }
}
