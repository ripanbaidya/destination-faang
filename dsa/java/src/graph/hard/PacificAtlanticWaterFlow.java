package graph.hard;

/**
 * @author Ripan Baidya
 * @date 11-08-2025
 *
 * You are given a matrix mat[][] of dimensions n x m, where mat[i][j] represents the height
 * of a cell in a rectangular grid island. The Pacific Ocean touches the island's left  and
 * top borders, and the Atlantic Ocean touches the island's right and bottom borders.
 * Rainwater can flow from a cell to its neighbouring cells in the directions of North,South,
 * East, and West, but only if the neighbouring cell has a height less than or equal  to the
 * current cell's height.
 * The task is to determine all coordinates(x, y)such that water can flow from the cell(x, y)
 * to both the Pacific Ocean and the Atlantic Ocean.  Water can flow from any adjacent  cell
 * directly into an ocean.
 *
 * Examples:
 *
 * Input: mat[][] = [[1, 2, 2, 3, 5],
 *                 [3, 2, 3, 4, 4],
 *                 [2, 4, 5, 3, 1],
 *                 [6, 7, 1, 4, 5],
 *                 [5, 1, 1, 2, 4]]
 * Output: 7
 * Explanation: In the given matrix, there are 7 coordinates through which the water can flow to
 * both the Oceans. They are  (0, 4), (1, 3), (1, 4), (2, 2), (3, 0), (3, 1), and (4, 0).
 *
 * time complexity: O(n * m)
 * space complexity: O(n * m)
 */
public class PacificAtlanticWaterFlow {
    private void dfs(int row, int col, int[][] mat, int[][] vis) {
        // row and col
        int n = mat.length;
        int m = mat[0].length;

        // mark the current cell as visited
        vis[row][col] = 1;

        // delta arrays to move in 4 directions
        // north, east, south, west
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i ++) {
            // neighbours row & col
            int neighbourRow = row + delRow[i];
            int neighbourCol = col + delCol[i];

            if (neighbourRow >= 0 && neighbourRow < n && neighbourCol >= 0 && neighbourCol < m
                    && vis[neighbourRow][neighbourCol] == 0
                    && mat[neighbourRow][neighbourCol] >= mat[row][col]) {
                vis[neighbourRow][neighbourCol] = 1;
                dfs(neighbourRow, neighbourCol, mat, vis);
            }
        }
    }
    public int countCoordinates(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // pacific & atlantic arrays which will store
        // which is the last coordinate that can reach the ocean
        int[][] pacific = new int[n][m];
        int[][] atlantic = new int[n][m];

        // Pacific ocean: top & left
        for (int c = 0; c < m; c ++) dfs(0, c, mat, pacific);
        for (int r = 0; r < n; r ++) dfs(r, 0, mat, pacific);

        // Atlantic ocean: bottom & right
        for (int c = 0; c < m; c ++) dfs(n-1, c, mat, atlantic);
        for (int r = 0; r < n; r ++) dfs(r, m-1, mat, atlantic);

        // count the co-ordinates from which water can flow to
        // both pacific and atlantic ocean
        int countCoordinates = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1)
                    countCoordinates ++;
            }
        }

        return countCoordinates;
    }

    public static void main(String[] args) {
        var obj = new PacificAtlanticWaterFlow();
        int[][] mat = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        int coordinates = obj.countCoordinates(mat);
        System.out.println("Number of coordinates: " + coordinates);
    }
}
