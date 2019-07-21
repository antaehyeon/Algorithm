#include <iostream>
#include <algorithm>
#include <vector>
#include <cstdlib>
#include <climits>
using namespace std;

int main() {
    int N;
    while (N != 0) {
        vector<int> a;

        cin >> N;

        for (int i=0; i<N; i++) {
            if (i >= 6) a.push_back(0);
            else a.push_back(1);
        }

        vector<int> v(N);

        for (int i=0; i<N; i++) cin >> v[i];

        do {
            for (int i=0; i<N; i++) {
                if (a[i] == 1) {
                        cout << v[i] << " ";
                    }
                }
            cout << "\n";
        } while (prev_permutation(a.begin(), a.end()));

        cout << "\n";
    }
}