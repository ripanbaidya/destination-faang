package graph.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary grid of n*m. Find the distance of the nearest 1 in the grid for each cell.
 * The distance is calculated as |i1  - i2| + |j1 - j2|, where i1, j1 are the row number and
 * column number of the current cell, and i2, j2 are the row number and column number of the
 * nearest cell having value 1. There should be at-least one 1 in the grid.
 *
 * Input: grid = [[0,1,1,0], [1,1,0,0], [0,0,1,1]]
 * Output: [[1,0,0,1], [0,0,1,1], [1,1,0,0]]
 */
public class ZeroOneMatrix2 {
    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<int[] > q = new LinkedList<>();

        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                if(grid[i][j] == 1) {
                    vis[i][j] = 1;
                    q.offer(new int[]{i, j, 0});
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            int[] temp = q.poll();

            int row = temp[0];
            int col = temp[1];
            int unit = temp[2];

            dist[row][col] = unit;

            for(int i = 0; i < 4; i ++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && grid[nrow][ncol] == 0 && vis[nrow][ncol] == 0) {

                    vis[nrow][ncol] = 1;
                    q.offer(new int[]{nrow, ncol, unit+1});
                }
            }
        }

        return dist;
    }
}
