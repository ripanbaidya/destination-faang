package graph.dfs;

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
    public void dfs(int node, int[][] isConnected, boolean[] visit) {
        visit[node] = true;

        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visit[i]) {
                dfs(i, isConnected, visit);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        int numberOfComponents = 0;
        boolean[] visit = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visit[i]) {
                numberOfComponents++;
                dfs(i, isConnected, visit);
            }
        }

        return numberOfComponents;
    }
}
