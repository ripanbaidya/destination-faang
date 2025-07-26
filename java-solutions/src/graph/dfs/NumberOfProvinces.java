package graph.dfs;

/**
 * Here, we will solve the problem of counting the number of provinces in a given graph using Depth First Search (DFS).
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
