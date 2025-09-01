package array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 */
public class PascalsTriangle {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();

        // use long to avoid integer overflow
        long res = 1L;

        // first element is always 1
        result.add((int) res);

        // adjust for 0 based indexing
        int row = rowIndex + 1;

        for(int i = 1; i < row; ++ i){
            res *= (row - i);
            res /= i;
            result.add((int)res);
        }

        return result;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i ++){
            // for each row, getting all elements
            List<Integer> elements = getRow(i);
            result.add(elements);
        }

        return result;
    }

    public static void main(String[] args) {
        PascalsTriangle obj = new PascalsTriangle();

        int n = 5;
        List<List<Integer>> result = obj.generate(n);
        System.out.println(result);
    }
}
