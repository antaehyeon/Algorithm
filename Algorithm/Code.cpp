/*
X보다 작은 수
https://www.acmicpc.net/problem/10871
*/

#include <iostream>
using namespace std;

int main() {

	int n, x;

	cin >> n >> x;

	auto function = [&](int num) {
		return num < x;
	};

	for (int i = 0; i < n; i++) {
		int inputN;

		cin >> inputN;
		if (function(inputN)) {
			cout << inputN << " ";
		}
	}
}