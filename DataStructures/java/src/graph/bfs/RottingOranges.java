package graph.bfs;

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
    class Triplet {
        int row, col, time;

        public Triplet(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int countFreshOrange = 0;
        int minTime = 0, orangeRotten = 0;

        int[][] vis = new int[n][m];
        Queue<Triplet> q = new LinkedList<>();

        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                if(grid[i][j] == 2) {
                    vis[i][j] = 2;
                    q.offer(new Triplet(i, j, 0));
                } else if(grid[i][j] == 1){
                    countFreshOrange ++;
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            Triplet curr = q.poll();

            int row = curr.row;
            int col = curr.col;
            int time = curr.time;

            minTime = Math.max(minTime, time);

            for(int i = 0; i < 4; i ++) {
                int currRow = row + drow[i];
                int currCol = col + dcol[i];

                if(currRow >= 0 && currRow < n && currCol >= 0 && currCol < m
                        && grid[currRow][currCol] == 1 && vis[currRow][currCol] != 2) {

                    q.offer(new Triplet(currRow, currCol, time+1));
                    vis[currRow][currCol] = 2; // rotten
                    orangeRotten ++;
                }
            }
        }

        return orangeRotten != countFreshOrange ? -1 : minTime;

    }
}
