/*
DP ���α׷��� �Թ�
(1�� �����:1463) https://www.acmicpc.net/problem/1463
*/

#include <iostream>
#include <algorithm>
#define SIZE 10000000

using namespace std;

int d[SIZE + 1] = { 0, };

int go(int n) {

	if (n == 1) return 0;
	if (d[n] > 0) return d[n];

	d[n] = go(n - 1) + 1;

	if (n % 2 == 0) {
		int temp = go(n / 2) + 1;
		if (d[n] > temp) d[n] = temp;
	}
	if (n % 3 == 0) {
		int temp = go(n / 3) + 1;
		if (d[n] > temp) d[n] = temp;
	}

	return d[n];
}

int main() {

	int n;
	cin >> n;

	cout << go(n) << endl;

	return 0;
}