/*
사칙 연산
https://www.acmicpc.net/problem/10869
*/

#include <iostream>
#include <functional>
#include <vector>
using namespace std;

int main() {

	vector<function<int(int, int)>> d;

	d.push_back([](int x, int y) {
		return x + y;
	});

	d.push_back([](int x, int y) {
		return x - y;
	});

	d.push_back([](int x, int y) {
		return x * y;
	});

	d.push_back([](int x, int y) {
		return x / y;
	});

	d.push_back([](int x, int y) {
		return x % y;
	});

	int a, b;
	cin >> a >> b;

	for (auto &f : d) {
		cout << f(a, b) << endl;
	}


}