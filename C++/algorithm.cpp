#include <iostream>
#include <algorithm>

using namespace std;

bool c[10] ={false, }; int a[10];
int n, m;

void go (int idx) {

	if (idx == m) {
		for (int i=0; i<m; i++) {
			cout << a[i] << " ";
		}
		cout << "\n";
		return;
	}

	for (int i=1; i<=n; i++) {
		if (c[i]) continue;
		c[i] = true; a[idx] = i;
		go(idx+1);
		c[i] = false;
	}
	return;
}

int main () {

	cin >> n >> m;

	go(0);

	return 0;
}