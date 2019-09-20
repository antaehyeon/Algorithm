#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

int n, k, m;
vector<int> coins;

int main() {

    cin >> n >> k;
    for (int i=0; i<n; i++) {
        int coin;
        cin >> coin;
        coins.push_back(coin);
    }

    for (int i=n-1; i>=0; i--) {
        m += (k/coins[i]);
        k %= coins[i];
    }

    cout << m;
}
