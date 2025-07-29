/**
 * In this program we will see the types of loops in cpp
 */
#include<bits/stdc++.h>
using namespace std;

void whileExample(int n) {
    int i = 1;

    while(i <= n) {
        cout << "count" << i ++ << endl;
    }
}

void doWhileExample(int n) {
    int i = 1;

    do {
        cout << "count" << i ++ << endl;
    } while (i <= n);
}

int main() {
    int n;
    cin >> n;

    for(int i = 0; i < n; i ++) {
        cout << "count " << i << endl; 
    }
}