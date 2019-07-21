#include <iostream>
#include <algorithm>
#include <vector>
#include <cstdlib>
using namespace std;

int cal(vector<int> v) {    
    int sum = 0;
    for (int i=0; i<v.size()-1; i++) {
        sum += (abs(v[i] - v[i+1]));
    }

    return sum;
}

int main() {
    int N, ans = -101;
    cin >> N;
    vector<int> a(N);

    for (int i=0; i<N; i++) cin >> a[i];

    sort(a.begin(), a.end());

    do {
        int temp = cal(a);
        ans = max(ans, temp);
    } while (next_permutation(a.begin(), a.end()));

    cout << ans;
}