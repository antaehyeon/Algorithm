#include <iostream>
#include <algorithm>
#include <vector>
#include <string.h>
#define MAX 200001

using namespace std;

int k, n, m;
bool isAnswer = true;
bool visit[MAX];
int flag[MAX] = { -1, };
int f = 1;
vector<int> graph[MAX];
vector<string> answerList;

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
	flag[start] = f;
	f = f == 1 ? 2 : 1;

	for (int i = 0; i < graph[start].size(); i++) {
		int next = graph[start][i];
		if (flag[next] == flag[start]) {
			isAnswer = false;
			return;
		}

		if (!visit[next]) {
			DFS(next);
		}
	}
}

void reset() {
	for (int i = 1; i < MAX; i++) {
		graph[i].erase(graph[i].begin(), graph[i].end());
	}
	memset(visit, false, sizeof(visit));
	memset(flag, -1, sizeof(flag));
	f = 1;
	isAnswer = true;
}

void storeAnswer() {
	if (isAnswer) answerList.push_back("YES");
	else answerList.push_back("NO");
}

void printAnswer() {
	int cnt = 0;
	for (auto ans : answerList) {
		cnt++;
		if (cnt == answerList.size()) {
			cout << ans;
		}
		else {
			cout << ans << endl;
		}
	}
}

int main() {
	cin >> k;
	for (int i = 0; i < k; i++) {
		cin >> n >> m;
		if (i!=0) reset();
		input();
		DFS(1);
		storeAnswer();
	}
	printAnswer();

	return 0;
}