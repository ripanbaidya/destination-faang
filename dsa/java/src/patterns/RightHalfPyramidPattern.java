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
public class RightHalfPyramidPattern {
    public void rightHalfPyramidPattern(int n) {
        int i, j;

        for (i = 1; i <= n; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        var obj = new RightHalfPyramidPattern();

        int n = 6;
        obj.rightHalfPyramidPattern(n);
    }
}
