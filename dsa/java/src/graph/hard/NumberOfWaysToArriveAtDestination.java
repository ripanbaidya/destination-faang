package graph.hard;

import java.util.*;
/**
 * @author Ripan Baidya
 * @date 07-08-2025
 *
 * You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads
 * between some intersections. The inputs are generated such that you can reach any intersection from any
 * other intersection and that there is at most one road between any two intersections.
 *
 * You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there
 * is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many
 * ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.
 *
 * Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer
 * may be large, return it modulo 109 + 7.
 *
 * Example:
 * Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
 * Output: 4
 * Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
 * The four ways to get there in 7 minutes are:
 * - 0 ➝ 6
 * - 0 ➝ 4 ➝ 6
 * - 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
 * - 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
 */
public class NumberOfWaysToArriveAtDestination {
    // convert edge list to adjacency list
    private List<List<int[]>> convertToAdjList(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }

        return adj;
    }

    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = convertToAdjList(n, roads);

        // each element will be {distance, node}
        // sort based on distance, if equal then based on node.
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
            return (a[0] != b[0]) ? Long.compare(a[0], b[0])
                    : Long.compare(a[1], b[1]);
        });

        // declare and initialize distance array with Long.MAX_VALUE
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        // array to store number of ways to reach each node
        int[] ways = new int[n];

        int mod = (int)(1e9 + 7);  // Modulo value for large numbers
        dist[0] = 0;  // Distance to the starting node is 0
        ways[0] = 1;  // There is one way to reach the starting node
        pq.offer(new long[]{0, 0});  // Add the starting node to the priority queue

        // BFS
        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            long currDist = top[0];
            int currNode = (int) top[1];

            // Skip processing if we have already found a shorter path
            if (currDist > dist[currNode]) continue;

            // Explore neighbors of the current node
            for (int[] neighbor : adj.get(currNode)) {
                int adjNode = neighbor[0];
                int edgeWt = neighbor[1];

                long newDist = currDist + edgeWt;

                // If a shorter path to the neighbor is found
                if (newDist < dist[adjNode]) {
                    dist[adjNode] = newDist;  // Update shortest distance
                    ways[adjNode] = ways[currNode];  // Update number of ways
                    pq.offer(new long[]{newDist, adjNode});  // Add neighbor to the queue
                } else if (newDist == dist[adjNode]) {
                    // If another shortest path is found, add the number of ways
                    ways[adjNode] = (ways[adjNode] + ways[currNode]) % mod;
                }
            }
        }

        // Return the number of ways to reach the last node
        return ways[n - 1];
    }

    public static void main(String[] args) {
        var obj = new NumberOfWaysToArriveAtDestination();

        int n = 7;  // Number of intersections
        int[][] roads = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};

        int totalWays = obj.countPaths(n, roads);
        System.out.println("Total ways: " + totalWays);
    }
}
