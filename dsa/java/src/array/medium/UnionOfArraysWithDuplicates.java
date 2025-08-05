package array.medium;

import java.util.Arrays;

/**
 * @author Ripan Baidya
 * @date 30-07-2025
 *
 * You are given two arrays a[] and b[], return the Union of both the arrays in any order.
 * The Union of two arrays is a collection of all distinct elements present in either of the
 * arrays. If an element appears more than once in one or both arrays, it should be included
 * only once in the result.
 * Note: Elements of a[] and b[] are not necessarily distinct.
 * Note that, You can return the Union in any order but the driver code will print the result in sorted order only.
 *
 * Input: a[] = [1, 2, 3, 2, 1], b[] = [3, 2, 2, 3, 3, 2]
 * Output: [1, 2, 3]
 * Explanation: Union set of both the arrays will be 1, 2 and 3.
 */
public class UnionOfArraysWithDuplicates {
    public int findUnion(int a[], int b[]) {
        Arrays.sort(a);
        Arrays.sort(b);

        // Two pointers to traverse both arrays
        int i = 0, j = 0;
        int n = a.length, m = b.length;

        // To keep track of the previous element to avoid duplicates
        int prev = Integer.MIN_VALUE;
        int count = 0;

        // Traverse both arrays until one of them is exhausted
        while (i < n && j < m) {
            int val;

            if (a[i] == b[j]) {
                val = a[i];
                i++;
                j++;
            } else if (a[i] < b[j]) {
                val = a[i];
                i++;
            } else {
                val = b[j];
                j++;
            }
            if (val != prev) {
                count++;
                prev = val;
            }
        }

        // Traverse remaining elements in a[]
        while (i < n) {
            if (a[i] != prev) {
                count++;
                prev = a[i];
            }
            i++;
        }

        // Traverse remaining elements in b[]
        while (j < b.length) {
            if (b[j] != prev) {
                count++;
                prev = b[j];
            }
            j++;
        }

        return count;
    }
}
