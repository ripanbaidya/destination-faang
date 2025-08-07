package graph.hard;

import java.util.*;
/**
 * @author Ripan Baidya
 * @date 07-08-2025
 *
 * There are n cities connected by some number of flights. You are  given  an array flights
 * where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi
 * to city toi with cost pricei.
 *
 * You are also given three integers src, dst, and k, return the cheapest price from src to
 * dst with at most k stops. If there is no such route, return -1.
 *
 * Input: n = 4, src = 0, dst = 3, k = 1, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]],
 * Output: 700
 * Explanation:
 * The graph is shown above.
 * The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
 * Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
 */
public class CheapestFlightsWithinKStops {
    // convert edge list into an adjacency list
    private List<List<int[]>> convertToAdjList(int V, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i ++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new int[]{v, wt}); // directed
        }

        return adj;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = convertToAdjList(n, flights);

        // declare and initialize distance array
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);

        // update the source destination and put it into queue
        // each node: {stops, node, distance}
        Queue<int[]> q = new LinkedList<>();
        dist[src] = 0;
        q.offer(new int[]{0, src, 0});

        // BFS
        while (!q.isEmpty()){
            int[] top = q.poll();
            int currStop = top[0];
            int currNode = top[1];
            int currDist = top[2];

            // dont go beyond k
            if (currStop > k) continue;

            // iterate through all adjacent nodes
            for (int[] neighbour : adj.get(currNode)) {
                int adjNode = neighbour[0];
                int edgeWt = neighbour[1];

                if ((currDist + edgeWt) < dist[adjNode] && currStop <= k) {
                    dist[adjNode] = currDist + edgeWt;
                    q.offer(new int[]{currStop+1, adjNode, dist[adjNode]});
                }
            }
        }

        // if the destination is unreachable then return -1
        // else return the distance
        return dist[dst] == (int) 1e9 ? -1 : dist[dst];
    }
}
