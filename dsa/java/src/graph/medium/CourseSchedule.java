package graph.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you
 * must take course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 */
public class CourseSchedule {
    // Convert the edge list to an adjacency list representation
    // To solve dfs/bfs problems, we need to convert the edge list to an adjacency list
    private List<List<Integer>> convertToAdjList(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i ++) adj.add(new ArrayList<>());

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v); // directed
        }

        return adj;
    }
    private boolean dfs(int node, List<List<Integer>> adjList, int[] vis, int[] visPath) {
        // Mark the current node & current path as visited
        vis[node] = 1;
        visPath[node] = 1;

        for (int adjNode : adjList.get(node)) {
            // If the adjacent node is not visited, then do a dfs on it
            if (vis[adjNode] != 1) {
                if (dfs(adjNode, adjList, vis, visPath))
                    return true;
            }
            // If the adjacent node is visited and is part of the current path,
            // then we have found a cycle
            else if (visPath[adjNode] == 1 && vis[adjNode] == 1) {
                return true;
            }
        }

        // Backtrack: unmark the current node from the current path
        visPath[node] = 0;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = convertToAdjList(numCourses, prerequisites);
        int[] vis = new int[numCourses];
        int[] visPath = new int[numCourses];

        for (int i = 0; i < numCourses; i ++) {
            if (vis[i] != 1) {
                if (dfs(i, adjList, vis, visPath))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CourseSchedule obj = new CourseSchedule();

        int numCourse = 5;
        int[][] prerequisites = {{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}};
        boolean canFinish = obj.canFinish(numCourse, prerequisites);
        System.out.println("Can finish all courses: " + canFinish);
    }
}
