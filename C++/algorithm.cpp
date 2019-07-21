#include <iostream>
#include <algorithm>
#include <vector>
#include <cstdlib>
#include <climits>
using namespace std;

int main() {

    int ans = INT_MAX;
    int N;
    cin >> N;

    int w[N][N];
    vector<int> d(N);

    for (int i=0; i<N; i++) d[i] = i;

    for (int i=0; i<N; i++) {
        for (int j=0; j<N; j++) cin >> w[i][j];
    }

    do {
        bool ok = true;
        int sum = 0;
        for (int i=0; i<N-1; i++) {
            if (w[d[i]][d[i+1]] == 0)  ok = false;
            else sum += w[d[i]][d[i+1]];
        }
        if (ok && w[d[N-1]][d[0]] != 0) {
            sum += w[d[N-1]][d[0]];
            if (ans > sum) ans = sum;
        }
    } while (next_permutation(d.begin(), d.end()));

    cout << ans;
}