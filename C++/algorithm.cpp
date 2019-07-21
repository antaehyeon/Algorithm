#include <iostream>
#include <algorithm>
#include <vector>
#include <cstdlib>
#include <climits>
using namespace std;

int cal(int m, int a, int b) {
    if (m == 0) return a+b;
    else if (m == 1) return a-b;
    else if (m == 2) return a*b;
    else return a/b;
}

int main() {

    int max = INT_MIN;
    int min = INT_MAX;

    int N;
    cin >> N;

    int A[N];
    for (int i=0; i<N; i++) cin >> A[i];

    vector<int> B;
    for (int i=0; i<4; i++) {
        int t;
        cin >> t;

        if (t != 0) {
            for (int j=0; j<t; j++) B.push_back(i);
        }
    }
    
    do {
        int res = 0;
        int prev = A[0];
        for (int i=0; i<N-1; i++) {
            res = cal(B[i], prev, A[i+1]);
            cout << "res : " << res << " prev: " << prev << endl;
            prev = res;
        }

        if (res > max) max = res;
        if (res < min) min = res;

        cout << "** max : " << max << " min : " << min << endl; 
    } while (next_permutation(B.begin(), B.end()));

    cout << max << "\n";
    cout << min;

}