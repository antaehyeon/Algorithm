#include <iostream>
#include <vector>
#include <queue>
#include <tuple>
#include <stdlib.h>
#include <algorithm>
#define VSIZE 1000

using namespace std;

int visit[VSIZE + 1];
int visit2[VSIZE + 1];
int graphMatrix[VSIZE + 1][VSIZE + 1]; // �ִ� ������ŭ �̸� ����
vector <pair<int, int>> graphList[VSIZE + 1];

queue <int> esq;

int index = 0;

void dfs(int n) {

	esq.push(n);

	visit[n] = true;
	sort(graphList[n].begin(), graphList[n].end());
	for (int i = 0; i < graphList[n].size(); i++) {
		if (visit[graphList[n][i].first] == false) {
			dfs(graphList[n][i].first);
		}
	}

} // dfs

void bfs(int start) {
	queue <int> que;
	que.push(start);
	visit2[start] = 1;

	while (!que.empty()) {
		int p = que.front();
		que.pop();

		esq.push(p);

		sort(graphList[start].begin(), graphList[start].end());
		for (int i = 0; i < graphList[p].size(); i++) {
			int vertexNumber = graphList[p][i].first;

			if (visit2[vertexNumber] == 0) {
				que.push(vertexNumber);
				visit2[vertexNumber] = visit2[p] + 1;
			} // if
		} // for
	} // while
} // FUNCTION BFS

void clearQueue(queue <int> &someQueue) {
	queue<int> empty;
	swap(someQueue, empty);
}

int main() {
	int startV, destV;

	int VertexN; // ������ ����
	int EdgeN; // ������ ����
	//scanf_s("%d %d %d", &VertexN, sizeof(VertexN), &EdgeN, sizeof(EdgeN), &startV, sizeof(startV));
	scanf("%d %d %d", &VertexN, &EdgeN, &startV);
	vector<tuple<int, int, int>> Edge;

	// ������ ������ ����
	for (int i = 0; i < EdgeN; i++) {
		int A, B, W; // A���� B�� W�� ����ġ�� ������
		cin >> A >> B;
		Edge.push_back(make_tuple(A, B, 1));
	}

	// ���� ���
	for (auto i : Edge) {
		// i üũ�غ���
		int V1 = get<0>(i); // A
		int V2 = get<1>(i); // B
		int W = get<2>(i); // W
						   // ����� ���
		graphMatrix[V1][V2] = W;
		graphMatrix[V2][V1] = W;
	}

	// ���� ����Ʈ
	for (auto i : Edge) {
		int V1 = get<0>(i); // A
		int V2 = get<1>(i); // B
		int W = get<2>(i); // Weight
						   // ����� ���
		graphList[V1].push_back(make_pair(V2, W));
		graphList[V2].push_back(make_pair(V1, W));
	}

	dfs(startV);

	int repeat = esq.size();

	for (int i = 0; i < repeat - 1; i++) {
		printf("%d ", esq.front());
		esq.pop();
	}

	printf("%d\n", esq.front());
	esq.pop();

	clearQueue(esq);

	bfs(startV);

	repeat = esq.size();

	for (int i = 0; i < repeat - 1; i++) {
		printf("%d ", esq.front());
		esq.pop();
	}

	printf("%d\n", esq.front());
	esq.pop();

	system("pause");

	return 0;
}