package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image.
 * You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].
 *
 * To perform a flood fill:
 *
 * Begin with the starting pixel and change its color to color.
 * Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel,
 * either horizontally or vertically) and shares the same color as the starting pixel.
 * Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their
 * color if it matches the original color of the starting pixel.
 * The process stops when there are no more adjacent pixels of the original color to update.
 * Return the modified image after performing the flood fill.
 *
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int iniColor = image[sr][sc];

        int[][] res = new int[m][n];
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                res[i][j] = image[i][j];
            }
        }

        Queue<int []> q = new LinkedList<>(); // {row, col}
        int[] drow = {-1, 0, 1, 0}; // row
        int[] dcol = {0, 1, 0, -1}; // col

        q.offer(new int[]{sr, sc});
        res[sr][sc] = color;

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];

            for(int i = 0; i < 4; i ++) {
                int currRow = row + drow[i];
                int currCol = col + dcol[i];

                if(currRow >= 0 && currRow < m && currCol >= 0 && currCol < n
                        && image[currRow][currCol] == iniColor && res[currRow][currCol] != color) {
                    q.offer(new int[]{currRow, currCol});
                    res[currRow][currCol] = color;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 2;

        int[][] result = floodFill.floodFill(image, sr, sc, color);
        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}
