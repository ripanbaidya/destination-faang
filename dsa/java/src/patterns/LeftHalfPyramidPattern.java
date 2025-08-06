package patterns;

public class LeftHalfPyramidPattern {

    public static void leftHalfPyramidPattern(int n) {
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

    public static void main(String args[]) {
        int n = 6;
        leftHalfPyramidPattern(n);
    }
}
