package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Example:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int intervalCount = intervals.length;
        List<int[]> mergedIntervals = new ArrayList<>();

        // sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int currentIndex = 0; currentIndex < intervalCount; currentIndex++) {
            int currentStart = intervals[currentIndex][0];
            int currentEnd = intervals[currentIndex][1];

            // skip intervals that are already merged
            if (!mergedIntervals.isEmpty() && currentEnd <= mergedIntervals.get(mergedIntervals.size() - 1)[1]) {
                continue;
            }

            // check for overlapping intervals
            for (int nextIndex = currentIndex + 1; nextIndex < intervalCount; nextIndex++) {
                if (intervals[nextIndex][0] <= currentEnd) {
                    currentEnd = Math.max(intervals[nextIndex][1], currentEnd);
                } else {
                    break;
                }
            }

            mergedIntervals.add(new int[]{currentStart, currentEnd});
        }

        // convert the merged intervals list to a 2D array
        int[][] resultArray = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); ++i) {
            resultArray[i][0] = mergedIntervals.get(i)[0];
            resultArray[i][1] = mergedIntervals.get(i)[1];
        }

        return resultArray;
    }

    public static void main(String[] args) {
        var obj = new MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6},{8, 10},{15,18}};

        int[][] result = obj.merge(intervals);

        System.out.println("Merged intervals: ");
        for (int[] row : result) {
            for (int val : row) {
                System.out.println(val + " ");
            }
            System.out.println();
        }
    }
}
