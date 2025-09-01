package graph.representation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphRepresentationUsingAdjacencyList {
    public static void displayList(List<List<Integer>> adj) {
        for (int i = 0; i < adj.size(); i ++) {
            System.out.print(i + " -> ");
            for(int j : adj.get(i)) {
                System.out.print("  " + j);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int V = scan.nextInt();
        int E = scan.nextInt();

        // Create an adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // add edges
        for(int i = 0; i < E; i ++) {
            int u = scan.nextInt();
            int v = scan.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u); // For undirected graph
        }

        displayList(adj);
    }
}
