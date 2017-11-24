/*
X보다 작은 수
https://www.acmicpc.net/problem/10871
*/

#include <iostream>
#include <functional>
using namespace std;

int main() {

	int sum = 0;

	function<int(int)> f = [&](int n) {

		if (n <= 1) return n;
		else return f(n - 1) + f(n - 2);
	};

	int n;
	cin >> n;

	cout << f(n) << endl;

}