package graph.representation;

import java.util.Scanner;

/**
 * This class demonstrates how to represent a graph using an adjacency matrix.
 * The graph is undirected, and the vertices are assumed to be numbered from 0 to V-1.
 * The user inputs the number of vertices (V) and edges (E), followed by E pairs of integers
 * representing the edges between the vertices.
 */
public class GraphRepresentationUsingAdjacencyMatrix {
    public static void displayMatrix(int[][] mat) {
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int V = scan.nextInt();
        int E = scan.nextInt();

        // Initialize the adjacency matrix, with all values set to 0
        // assume vertex are numbered from 0 to V-1
        int[][] mat = new int[V][V];

        // Read edges and update the adjacency matrix
        for(int i = 0; i < E; i ++) {
            int u = scan.nextInt();
            int v = scan.nextInt();

            // Since the graph is undirected, we set both mat[u][v] and mat[v][u] to 1
            mat[u][v] = 1;
            mat[v][u] = 1;
        }

        displayMatrix(mat);
    }
}
