package graph.medium;

/**
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
 * A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking
 * off the boundary of the grid.
 * Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
 *
 * Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 3
 * Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
 */
public class NumberOfEnclaves {
    // dfs to mark all the land cells that are connected to the boundary
    // then count the remaining land cells that are not visited
    private void dfs(int row, int col, int[][] grid, int[][] vis) {
        int m = grid.length; // row
        int n = grid[0].length; // col

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        vis[row][col] = 1; // mark cell as visited

        for(int i = 0; i < 4; i ++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
                    && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, grid, vis);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length; // row
        int n = grid[0].length; // col

        // visited array to mark the cells that are connected to the boundary
        int[][] vis = new int[m][n];

        for(int i = 0; i < m; i ++) {
            // first column
            if(grid[i][0] == 1 && vis[i][0] == 0) dfs(i, 0, grid, vis);

            // last column
            if(grid[i][n-1] == 1 && vis[i][n-1] == 0) dfs(i, n-1, grid, vis);
        }
        for(int j = 0; j < n; j ++) {
            // first row
            if(grid[0][j] == 1 && vis[0][j] == 0) dfs(0, j, grid, vis);

            // last row
            if(grid[m-1][j] == 1 && vis[m-1][j] == 0) dfs(m-1, j, grid, vis);
        }

        int count = 0;
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(grid[i][j] == 1 && vis[i][j] == 0)
                    count ++;
            }
        }

        // count the number of land cells that are not visited
        return count;
    }
}
