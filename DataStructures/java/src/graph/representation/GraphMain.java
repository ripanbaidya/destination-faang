package graph.representation;

import java.util.ArrayList;
import java.util.List;

public class GraphMain {
    public static List<List<Integer>> buildGraph() {
        int V = 5; // A, B, C, D, E
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Add edges (undirected)
        adjacencyList.get(0).add(1); // A-B
        adjacencyList.get(1).add(0);

        adjacencyList.get(0).add(4); // A-E
        adjacencyList.get(4).add(0);

        adjacencyList.get(1).add(2); // B-C
        adjacencyList.get(2).add(1);

        adjacencyList.get(1).add(3); // B-D
        adjacencyList.get(3).add(1);

        adjacencyList.get(1).add(4); // B-E
        adjacencyList.get(4).add(1);

        adjacencyList.get(2).add(3); // C-D
        adjacencyList.get(3).add(2);

        adjacencyList.get(3).add(4); // D-E
        adjacencyList.get(4).add(3);

        return adjacencyList;
    }

    public static int[][] buildGraphMatrix() {
        int V = 5; // A, B, C, D, E
        int[][] matrix = new int[V][V];

        // Add undirected edges
        matrix[0][1] = 1; matrix[1][0] = 1; // A-B
        matrix[0][4] = 1; matrix[4][0] = 1; // A-E
        matrix[1][2] = 1; matrix[2][1] = 1; // B-C
        matrix[1][3] = 1; matrix[3][1] = 1; // B-D
        matrix[1][4] = 1; matrix[4][1] = 1; // B-E
        matrix[2][3] = 1; matrix[3][2] = 1; // C-D
        matrix[3][4] = 1; matrix[4][3] = 1; // D-E

        return matrix;
    }

    public static void main(String[] args) {

    }
}
