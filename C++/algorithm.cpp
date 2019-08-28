#include <iostream>
#include <algorithm>
#include <vector>
#include <string.h>
#define MAX 2001

using namespace std;

int n, m, ans = 0;
bool visit[MAX] = { false, };
vector<int> graph[MAX];
bool isAns = false;


void DFS(int start, int cnt) {
	if (cnt == 4) {
		isAns = true; return;
	}
	visit[start] = true;
	for (int i = 0; i < graph[start].size(); i++) {
		int next = graph[start][i];
		if (visit[next]) continue;
		DFS(next, cnt + 1);
	}
	visit[start] = false;
}


int main() {
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int v1, v2;
		cin >> v1 >> v2;
		graph[v1].push_back(v2);
		graph[v2].push_back(v1);
	}

	for (int i = 0; i < n; i++) {
		sort(graph[i].begin(), graph[i].end());
	}

	for (int i = 0; i < n; i++) {
		memset(visit, false, sizeof(visit)); ans = 0;
		DFS(i, 0);
		if (isAns) break;
	}

	if (isAns) cout << 1 << endl;
	else cout << 0 << endl;

	return 0;
}

