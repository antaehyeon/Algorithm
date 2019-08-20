#include <iostream>
#include <algorithm>

using namespace std;

int a[10];
int n, m;

void go(int idx, int start) {
	if (idx == m) {
		for (int i=0; i<m; i++) {
			cout << a[i] << " ";
		}
		cout << "\n";
		return;
	}

	for (int i=start; i<=n; i++) {
		a[idx]=i;
		go(idx+1, i);
	}
}

int main () {
	cin >> n >> m;

	go(0, 1);

	return 0;
}