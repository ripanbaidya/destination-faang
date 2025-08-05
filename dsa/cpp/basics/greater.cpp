// find the greater number among three number using if-else 
// and do the same using ternary operator
#include<iostream>
using namespace std;

// using ternary operator
int getMaximumNumber(int a, int b, int c) {
    return (a >= b) ? ((a >= c) ? a : c) : ((b >= c) ? b : c);
}

int main() {
    int a = 10, b = 30, c = 24;

    if (a >= b && a >= c) {
        cout << a << "is greater";
    } else if (b >= c && b >= a) {
        cout << b << "is greater";
    } else {
        cout << c << "is greater";
    }
    
    return 0;
}