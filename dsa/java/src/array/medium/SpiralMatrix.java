package array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0, bottom = n-1;
        int left = 0, right = m-1;

        // spiral order: top -> right -> bottom -> left
        List<Integer> ans = new ArrayList<>();

        while (left <= right && top <= bottom){
            for (int i = left; i <= right; i ++){
                ans.add(matrix[top][i]);
            }
            top ++;

            for (int i = top; i <= bottom; i ++){
                ans.add(matrix[i][right]);
            }
            right --;

            if (top <= bottom){
                for (int i = right; i >= left; i --){
                    ans.add(matrix[bottom][i]);
                }

                bottom --;
            }

            if (left <= right){
                for (int i = bottom; i >= top; i --){
                    ans.add(matrix[i][left]);
                }
                left ++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        SpiralMatrix obj = new SpiralMatrix();

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> spiralOrder = obj.spiralOrder(matrix);

        // print the spiral order
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.println(val + " ");
            }
            System.out.println();
        }
    }
}
