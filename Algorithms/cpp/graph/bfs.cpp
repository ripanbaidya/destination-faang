#include <bits/stdc++.h>

using namespace std;

/**
 * @author Ripan Baidya
 * @date 09-08-2025
 *
 * Given a connected undirected graph containing V vertices, represented  by a 2-d adjacency list adj[][],
 * where each adj[i] represents the list of vertices connected to vertex i. Perform a Breadth First Search
 * (BFS) traversal starting from vertex 0, visiting vertices from left to right according to the given
 * adjacency list, and return a list containing the BFS traversal of the graph.
 * Note: Do traverse in the same order as they are in the given adjacency list.
 *
 * Example:
 *
 * Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]
 * Output: [0, 2, 3, 1, 4]
 * Explanation: Starting from 0, the BFS traversal will follow these steps:
 * Visit 0 → Output: 0
 * Visit 2 (first neighbor of 0) → Output: 0, 2
 * Visit 3 (next neighbor of 0) → Output: 0, 2, 3
 * Visit 1 (next neighbor of 0) → Output: 0, 2, 3,
 * Visit 4 (neighbor of 2) → Final Output: 0, 2, 3, 1, 4
 *
 * Time: O(V + E) where V is the number of vertices and E is the number of edges.
 * Space: O(V) for the visited array and queue.
 */
class Solution {
public:
    vector<int> bfs(vector<vector<int>>& adjList) {
        int V = adjList.size();
        int source = 0;

        vector<int> res; // store bfs traversal order
        unordered_set<int> vis; // visited set

        // A queue for BFS traversal
        queue<int> q;

        // mark source node as visited and put it into the queue
        vis.insert(source);
        q.push(0);

        while (!q.empty()) {
            int node = q.front();
            q.pop();
            res.push_back(node);

            // iterate through all adjacent vertices of the current vertex
            // if the adjacent vertex is not visited, mark it as visited and
            // add to queue, also add it to the bfs list
            for (int adjNode : adjList[node]) {
                if (vis.find(adjNode) == vis.end()) {
                    vis.insert(adjNode);
                    q.push(adjNode);
                }
            }
        }

        // return the BFS traversal of the graph
        return res;
    }
};

int main() {
    Solution obj;

    // create the adjacency list: { {2, 3, 1}, {0}, {0, 4}, {0}, {2} }
    vector<vector<int>> adj = {
        {2, 3, 1},
        {0},
        {0, 4},
        {0},
        {2}
    };

    vector<int> ans = obj.bfs(adj);
    for (int i : ans) {
        cout << i << " ";
    }
    cout << endl;

    return 0;
}