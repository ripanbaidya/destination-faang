package array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given an unsorted array arr[] of size n, containing elements from the range 1 to n, it is
 * known that one number in this range is missing, and another number occurs twice in the array,
 * find both the duplicate number and the missing number.
 *
 * Example:
 * Input: arr[] = [4, 3, 6, 2, 1, 1]
 * Output: [1, 5]
 * Explanation: Repeating number is 1 and the missing number is 5.
 */
public class FindRepeatingAndMissingNumber {
    public List<Integer> findTwoElement(int arr[]) {
        // sum of first n natural numbers
        long sumOfNaturalNumbers = (long) arr.length * (arr.length + 1) / 2;

        // sum of squares of first n natural numbers
        long sumOfSquaresOfNaturalNumbers = arr.length * (arr.length + 1) * (2L * arr.length + 1) / 6;

        // calculate current sum and sum of squares
        long currentSum = 0, currentSumOfSquares = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i]; // sum of array elements
            currentSumOfSquares += (long) arr[i] * arr[i]; // sum of squares of array elements
        }

        // Solve the Equations:
        // x - y = s - sumOfNaturalNumbers
        long equationOne = currentSum - sumOfNaturalNumbers; // x - y

        /*
         *  x^2 - y^2 = s2 - sumOfSquaresOfNaturalNumbers
         *  (x - y)(x + y) = s2 - sumOfSquaresOfNaturalNumbers
         *  (x+y) = s2-sumOfSquaresOfNaturalNumbers/ (x-y)
         */
        long equationTwo = (currentSumOfSquares - sumOfSquaresOfNaturalNumbers) / equationOne; // x + y

        // Solve for x and y
        long repeatingNumber = (equationOne + equationTwo) / 2; // Repeating number
        long missingNumber = equationTwo - repeatingNumber; // Missing number

        // Prepare the result
        ArrayList<Integer> result = new ArrayList<>();
        result.add((int) repeatingNumber);
        result.add((int) missingNumber);

        return result;
    }

    public static void main(String[] args) {
        FindRepeatingAndMissingNumber obj = new FindRepeatingAndMissingNumber();

        int[] arr = {4, 3, 6, 2, 1, 1};
        List<Integer> result = obj.findTwoElement(arr); // [1, 5]
        System.out.println(result);
    }
}
