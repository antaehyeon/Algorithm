#include <iostream>
#include <vector>
#include <tuple>
#include <stdlib.h>
#define VSIZE 101

using namespace std;

bool visit[VSIZE];
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

int main() {

	int VertexN; // ������ ����
	int EdgeN; // ������ ����
	cin >> VertexN >> EdgeN;
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

	dfs(1);

	cout << cnt;

	system("pause");

	return 0;
}