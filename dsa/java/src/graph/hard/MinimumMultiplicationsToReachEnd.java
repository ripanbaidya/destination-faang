package graph.hard;

import java.util.*;
/**
 * @author Ripan Baidya
 * @date 08-08-2025
 *
 * Given start, end and an array arr of n numbers. At each step, start is multiplied with
 * any number in the array and then mod operation with 100000 is done to get the new start.
 * Your task is to find the minimum steps in which end can be achieved starting from start.
 * If it is not possible to reach end, then return -1.
 *
 * Example :
 *
 * Input: arr[] = {2, 5, 7}, start = 3, end = 30
 * Output: 2
 * Explanation:
 * Step 1: 3*2 = 6 % 100000 = 6
 * Step 2: 6*5 = 30 % 100000 = 30
 */
public class MinimumMultiplicationsToReachEnd {
    final int INF = Integer.MAX_VALUE;
    final int MOD = 100000;

    int minimumMultiplications(int[] arr, int start, int end) {
        // base case
        if (start == end) return 0;

        // Steps to reach each number
        int[] steps = new int[MOD];
        Arrays.fill(steps, INF);
        steps[start] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int factor : arr) {
                int next = (curr * factor) % MOD;

                if (steps[curr] + 1 < steps[next]) {
                    steps[next] = steps[curr] + 1;

                    // Found the end number
                    if (next == end) return steps[next];

                    q.offer(next);
                }
            }
        }

        return -1; // not reachable
    }

    public static void main(String[] args) {
        var obj = new MinimumMultiplicationsToReachEnd();

        int[] arr = {2, 5, 7};
        int start = 3, end = 30;
        int minimumSteps = obj.minimumMultiplications(arr, start, end);
        System.out.println("Minimum steps: " + minimumSteps);
    }
}
