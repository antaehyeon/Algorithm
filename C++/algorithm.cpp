#include <iostream>
#include <algorithm>
#include <vector>
#define MAX 1001

using namespace std;

int n, m, ans = 0;
bool visit[MAX];
vector<int> graph[MAX];

void input() {
	int v1, v2;
	for (int i = 0; i < m; i++) {
		cin >> v1 >> v2;
		graph[v1].push_back(v2);
		graph[v2].push_back(v1);
	}
}

void DFS(int start) {
	visit[start] = true;

	for (int i = 0; i < graph[start].size(); i++) {
		int next = graph[start][i];
		if (!visit[next]) {
			DFS(next);
		}
	}
}

int check() {
	for (int i = 1; i <= n; i++) {
		if (!visit[i]) {
			ans++;
			return i;
		}
	}
	return -1;
}

int main() {
	cin >> n >> m;
	input();

	while (1) {
		int idx = check();
		if (idx == -1) break;
		DFS(idx);
	}

	cout << ans;

	return 0;
}