#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

int n;
int p = 0;
int sum = 0;
vector<int> v;

int main() {

    cin >> n;

    for (int i=0; i<n; i++) {
        int t;
        cin >> t;
        v.push_back(t);
    }

    sort(v.begin(), v.end());

    for (int i=0; i<n; i++) {
        p += v[i];
        sum += p;
    }

    cout << sum << endl;

    return 0;
}
