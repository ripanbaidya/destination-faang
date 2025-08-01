package graph.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * There are a total of N tasks, labeled from 0 to N-1. Some tasks may have prerequisites,
 * for example to do task 0 you have to first complete task 1, which is expressed as a pair:
 * [0, 1]. Given the total number of tasks N and a list of P prerequisite pairs, find if it
 * is possible to finish all tasks.
 *
 * Input: N = 4, P = 3, prerequisites = [[1,0],[2,1],[3,2]]
 * Output: Yes
 * Explanation: To do task 1 you should have completed task 0, and to do task 2 you should
 * have finished task 1, and to do task 3 you should have finished task 2. So it is possible.
 *
 * This problem is similar to - Course Schedule 1 in leetcode
 */
public class PrerequisiteTasks {
    private List<Integer>[] constructAdj(int V, int[][] edges) {
        List<Integer>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i ++) adj[i] = new ArrayList<>();

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[v].add(u); // directed
        }

        return adj;
    }
    public boolean isPossible(int V, int P, int[][] prerequisites) {
        List<Integer>[] adj = constructAdj(V, prerequisites);
        int[] indegree = new int[V];

        // count the in-degree of each vertex
        for (int i = 0; i < V; i ++) {
            for (int adjNode : adj[i]) {
                indegree[adjNode] ++;
            }
        }

        // count element for topologically sorted element
        int count = 0;
        Queue<Integer> q = new LinkedList<>();

        // add all the element into queue which has indegree 0
        for (int i = 0; i < V; i ++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // bfs
        while (!q.isEmpty()) {
            int node = q.poll();
            count ++;

            for (int adjNode : adj[node]) {
                indegree[adjNode] --;

                if (indegree[adjNode] == 0) {
                    q.offer(adjNode);
                }
            }
        }

        // if count is equal to V then there is no cycle in the graph
        // else there is a cycle
        return count == V ? true : false;
    }

    public static void main(String[] args) {
        PrerequisiteTasks obj = new PrerequisiteTasks();

        int V = 4, P = 3;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}};

        System.out.println(obj.isPossible(V, P, prerequisites));
    }
}
