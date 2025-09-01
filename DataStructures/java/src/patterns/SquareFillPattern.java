package patterns;

public class SquareFillPattern {

    public static void squareFillPattern(int n) {
        int i, j;

        for (i = 0; i <= n; i++) {
            for (j = 0; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String args[])
    {
        int n = 6;
        squareFillPattern(n);
    }
}
