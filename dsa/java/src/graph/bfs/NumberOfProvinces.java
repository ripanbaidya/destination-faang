package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ripan Baidya
 * @date 04-08-2025
 *
 * There are n cities. Some of them are connected, while some are not. If city a is connected
 * directly with city b, and city b is connected directly with city c, then city a is connected
 * indirectly with city c.
 * A province is a group of directly or indirectly connected cities and no other cities outside
 * of the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the
 * jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 *
 * time: O(V + 2E)
 * space: O(V), visited array and queue
 */
public class NumberOfProvinces {
    private void bfs(int node, int[][] isConnected, boolean[] vis) {
        // mark the source node as visited
        vis[node] = true;

        // declare a queue and put source node to it
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()) {
            int u = q.poll();

            for(int v = 0; v < isConnected.length; v ++) {
                if(isConnected[u][v] == 1 && !vis[v]) {
                    vis[v] = true;
                    q.offer(v);
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length; // number of vertices
        boolean[] vis = new boolean[V]; // visited array
        int numberOfComponents = 0; // number of component

        for(int i = 0; i < V; i ++)
            if(!vis[i]) {
                bfs(i, isConnected, vis);
                numberOfComponents ++; // count component
            }

        return numberOfComponents;
    }
}
