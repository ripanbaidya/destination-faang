package patterns;

/**
 * @author Ripan Baidya
 * @date 07-08-2025
 *
 * Given a number, n, print the left half pyramid pattern using stars.
 * Input: n = 6
         *
       * *
     * * *
   * * * *
 * * * * *
 */
public class LeftHalfPyramidPattern {
    public void leftHalfPyramidPattern(int n) {
        int i, j;

        for (i = n; i >= 1; i--) {
            // inner loop to print spaces.
            for (j = 1; j < i; j++) {
                System.out.print(" ");
            }
            // inner loop to print stars.
            for (j = 0; j <= n - i; j++) {
                System.out.print("*");
            }
            // printing new line for each row
            System.out.println();
        }
    }
    public static void main(String[] args) {
        var obj = new LeftHalfPyramidPattern();

        int n = 6;
        obj.leftHalfPyramidPattern(n);
    }
}
