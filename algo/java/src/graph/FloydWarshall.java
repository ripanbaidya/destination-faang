package graph;

/**
 * @author Ripan Baidya
 * @date 09-08-2025
 *
 * You are given an weighted directed graph, represented by an adjacency matrix, dist[][] of size
 * n x n, where dist[i][j] represents the weight of the edge from node i to node j. If there is no
 * direct edge, dist[i][j] is set to a large value (i.e., 1e8 or INF) to represent infinity.
 * The graph may contain negative edge weights, but it does not contain any negative weight cycles.
 * Your task is to find the shortest distance between every pair of nodes i and j in the graph.
 * Note: Modify the distances for every pair in place.
 *
 * Examples :
 *
 * Input: dist[][] =
 * [[0, 4, INF, 5, INF],[INF, 0, 1, INF, 6],[2, INF, 0, 3, INF],[INF, INF, 1, 0, 2],[1, INF, INF, 4, 0]]
 * Output: [[0, 4, 5, 5, 7], [3, 0, 1, 4, 6], [2, 6, 0, 3, 5], [3, 7, 1, 0, 2], [1, 5, 5, 4, 0]]
 */
public class FloydWarshall {
    final int INF = (int) 1e8;
    public void floydWarshall(int[][] dist) {
        int V = dist.length;

        // Add all vertices one by one to
        // the set of intermediate vertices.
        for (int k = 0; k < V; k++) {

            // Pick all vertices as source one by one
            for (int i = 0; i < V; i++) {

                // Pick all vertices as destination
                // for the above picked source
                for (int j = 0; j < V; j++) {

                    // shortest path from
                    // i to j
                    if(dist[i][k] != 1e8 && dist[k][j]!= 1e8)
                        dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        var obj = new FloydWarshall();
        int INF = 100000000;

        int[][] dist = { { 0, 4, INF, 5, INF },
                { INF, 0, 1, INF, 6 },
                { 2, INF, 0, 3, INF },
                { INF, INF, 1, 0, 2 },
                { 1, INF, INF, 4, 0 } };

        obj.floydWarshall(dist);

        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
