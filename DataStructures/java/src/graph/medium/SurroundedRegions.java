package graph.medium;

/**
 * You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
 * Connect: A cell is connected to adjacent cells horizontally or vertically.
 * Region: To form a region connect every 'O' cell.
 * Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
 * To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.
 *
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 */
public class SurroundedRegions {
    private void dfs(int row, int col, char[][] board, int[][] vis) {
        int m = board.length; // row
        int n = board[0].length; // col

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        vis[row][col] = 1; // mark cell as visited

        for(int i = 0; i < 4; i ++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n
                    && vis[nRow][nCol] == 0 && board[nRow][nCol] == 'O') {
                dfs(nRow, nCol, board, vis);
            }
        }
    }
    public void solve(char[][] board) {
        int m = board.length; // row
        int n = board[0].length; // col

        int[][] vis = new int[m][n];

        // visit all the 'O's that are connected to the boundary
        for(int j = 0; j < n; j ++) {
            // first row
            if(board[0][j] == 'O' && vis[0][j] == 0) dfs(0, j, board, vis);

            // last row
            if(board[m-1][j] == 'O' && vis[m-1][j] == 0) dfs(m-1, j, board, vis);
        }

        for(int i = 0; i < m; i ++) {
            // first column
            if(board[i][0] == 'O' && vis[i][0] == 0) dfs(i, 0, board, vis);

            // last column
            if(board[i][n-1] == 'O' && vis[i][n-1] == 0) dfs(i, n-1, board, vis);
        }

        // Mark all 'O's that are not visited (not connected to boundary) as 'X'
        // and keep the 'O's that are visited (connected to boundary) as 'O'
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(board[i][j] == 'O' && vis[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
