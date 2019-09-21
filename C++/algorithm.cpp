#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int n, m, k;
	cin >> n >> m >> k;

	cout << min(min(n / 2, m), (n + m - k) / 3);
}