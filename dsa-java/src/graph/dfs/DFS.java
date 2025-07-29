package graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class DFS {
    public static void dfs(int node, ArrayList<Integer> res, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        // mark the current node as visited and add it to the result list
        vis[node] = true;
        res.add(node);

        // iterate through all adjacent vertices of the current vertex
        // if the vertex is not visited, recursively call dfs on it
        for(int it : adj.get(node)) {
            if(!vis[it]) {
                dfs(it, res, vis, adj);
            }
        }
    }
    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int source = 0;

        // list to store the DFS traversal order
        ArrayList<Integer> res = new ArrayList<>();

        // visited array to keep track of visited nodes
        boolean[] vis = new boolean[V];

        // start DFS from the source node
        dfs(source, res, vis, adj);

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


        ArrayList<Integer> ans = dfs(adj);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
