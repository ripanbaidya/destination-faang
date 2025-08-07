package graph.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ripan Baidya
 * @date 01-08-2025
 *
 * There are a total of n tasks you have to pick, labelled from 0 to n-1. Some tasks may have
 * prerequisites[][] tasks, for example to pick task 0 you have to first finish tasks 1, which
 * is expressed as a pair: [0, 1]
 * Given the total number of n tasks and a list of prerequisite pairs of size m. Find a ordering
 * of tasks you should pick to finish all tasks.
 * Note: There may be multiple correct orders, you just need to return any one of them. If it is
 * impossible to finish all tasks, return an empty array. Returning any correct order will give
 * the output as true, whereas any invalid order will give the output false.
 *
 * Input: n = 4, prerequisites[][] = [[1, 0], [2, 0], [3, 1], [3, 2]]
 * Output: true
 * Explanation: There are a total of 4 tasks to pick. To pick task 3 you should have finished both
 * tasks 1 and 2. Both tasks 1 and 2 should be pick after you finished task 0. So one correct task
 * order is [0, 1, 2, 3]. Another correct ordering is [0, 2, 1, 3]. Returning any of these order
 * will result in an output of true.
 */

// we can solve this problem using topological sort - Kahn's algorithm
public class CourseSchedule {
    private List<Integer>[] constructAdj(int V, int[][] edges) {
        List<Integer>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i ++){
            adj[i] = new ArrayList<>();
        }
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[v].add(u);
        }

        return adj;
    }

    public ArrayList<Integer> findOrder(int V, int[][] prerequisites) {
        List<Integer>[] adj = constructAdj(V, prerequisites);
        int[] indegree = new int[V]; // in-degree array

        // count the in-degree of each vertex
        for (int i = 0; i < V; i ++) {
            for (int adjNode : adj[i]) {
                indegree[adjNode] ++;
            }
        }

        // create a list to store the topo sort, order of tasks
        ArrayList<Integer> topo = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        // Iterate over the in-degree array
        // and put all the element into queue which has in-degree 0
        for (int i = 0; i < V; i ++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // BFS
        while (!q.isEmpty()) {
            int currNode = q.poll();
            topo.add(currNode);

            for (int adjNode : adj[currNode]) {
                indegree[adjNode] --;

                if (indegree[adjNode] == 0) {
                    q.offer(adjNode);
                }
            }
        }

        // check if there is a cycle in the graph
        // if there is a cycle, return an empty array other wise return the topo sort
        return topo.size() == V ? topo : new ArrayList<>();
    }

    public static void main(String[] args) {
        CourseSchedule obj = new CourseSchedule();

        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        ArrayList<Integer> order = obj.findOrder(4, prerequisites);

        System.out.println(order);
    }
}
