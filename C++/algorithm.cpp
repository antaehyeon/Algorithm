#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

int n, sum = 0, avg = 0, ans = -987654321;
vector<int> nv;

bool compare(int n1, int n2) {
	return n1 > n2;
}

int main() {
	cin >> n;

	for (int i = 0; i < n; i++) {
		int t;
		cin >> t;
		sum += t;
		nv.push_back(t);
	}

	avg = sum / n;

	sort(nv.begin(), nv.end(), compare);

	for (int i = 1; i <= n; i++) {
		int temp = nv[i-1] * i;
		ans = ans > temp ? ans : temp;
	}

	cout << ans;
	
	return 0;
}