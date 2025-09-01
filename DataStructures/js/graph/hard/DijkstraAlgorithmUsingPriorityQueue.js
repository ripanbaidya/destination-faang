/**
 * @author Ripan Baidya
 * @date 05-08-2025
 *
 * Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by 2d array edges[][],
 * where edges[i]=[u, v, w] represents the edge between the nodes u and v having w edge weight.
 * Find the shortest distance of all the vertices from the source vertex src, and return an array of integers where the ith
 * element denotes the shortest distance between ith node and source vertex src.
 * Note: The Graph is connected and doesn't contain any negative weight edge.
 *
 * Input: V = 5, edges[][] = [[0, 1, 4], [0, 2, 8], [1, 4, 6], [2, 3, 2], [3, 4, 10]], src = 0
 * Output: [0, 4, 8, 10, 10]
 * Explanation:
 *
 * Shortest Paths:
 * For 0 to 1 minimum distance will be 4. By following path 0 -> 1
 * For 0 to 2 minimum distance will be 8. By following path 0 -> 2
 * For 0 to 3 minimum distance will be 10. By following path 0 -> 2 -> 3
 * For 0 to 4 minimum distance will be 10. By following path 0 -> 1 -> 4
 *
 * time complexity: O(E * logV)
 * space complexity: O(V)
 */
class DijkstraAlgorithmUsingPriorityQueue {
    // Convert 2D matrix to adjacency list
    convertToAdjList(V, edges) {
        const adj = Array.from({ length: V }, () => []);

        for (const [u, v, weight] of edges) {
            adj[u].push([v, weight]);
        }

        return adj;
    }

    // Dijkstra's Algorithm using Priority Queue (Min-Heap)
    dijkstra(V, edges, src) {
        const adj = this.convertToAdjList(V, edges);

        // Priority Queue as Min-Heap: [distance, node]
        const pq = new MinPriorityQueue({ priority: x => x[0] });

        const dist = Array(V).fill(1e9); // Initialize all distances to "infinity" (1e9)
        dist[src] = 0; // Source to source distance is 0
        pq.enqueue([0, src]); // [distance, node]

        while (!pq.isEmpty()) {
            const [edgeWeight, node] = pq.dequeue().element;

            // Traverse through all adjacent nodes
            for (const [v, wt] of adj[node]) {
                if (edgeWeight + wt < dist[v]) {
                    dist[v] = edgeWeight + wt; // Update distance with shorter distance
                    pq.enqueue([dist[v], v]); // Push the new distance and node into the priority queue
                }
            }
        }

        // Vertices unreachable from source will have distance -1
        for (let i = 0; i < V; i++) {
            if (dist[i] === 1e9) dist[i] = -1;
        }

        return dist;
    }
}

// MinPriorityQueue Implementation using Heap (Node.js version)
// You can install `datastructures-js` library or write your own Priority Queue.
// Install command: npm install @datastructures-js/priority-queue
const { MinPriorityQueue } = require('@datastructures-js/priority-queue');

function main() {
    const obj = new DijkstraAlgorithmUsingPriorityQueue();

    const edges = [
        [0, 1, 4],
        [0, 2, 8],
        [1, 4, 6],
        [2, 3, 2],
        [3, 4, 10]
    ];

    const V = 5; // Number of vertices

    const shortestPath = obj.dijkstra(V, edges, 0); // V, edges, source
    console.log(shortestPath);
}

main();
