#include <bits/stdc++.h>

using namespace std;

/**
 * @author Ripan Baidya
 * @date 09-08-2025
 *
 * Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges,
 * represented by 2d array edges[][], where edges[i]=[u, v, w] represents the edge between
 * the nodes u and v having w edge weight.
 * Find the shortest distance of all the vertices from the source vertex src, and return an
 * array of integers where the ith element denotes the shortest distance between ith node
 * and source vertex src.
 * Note: The Graph is connected and doesn't contain any negative weight edge.
 *
 * Input: V = 5, edges[][] = [[0, 1, 4], [0, 2, 8], [1, 4, 6], [2, 3, 2], [3, 4, 10]], src = 0
 * Output: [0, 4, 8, 10, 10]
 *
 * Explanation:
 * For 0 to 1 minimum distance will be 4. By following path 0 -> 1
 * For 0 to 2 minimum distance will be 8. By following path 0 -> 2
 * For 0 to 3 minimum distance will be 10. By following path 0 -> 2 -> 3
 * For 0 to 4 minimum distance will be 10. By following path 0 -> 1 -> 4
 *
 * time complexity: O(E * logV)
 * space complexity: O(V)
 */
class Solution
{
public:
    // convert edge list into an adjacency list
    vector<vector<pair<int, int>>> convertToAdjList(int V, vector<vector<int>> &edges)
    {
        vector<vector<pair<int, int>>> adj(V);

        // add directed edges with weights to the list
        for (const auto &edge : edges)
        {
            int u = edge[0], v = edge[1], weight = edge[2];
            adj[u].emplace_back(v, weight);
        }

        return adj;
    }

    // Dijkstra Algorithm using priority queue(min-heap)
    vector<int> dijkstra(int V, vector<vector<int>> &edges, int src)
    {
        vector<vector<pair<int, int>>> adj = convertToAdjList(V, edges);

        // declare and initialize distance array
        vector<int> dist(V, numeric_limits<int>::max());

        // priority queue (min-heap)
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

        // put the source into priority queue and set its distance to 0
        dist[src] = 0;
        pq.emplace(0, src);

        // BFS
        while (!pq.empty())
        {
            int currDist = pq.top().first;
            int currNode = pq.top().second;
            pq.pop();

            // traverse through all adjacent nodes
            for (const auto &neighbor : adj[currNode])
            {
                int adjNode = neighbor.first;
                int edgeWeight = neighbor.second;

                if ((dist[currNode] + edgeWeight) < dist[adjNode])
                {
                    dist[adjNode] = dist[currNode] + edgeWeight; // update distance
                    pq.emplace(dist[adjNode], adjNode);          // put into priority queue
                }
            }
        }

        // mark all unreachable nodes as -1
        for (int i = 0; i < V; ++i)
        {
            if (dist[i] == numeric_limits<int>::max())
            {
                dist[i] = -1;
            }
        }

        return dist;
    }
};

int main()
{
    Solution obj;

    vector<vector<int>> edges = {
        {0, 1, 4},
        {0, 2, 8},
        {1, 4, 6},
        {2, 3, 2},
        {3, 4, 10}};
    int V = 5;
    int source = 0;

    vector<int> shortestPath = obj.dijkstra(V, edges, source);
    for (int i : shortestPath)
    {
        cout << i << " ";
    }
    cout << endl;

    return 0;
}