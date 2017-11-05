#include <iostream>
#include <set>

using namespace std;

int main() {
	int N = 0,
		M = 0;
	set<int> s;

	scanf("%d", &N);

	for (int i = 0; i < N; i++) {
		int x;
		scanf("%d", &x);
		s.insert(x);
	}

	scanf("%d", &M);

	for (int i = 0; i < M; i++) {
		int x;
		scanf("%d", &x);
		printf("%d\n", s.count(x));
	}

	return 0;
}