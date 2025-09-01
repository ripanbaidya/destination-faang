#include <bits/stdc++.h>

using namespace std;

/**
 * @author Ripan Baidya
 * @date 09-08-2025
 *
 * Given a Directed Acyclic Graph (DAG) of V (0 to V-1) vertices and E edges represented as a 2D list of edges[][],
 * where each entry edges[i] = [u, v] denotes a directed edge u -> v. Return the topological sort for the given graph.
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed
 * edge u -> v, vertex u comes before v in the ordering.
 * Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological
 * sort is correct then the output will be true else false.
 *
 * Input: V = 6, E = 6, edges[][] = [[1, 3], [2, 3], [4, 1], [4, 0], [5, 0], [5,2]]
 * Output: true
 * Explanation: The output true denotes that the order is valid. Few valid Topological orders for the graph are:
 * [4, 5, 0, 1, 2, 3]
 * [5, 2, 4, 0, 1, 3]
 *
 * time: O(V + E)
 * space: O(V)
 */
class Solution {
public:
    // Convert the edge list to an adjacency list representation
    vector<list<int>> constructAdj(int V, vector<vector<int>>& edges) {
        vector<list<int>> adj(V);

        for (const auto& edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].push_back(v); // directed
        }

        return adj;
    }

    vector<int> topoSort(int V, vector<vector<int>>& edges) {
        vector<list<int>> adj = constructAdj(V, edges);

        // Create an in-degree array to store the in-degree of each vertex
        vector<int> indegree(V, 0);

        // count the in-degree of each vertex
        for (int i = 0; i < V; ++i) {
            for (int adjNode : adj[i]) {
                indegree[adjNode]++;
            }
        }

        // create a list to store the topo sort
        vector<int> topo;

        // A queue for BFS
        queue<int> q;

        // If the in-degree of a vertex is 0, add it to the queue
        for (int i = 0; i < V; ++i) {
            if (indegree[i] == 0) {
                q.push(i);
            }
        }

        // BFS
        while (!q.empty()) {
            int node = q.front(); // dequeue
            topo.push_back(node); // add the node to the topo array
            q.pop();

            for (int adjNode : adj[node]) {
                // decrease the in-degree of the adjacent node
                indegree[adjNode]--;

                // if the in-degree of the adjacent node becomes 0, add it to the queue
                if (indegree[adjNode] == 0) {
                    q.push(adjNode);
                }
            }
        }

        return topo;
    }
};

int main() {
    Solution obj;

    int V = 6, E = 6;
    vector<vector<int>> edges = {{1, 3}, {2, 3}, {4, 1}, {4, 0}, {5, 0}, {5, 2}};
    vector<int> topo = obj.topoSort(V, edges);
    for (int node : topo) {
        cout << node << " ";
    }
    cout << endl;

    return 0;
}