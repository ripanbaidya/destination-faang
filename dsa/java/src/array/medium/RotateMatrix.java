package array.medium;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 */
public class RotateMatrix {
    private void reverse(int[] arr){
        int left = 0, right = arr.length-1;

        while(left <= right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left ++;
            right --;
        }
    }
    private void swap(int[][] mat, int i, int j){
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix in place
        for (int i = 0; i <= n-2; i ++){
            for (int j = i+1; j <= n-1; j ++){
                swap(matrix, i, j);
            }
        }

        // reverse each row
        for(int[] row : matrix){
            reverse(row);
        }
    }
}
