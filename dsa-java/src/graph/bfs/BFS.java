package graph.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class implements the Breadth-First Search (BFS) algorithm for traversing a graph.
 * It uses an adjacency list representation of the graph and returns the order of nodes visited.
 *
 * Time: O(V + E) where V is the number of vertices and E is the number of edges.
 * Space: O(V) for the visited array and queue.
 */
public class BFS {
    private static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int source = 0;

        // create a list to store the BFS traversal order
        ArrayList<Integer> res = new ArrayList<>();

        // visited array to keep track of visited nodes
        boolean[] vis = new boolean[V];

        // A queue for BFS traversal
        Queue<Integer> q = new LinkedList<>();

        // mark source node as visited and enqueue it
        vis[source] = true;
        q.offer(0);

        while(!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);

            // iterate through all adjacent vertices of the current vertex
            // if the vertex is not visited, mark it as visited and add to queue
            // also add it to the bfs list
            // this ensures that we visit all vertices connected to the starting vertex
            for(int it : adj.get(curr)) {
                if(!vis[it]) {
                    vis[it] = true;
                    q.offer(it);
                }
            }
        }

        // return the list of vertices in the order they were visited
        // this is the BFS traversal of the graph
        return res;
    }

    public static void main(String[] args) {
        // create the adjacency list
        // { {2, 3, 1}, {0}, {0, 4}, {0}, {2} }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2, 3)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(1,4)));
        adj.add(new ArrayList<>(Arrays.asList(2,3)));


        ArrayList<Integer> ans = bfs(adj);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
