#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

bool c[10];
int a[10];
vector<int> nums;
int n, m;

void go(int idx) {
	if (idx == m) {
		for (int i=0; i<m; i++) {
			cout << a[i] << " ";
		}
		cout << "\n";
		return;
	}

	for (int i=0; i<n; i++) {

		if (c[i]) continue;

		c[i] = true;
		a[idx] = nums[i];
		go(idx+1);
		c[i] = false;
	}
}

int main () {
	cin >> n >> m;

	for (int i=0; i<n; i++) {
		int temp;
		cin >> temp;
		nums.push_back(temp);
	}

	sort(nums.begin(), nums.end());

	go(0);

	return 0;
}