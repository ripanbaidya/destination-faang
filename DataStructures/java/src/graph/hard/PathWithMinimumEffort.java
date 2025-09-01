package graph.hard;

import java.util.*;
/**
 * @author Ripan Baidya
 * @date 06-08-2025
 *
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size
 * rows x columns, where heights[row][col] represents the height of cell (row, col). You are
 * situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell,
 * (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish
 * to find a route that requires the minimum effort.
 * A route's effort is the maximum absolute difference in heights between two consecutive cells
 * of the route.
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
 *
 * Example:
 * Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
 * Output: 2
 * Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
 * This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
 */
public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        // row & col
        int n = heights.length;
        int m = heights[0].length;

        // declare and initialize distance array with infinity
        int[][] diff = new int[n][m];
        for (int i = 0; i < n; i ++) {
            Arrays.fill(diff[i], (int) 1e9);
        }

        // each element will be {distance, node}
        // sort based on distance, if equal then based on node
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return (a[0] != b[0]) ? Integer.compare(a[0], b[0])
                    : Integer.compare(a[1], b[1]);
        });

        // put the source into priority queue and set its distance to 0
        diff[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        // delta row & column for 4 directions
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        // BFS
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int currDiff = top[0];
            int currRow = top[1];
            int currCol = top[2];

            // when we reach the at the destination
            if (currRow == n-1 && currCol == m-1){
                return currDiff;
            }

            for (int i = 0; i < 4; i ++) {
                // neighbours row & col
                int nrow = currRow + delRow[i];
                int ncol = currCol + delCol[i];

                // check if the neighbour is valid
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    int newEffort = Math.max(Math.abs(heights[nrow][ncol] - heights[currRow][currCol]), currDiff);

                    // only update the distance if it is less
                    if (newEffort < diff[nrow][ncol]) {
                        diff[nrow][ncol] = newEffort;
                        pq.offer(new int[]{diff[nrow][ncol], nrow, ncol});
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        var obj = new PathWithMinimumEffort();

        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}}; // 2
        System.out.println(obj.minimumEffortPath(heights));
    }
}
