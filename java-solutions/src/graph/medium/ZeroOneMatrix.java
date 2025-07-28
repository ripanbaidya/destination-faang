package graph.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * The distance between two cells sharing a common edge is 1.
 *
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 */
public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] vis = new int[n][m]; // visited array
        int[][] dist = new int[n][m]; // resultant distance matrix
        Queue<int[] > q = new LinkedList<>(); // {row, col, unit}

        // Initialize the queue with all cells that are 0 and mark them as visited
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                if(mat[i][j] == 0) {
                    vis[i][j] = 1; // visited
                    q.offer(new int[]{i, j, 0});
                }
            }
        }

        // delta arrays for 4 directions (up, right, down, left)
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            int[] curr = q.poll(); // {row, col, unit}

            int row = curr[0];
            int col = curr[1];
            int unit = curr[2];

            dist[row][col] = unit; // update distance

            for(int i = 0; i < 4; i ++) {
                // calculate neighbours row and column
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && mat[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {

                    vis[nrow][ncol] = 1; // visited
                    q.offer(new int[]{nrow, ncol, unit+1});
                }
            }
        }
        return dist;
    }
}
