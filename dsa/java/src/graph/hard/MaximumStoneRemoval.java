package graph.hard;

import java.util.*;
/**
 * @author Ripan Baidya
 * @date 16-08-2025
 *
 * Given an 2D array of non-negative integers stones[][] where stones[i] = [xi, yi] represents the
 * location of the ith stone on a 2D plane , the task is to return the maximum possible number  of
 * stones that you can remove.
 * A stone can be removed if it shares either the same row or the same column as another stone that
 * has not been removed.
 * Note: Each coordinate point may have at most one stone.
 *
 * Examples:
 *
 * Input: stones[][] = [[0, 0], [0, 1], [1, 0], [1, 2], [2, 1], [2, 2]]
 * Output:5
 * Explanation:
 * One way to remove 5 stones is as follows:
 * 1. Remove stone [2, 2] because it shares the same row as [2, 1].
 * 2. Remove stone [2, 1] because it shares the same column as [0, 1].
 * 3. Remove stone [1, 2] because it shares the same row as [1, 0].
 * 4. Remove stone [1, 0] because it shares the same column as [0, 0].
 * 5. Remove stone [0, 1] because it shares the same row as [0, 0].
 * Stone [0, 0] cannot be removed since it does not share any row/column with another stone still on
 * the plane.
 */
class DSU {
    int[] parent;
    int[] size;

    public DSU(int n) {
        parent = new int[n+1];
        size = new int[n+1];

        for (int i = 0; i <= n; i ++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findParent(int node){
        if (node == parent[node])
            return node;
        return parent[node] = findParent(parent[node]);
    }
    public void unionBySize(int u, int v) {
        int pv = findParent(u);
        int pu = findParent(v);

        if (pv == pu) return;
        if (size[pv] < size[pu]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }
}
public class MaximumStoneRemoval {
    int maxRemove(int[][] stones, int n) {
        // Find the maximum row and column values in the stones array
        int maxRow = 0, maxCol = 0;
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        // Create a DisjointSet to represent the plane and keep track of the union of stones
        DSU ds = new DSU(maxRow + maxCol + 2);
        // HashSet to keep track of the nodes that appear in the stones array
        HashSet<Integer> nodes = new HashSet<>();

        // Union the stones with the same row or column in the DisjointSet
        for (int[] stone : stones) {
            int u = stone[0];
            int v = stone[1] + maxRow + 1;
            ds.unionBySize(u, v);
            nodes.add(u);
            nodes.add(v);
        }

        // Count the number of connected components in the DisjointSet
        int cntComp = 0;
        for (int node : nodes) {
            if (ds.findParent(node) == node) {
                cntComp++;
            }
        }

        // Return the maximum number of stones that can be removed
        return n - cntComp;
    }

    public static void main(String[] args) {
        var obj = new MaximumStoneRemoval();
        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        int n = 6;

        int maxRemoval = obj.maxRemove(stones, n);
        System.out.println("Maximum number of stones that can be removed: " + maxRemoval);
    }
}
