#include <iostream>
#include <set>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);

	int N = 0,
		M = 0;
	set<int> s;

	cin >> N;

	for (int i = 0; i < N; i++) {
		int x;
		cin >> x;
		s.insert(x);
	}

	cin >> M;

	for (int i = 0; i < M; i++) {
		int x;
		cin >> x;
		cout << s.count(x) << " ";
	}

	cout << "\n";

	return 0;
}