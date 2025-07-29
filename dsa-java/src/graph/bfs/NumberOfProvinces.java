package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Here, we will solve the problem of numberOfComponentsing the number of provinces in a given graph using Breadth First Search (BFS).
 */
public class NumberOfProvinces {
    private void bfs(int node, int[][] isConnected, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(node);
        vis[node] = true;

        while(!q.isEmpty()) {
            node = q.poll();

            for(int j = 0; j < isConnected.length; j ++) {
                if(isConnected[node][j] == 1 && !vis[j]) {
                    q.offer(j);
                    vis[j] = true;
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        boolean[] vis = new boolean[V];
        int numberOfComponents = 0;

        for(int i = 0; i < V; i ++)
            if(!vis[i]) {
                bfs(i, isConnected, vis);
                numberOfComponents ++;
            }

        return numberOfComponents;
    }
}
