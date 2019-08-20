#include <iostream>
#include <algorithm>

using namespace std;

int a[10];
int n, m;

void go(int idx, int selected) {
	if (selected == m) {
		for (int i=0; i<m; i++) {
			cout << a[i] << " ";
		}
		cout << "\n";
		return;
	}

	if (idx > n) return;
	a[selected] = idx;
	go(idx+1, selected+1);
	a[selected] = 0;
	go(idx+1, selected);

	return;
}

int main () {
	cin >> n >> m;

	go(1, 0);

	return 0;
}