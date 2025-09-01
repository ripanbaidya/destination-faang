package graph.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ripan Baidya
 * @date 06-08-2025
 *
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix.
 * If there is no clear path, return -1.
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the
 * bottom-right cell (i.e., (n - 1, n - 1)) such that:
 * - All the visited cells of the path are 0.
 * - All the adjacent cells of the path are 8-directionally connected (i.e., they are different,
 * and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.
 *
 * Example:
 * Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
 * Output: 4
 */
public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // base cases
        if (grid[0][0] == 1) return -1; // starting will always 0
        if (grid[0][0] == 0 && n == 1) return 1; // has single element, its 0

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i ++) {
            Arrays.fill(dist[i], (int)1e9);
        }

        // each node: {distance, row, col}
        Queue<int[]> q = new LinkedList<>();

        // set source to source distance and put it into queue
        dist[0][0] = 1;
        q.offer(new int[]{1, 0, 0});

        // delta row & column for 8 directions
        int[] delRow = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] delCol = {0, 1, 1, 1, 0, -1, -1, -1};

        // BFS
        while (!q.isEmpty()) {
            int[] top = q.poll();
            int currDist = top[0], currRow = top[1], currCol = top[2];

            for (int i = 0; i < 8; i ++) {
                // neighbours row & col
                int nrow = currRow + delRow[i];
                int ncol = currCol + delCol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n
                        && grid[nrow][ncol] == 0 && dist[nrow][ncol] == (int)1e9) {
                    dist[nrow][ncol] = currDist + 1; // update distance
                    q.offer(new int[]{(currDist+1), nrow, ncol});

                    // destination
                    if (nrow == n-1 && ncol == n-1){
                        return currDist + 1;
                    }
                }
            }
        }

        return -1;
    }
}
