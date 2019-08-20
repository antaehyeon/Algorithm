#include <iostream>
#include <algorithm>
#include <utility>
#include <vector>
#include <queue>
#define MAX 21
#define endl "\n"

using namespace std;

int n, s, ans=0;
int a[MAX] = {0, };

int main() {

	cin >> n >> s;
	
	for (int i=0; i<n; i++) {
		cin >> a[i];
	}

	for (int i=1; i<(1<<n); i++) {
		int sum = 0;
		for (int k=0; k<n; k++) {
			if (i&(1<<k)) {
				sum += a[k];
			}
		}
		if (sum == s) ans += 1;
	}

	cout << ans;

	return 0;
}