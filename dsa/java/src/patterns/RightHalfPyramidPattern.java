package patterns;

public class RightHalfPyramidPattern {
    public static void rightHalfPyramidPattern(int n) {
        int i, j;

        for (i = 1; i <= n; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int n = 6;
        rightHalfPyramidPattern(n);
    }
}
