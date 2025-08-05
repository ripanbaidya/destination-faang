package graph.medium;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid)
 * consisting of 'W's (Water) and 'L's (Land). Find the number of islands.
 * Note: An island is either surrounded by water or the boundary of a grid and is formed by connecting
 * adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.
 *
 * Input: grid[][] = [
 *      ['L', 'L', 'W', 'W', 'W'],
 *      ['W', 'L', 'W', 'W', 'L'],
 *      ['L', 'W', 'W', 'L', 'L'],
 *      ['W', 'W', 'W', 'W', 'W'],
 *      ['L', 'W', 'L', 'L', 'W']
 * ]
 * Output: 4
 */
public class NumberOfIsland {
    void dfs(int row, int col, char[][] grid, int[][] vis) {
        int n = grid.length;
        int m = grid[0].length;


        int[] delRow = {-1, -1, -1, 0, 1, 1, 1, 0}; // row
        int[] delCol = {-1, 0, 1, 1, 1, 0, -1, -1}; // col

        vis[row][col] = 1;

        for (int i = 0; i < 8; i ++) {
            // neighbours row & columns
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                    && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 'L') {
                dfs(nrow, ncol, grid, vis);
            }
        }
    }
    public int countIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0; // number of island

        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if(grid[i][j] == 'L' && vis[i][j] == 0) {
                    dfs(i, j, grid, vis);
                    count ++;
                }
            }
        }

        return count;
    }
}
