#include <bits/stdc++.h>

using namespace std;

/**
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
class Solution
{
public:
    const int INF = (int)1e8;

    void floydWarshall(int **dist, int V)
    {
        // Add all vertices one by one to
        // the set of intermediate vertices.
        for (int k = 0; k < V; k++)
        {

            // Pick all vertices as source one by one
            for (int i = 0; i < V; i++)
            {

                // Pick all vertices as destination
                // for the above picked source
                for (int j = 0; j < V; j++)
                {

                    // shortest path from
                    // i to j
                    if (dist[i][k] != INF && dist[k][j] != INF)
                        dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    void printMatrix(int **dist, int V)
    {
        for (int i = 0; i < V; i++)
        {
            for (int j = 0; j < V; j++)
            {
                cout << dist[i][j] << " ";
            }
            cout << endl;
        }
    }
};

int main()
{
    Solution obj;
    int INF = 100000000;

    int V = 5;
    int **dist = new int *[V];
    for (int i = 0; i < V; i++)
    {
        dist[i] = new int[V];
    }

    dist[0][0] = 0;
    dist[0][1] = 4;
    dist[0][2] = INF;
    dist[0][3] = 5;
    dist[0][4] = INF;
    dist[1][0] = INF;
    dist[1][1] = 0;
    dist[1][2] = 1;
    dist[1][3] = INF;
    dist[1][4] = 6;
    dist[2][0] = 2;
    dist[2][1] = INF;
    dist[2][2] = 0;
    dist[2][3] = 3;
    dist[2][4] = INF;
    dist[3][0] = INF;
    dist[3][1] = INF;
    dist[3][2] = 1;
    dist[3][3] = 0;
    dist[3][4] = 2;
    dist[4][0] = 1;
    dist[4][1] = INF;
    dist[4][2] = INF;
    dist[4][3] = 4;
    dist[4][4] = 0;

    obj.floydWarshall(dist, V);

    obj.printMatrix(dist, V);

    return 0;
}