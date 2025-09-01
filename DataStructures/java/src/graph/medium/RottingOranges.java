package graph.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 *
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 */
public class RottingOranges {
    private boolean isValidCell(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int cntFreshOranges = 0; // count of fresh oranges
        int cntFreshToRotten = 0; // count of fresh oranges that becomes rotten
        int minTime = 0; // minimum time to rotten all fresh oranges

        int[][] vis = new int[n][m];
        Queue<int[]> q = new LinkedList<>(); // {row, col, time}

        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                if(grid[i][j] == 2) {
                    vis[i][j] = 1;
                    q.offer(new int[]{i, j, 0});
                } else if(grid[i][j] == 1){
                    cntFreshOranges ++;
                }
            }
        }

        // up, down, left, right
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        // bfs
        while (!q.isEmpty()) {
            int[] top = q.poll();
            int currRow = top[0];
            int currCol = top[1];
            int currTime = top[2];

            minTime = currTime; // updating the minimum time

            for (int i = 0; i < 4; i ++) {
                int adjRow = currRow + delRow[i];
                int adjCol = currCol + delCol[i];

                if (isValidCell(adjRow, adjCol, n, m)
                        && grid[adjRow][adjCol] == 1 && vis[adjRow][adjCol] == 0) {
                    q.offer(new int[]{adjRow, adjCol, currTime +1});
                    vis[adjRow][adjCol] = 1;
                    cntFreshToRotten ++;
                }
            }
        }

        if (cntFreshOranges != cntFreshToRotten)
            return -1; // not all fresh oranges become rotten in given time

        return minTime;
    }

    public static void main(String[] args) {
        var obj = new RottingOranges();

        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int minimumTime = obj.orangesRotting(grid);

        System.out.println("Minimum time to rotten all fresh oranges: " + minimumTime);
    }
}
