package graph.hard;

import java.util.*;

public class MakingLargeIsland {
    private boolean isValid(int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    /**
     * Find the largest island by changing 0's to 1's while ensuring that all
     * 1's are connected.
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
