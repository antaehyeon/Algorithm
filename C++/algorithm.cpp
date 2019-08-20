#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int a[10];
vector<int> nums;
int n, m;

void go(int idx) {
	if (idx == m) {
		for (int i=0; i<m; i++) {
			cout << nums[a[i]] << " ";
		}
		cout << "\n";
		return;
	}

	for (int i=0; i<n; i++) {
		a[idx]=i;
		go(idx+1);
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