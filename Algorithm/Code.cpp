/*
A+B
A+B - 4 (https://www.acmicpc.net/problem/10951)
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(const int &a, const int &b) {
	return a < b;
}

int main() {

	int n;

	vector <int> v;

	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		int a;
		scanf("%d", &a);
		v.push_back(a);
	}

	sort(v.begin(), v.end(), cmp);

	for (int i = 0; i < n; i++) {
		printf("%d\n", v[i]);
	}

}