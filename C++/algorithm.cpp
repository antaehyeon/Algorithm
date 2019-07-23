#include <iostream>
#include <algorithm>
#include <vector>
#include <cstdlib>
#include <climits>
using namespace std;


int main() {
    vector<int> v;
    vector<int> s;

    for (int i=0; i<9; i++) {
        int t;
        scanf("%d", &t);
        v.push_back(t);
    }

    sort(v.begin(), v.end());

    do {
        int sum = 0;
        for (int i=0; i<7; i++) sum += v[i];

        if (sum == 100) {
            for (int i=0; i<7; i++) s.push_back(v[i]);
            break;
        }
    } while(next_permutation(v.begin(), v.end()));

    sort(s.begin(), s.end());
    
    for (auto i : s) printf("%d\n", i);

}