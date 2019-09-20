#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

struct Time
{
	int s;
	int e;
};

int n, cnt = 0;
vector<Time> tv;

bool compare(Time t1, Time t2) {
	if (t1.e == t2.e) return t1.s < t2.s;
	else return t1.e < t2.e;
}

int main() {
	cin >> n;

	for (int i = 0; i < n; i++) {
		int a, b;
		cin >> a >> b;

		tv.push_back({ a, b });
	}

	sort(tv.begin(), tv.end(), compare);

	int cv = 0;

	for (auto t : tv) {
		if (t.s >= cv) {
			cnt++;
			cv = t.e;
		}
	}

	cout << cnt;
	return 0;
}