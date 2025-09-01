package graph.hard;

import java.util.*;
/**
 * @author Ripan Baidya
 * @date 15-08-2025
 *
 * You are given a n,m which means the row and column of the 2D matrix and an array of  size
 * k denoting the number of operations. Matrix elements is 0 if there is water or 1 if there
 * is land.Originally, the 2D matrix is all 0 which means there is no land in the matrix.The
 * array has k operator(s) and each operator has two integer A[i][0], A[i][1] means that you
 * can change the cell matrix[A[i][0]][A[i][1]] from sea to island. Return how many island
 * are there in the matrix after each operation.You need to return an array of size k.
 * Note : An island means group of 1s such that they share a common side.
 *
 * Input: n = 4, m = 5, k = 4, A = {{1,1},{0,1},{3,3},{3,4}}
 * Output: 1 1 2 2
 */
public class NumberOfIslandsII {
    // check whether the current row and column is valid or invalid
    private boolean isValid(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        DSU ds = new DSU(n*m);
        List<Integer> ans = new ArrayList<>();
        int[][] vis = new int[n][m];
        int cnt = 0; // count island

        for (int[] it : operators) {
            int currRow = it[0];
            int currCol = it[1];

            if (vis[currRow][currCol] == 1) {
                ans.add(cnt);
                continue;
            }
            else {
                vis[currRow][currCol] = 1;
                cnt ++;

                // delta row & col
                int currNodeId = (currRow * m) + currCol;
                int[] delRow = {-1, 0, 1, 0};
                int[] delCol = {0, 1, 0, -1};

                // check all four direction
                for (int i = 0; i < 4; i ++) {
                    int adjRow = currRow + delRow[i];
                    int adjCol = currCol + delCol[i];

                    if (isValid(adjRow, adjCol, n, m) && vis[adjRow][adjCol] == 1) {
                        // need to check whether currNode & adjNode belong
                        // to the same component
                        int adjNodeId = (adjRow * m) + adjCol;

                        if (ds.findParent(currNodeId) != ds.findParent(adjNodeId)) {
                            ds.unionBySize(currNodeId, adjNodeId);
                            cnt --;
                        }
                    }
                }

                ans.add(cnt); // current component
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        NumberOfIslandsII obj = new NumberOfIslandsII();

        int n = 4, m = 5, k = 4;
        int[][]A = {{1,1},{0,1},{3,3},{3,4}};

        List<Integer> islands = obj.numOfIslands(n, m, A);
        System.out.println(islands);
    }
}
