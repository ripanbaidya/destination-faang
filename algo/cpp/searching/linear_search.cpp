#include <iostream>

using namespace std;

/**
 * Given an array, arr[] of n integers, and an integer element x , find whether  element
 * x is present in the array. Return the index of the first occurrence of x in the array,
 * or -1 if it doesn't exist.
 *
 * Example:
 * Input: arr[] = [1, 2, 3, 4], x = 3
 * Output: 2
 * Explanation: For array [1, 2, 3, 4], the element to be searched is 3. Since 3 is present
 * at index 2, the output is 2
 */
class Solution
{
public:
    
    int search(int arr[], int n, int x)
    {
        for (int i = 0; i < n; i++)
        {
            if (arr[i] == x)
            {
                return i; // element found
            }
        }

        // element not found
        return -1;
    }
};

int main()
{
    Solution obj;

    int arr[] = {1, 2, 3, 4};
    int x = 3;
    int n = sizeof(arr) / sizeof(arr[0]);

    int index = obj.search(arr, n, x);
    cout << "Index of target: " << index << endl;

    return 0;
}