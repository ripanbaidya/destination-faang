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
 * Input:
 * flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], n = 4,src = 0,dst = 3,k = 1
 * Output: 700
 * Explanation: The optimal path with at most 1 stop from city 0 to 3 has cost 100 + 600 = 700.
 */
public class CheapestFlightsWithinKStops {
    // constant for infinity
    final int INF = Integer.MAX_VALUE;

    // convert edge list into an adjacency list
    private List<List<int[]>> convertToAdjList(int V, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i ++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        return adj;
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = convertToAdjList(n, flights);

        // declare and initialize cost array
        int[] cost = new int[n];
        Arrays.fill(cost, INF);

        // update the source destination and put it into queue
        // each node: {stops, node, cost}
        Queue<int[]> q = new LinkedList<>();
        cost[src] = 0;
        q.offer(new int[]{0, src, 0});

        // BFS
        while (!q.isEmpty()){
            int[] top = q.poll();
            int currStop = top[0];
            int currNode = top[1];
            int currCost = top[2];

            // If we've exceeded k stops, skip further traversal
            if (currStop > k) continue;

            // iterate through all adjacent nodes
            for (int[] neighbour : adj.get(currNode)) {
                int adjNode = neighbour[0];
                int edgeCost = neighbour[1];

                if ((currCost + edgeCost) < cost[adjNode] && currStop <= k) {
                    cost[adjNode] = currCost + edgeCost;
                    q.offer(new int[]{currStop+1, adjNode, cost[adjNode]});
                }
            }
        }

        // if the destination is unreachable then return -1
        // else return the cost
        return cost[dst] == INF ? -1 : cost[dst];
    }

    public static void main(String[] args) {
        var obj = new CheapestFlightsWithinKStops();

        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}}; // 700
        int n = 4, src = 0, dst = 3, k = 1;

        int cost = obj.findCheapestPrice(n, flights, src, dst, k);
        System.out.println("Cheapest price: " + cost);
    }
}
