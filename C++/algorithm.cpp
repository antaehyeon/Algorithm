#include <iostream>
#include <algorithm>
#include <utility>
#include <vector>
#include <queue>
#define MAX 15
#define endl "\n"

using namespace std;

int a[20];
int n;
int T[MAX] = { 0, };
int P[MAX] = { 0, };
int ans = 0;

void go(int day, int sum) {

	if (day == n) {
		ans = max(ans, sum);
		return;
	}

	if (day >= n) {
		return;
	}

	go(day + T[day], sum + P[day]);
	go(day + 1, sum);

}

int main() {
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> T[i] >> P[i];
	}

	go(0, 0);
	cout << ans << endl;

	return 0;
}