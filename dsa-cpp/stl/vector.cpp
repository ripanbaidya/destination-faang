#include <bits/stdc++.h>
using namespace std;

int main() {
    vector<int> v;

    // add element from the last
    v.push_back(10);
    v.push_back(8);
    v.push_back(3);
    v.push_back(15);

    // printing size and capacity of the vector
    cout << "Current size of vector: " << v.size() << endl;
    cout << "Current capacity of vector: " << v.capacity() << endl;

    // interating over the vector
    cout << "Current element :" << endl;
    for(auto it : v) {
        cout << it << " ";
    }
    cout << endl; 

    cout << "element at index 1: " << v[1] << endl;

    // add element from front
    v.insert(v.begin(), 5); 

    // remove element from front
    v.erase(v.begin());

    // remove the last element from the vector
    v.pop_back();

    // sort elements
    sort(v.begin(), v.end());

    cout << "elements after sorting" << endl;
    for (auto it : v) {
        cout << it << " ";
    }

    // declare a vector 'v2' with length 5 having elment 10
    vector<int> v2(5, 10);
    v2.clear(); // clear all elements
    
    return 0;
}