package graph.hard;

import java.util.*;

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
