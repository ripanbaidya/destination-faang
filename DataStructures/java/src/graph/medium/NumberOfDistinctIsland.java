package graph.medium;

import java.util.*;
/**
 * @author Ripan Baidya
 * @date 2025-08-23
 *
 * Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct
 * islands where a group of connected 1s (horizontally or vertically) forms an island.
 * Two islands are considered to be distinct if and only if one island is not equal to
 * another (not rotated or reflected).
 *
 * Example:
 *
 * Input:
 * grid[][] = [[1, 1, 0, 0, 0],
 *             [1, 1, 0, 0, 0],
 *             [0, 0, 0, 1, 1],
 *             [0, 0, 0, 1, 1]]
 * Output: 1
 * Explanation:
 * grid[][] = [[1, 1, 0, 0, 0],
 *             [1, 1, 0, 0, 0],
 *             [0, 0, 0, 1, 1],
 *             [0, 0, 0, 1, 1]]
 * Same colored islands are equal. We have 2 equal islands, so we have only 1 distinct island.
 */
public class NumberOfDistinctIsland {
    private boolean isValid(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
    private void dfs(int row, int col, int[][] grid, int[][] vis,
                     List<String> cord, int baseRow, int baseCol) {
        int n = grid.length;
        int m = grid[0].length;

        vis[row][col] = 1;
        // serialize coordinates into String
        cord.add((row-baseRow) + "" + (col-baseCol));

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i ++) {
            int adjRow = row + delRow[i];
            int adjCol = col + delCol[i];

            if (isValid(adjRow, adjCol, n, m)
                    && vis[adjRow][adjCol] == 0 && grid[adjRow][adjCol] == 1) {
                dfs(adjRow, adjCol, grid, vis, cord, baseRow, baseCol);
            }
        }
    }
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        HashSet<List<String>> set = new HashSet<>();

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    List<String> cord = new ArrayList<>(); // co-ordinates {row, col}
                    dfs(i, j, grid, vis, cord, i, j);
                    set.add(cord);
                }
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        var obj = new NumberOfDistinctIsland();
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };

        int distinctIsland = obj.countDistinctIslands(grid);
        System.out.println("Number of distinct islands are: "+ distinctIsland);
    }
}
