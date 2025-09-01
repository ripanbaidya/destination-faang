package array.medium;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
 * You must do it in place.
 *
 * Example:
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 */
public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length; // row
        int m = matrix[0].length; // col
        int col0 = 1;

        // traverse the matrix and identified the row and column contains zero
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j ++){
                if(matrix[i][j] == 0){
                    // mark i-th row
                    matrix[i][0] = 0;

                    // mark j-th column
                    if(j == 0) col0 = 0;
                    else matrix[0][j] = 0;
                }
            }
        }

        // Traverse and mark the matrix from (1, 1) to (n - 1, m - 1)
        for (int i = 1; i < n; i ++){
            for (int j = 1; j < m; j ++){
                // check for row & col
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // mark the first row
        if (matrix[0][0] == 0){
            for (int j = 0; j < m; j ++){
                matrix[0][j] = 0;
            }
        }

        // mark the first column
        if (col0 == 0){
            for (int i = 0; i < n; i ++){
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeros obj = new SetMatrixZeros();

        int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};
        obj.setZeroes(matrix);

        System.out.println("Matrix after setting zeros: ");
        for (int [] row : matrix) {
            for (int val : row) {
                System.out.println(val +" ");
            }
            System.out.println();
        }
    }
}
