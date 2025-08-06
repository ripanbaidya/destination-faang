package patterns;

public class ReverseLeftHalfPyramidPattern {

    public static void reverseLeftHalfPyramidPattern(int n) {
        int i, j;

        // calculating number of spaces
        int num = 2 * n - 2;

        // outer loop to handle rows
        for (i = n; i > 0; i--) {
            // inner loop to print spaces.
            for (j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            // Decrementing value of num after each loop
            num = num - 2;
            // inner loop to print stars.
            for (j = 0; j < i; j++) {
                System.out.print("*");
            }

            // printing new line for each row
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int n = 6;
        reverseLeftHalfPyramidPattern(n);
    }
}
