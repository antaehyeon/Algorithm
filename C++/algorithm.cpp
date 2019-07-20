#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    int N;
    cin >> N;

    vector<int> v(N);

    for (int i=0; i<N; i++) cin >> v[i];

    if (next_permutation(v.begin(), v.end())) {
        for (auto i : v) cout << i << " ";
    } else cout << "-1";

    return 0;
}