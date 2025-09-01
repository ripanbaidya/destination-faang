// check whether a number is palindrome or not
#include<iostream>
using namespace std;

bool isPalindrome(int num) {
    int temp = num;
    int reverse = 0;

    while (num != 0) {
        int rem = num % 10;
        reverse = reverse * 10 + rem;
        num /= 10;
    }

    return reverse == temp;
}

int main() {
    int num = 163;

    string result = isPalindrome(num) == 1 ? "Palindrome" : "Not Palindrome";
    cout << result; 
    return 0;
}