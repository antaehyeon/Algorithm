#include <iostream>
#include <vector>
#include <queue>
#include <tuple>
#include <stdlib.h>
#define VSIZE 101

using namespace std;

int visit[VSIZE + 1];
int graphMatrix[VSIZE + 1][VSIZE + 1]; // �ִ� ������ŭ �̸� ����
vector <pair<int, int>> graphList[VSIZE + 1];

int cnt;

void dfs(int n) {

	visit[n] = true;
	for (int i = 0; i < graphList[n].size(); i++) {
		if (visit[graphList[n][i].first] == false) {
			cnt++;
			dfs(graphList[n][i].first);
		}
	}

} // dfs

void bfs(int start, int dest) {
	queue <int> que;
	que.push(start);
	visit[start] = 1;

	while (!que.empty()) {
		int p = que.front();
		que.pop();

		if (p == dest) {
			cout << visit[p] - 1 << endl;
			return;
		} // if

		for (int i = 0; i < graphList[p].size(); i++) {
			int vertexNumber = graphList[p][i].first;

			if (visit[vertexNumber] == 0) {
				que.push(vertexNumber);
				visit[vertexNumber] = visit[p] + 1;
			} // if
		} // for
	} // while

	cout << "-1" << endl;
} // FUNCTION BFS

int main() {
	int startV, destV;

	int VertexN; // ������ ����
	int EdgeN; // ������ ����
	cin >> VertexN;
	cin >> startV >> destV;
	cin >> EdgeN;
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

	//dfs(1);

	bfs(startV, destV);

	//cout << cnt;

	system("pause");

	return 0;
}