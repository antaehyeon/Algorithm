#include <iostream>
#include <vector>
#include <tuple>
#define VSIZE 100

using namespace std;

int findParent(int graph[][VSIZE + 1], int n);

int main() {

	int VertexN; // 정점의 갯수
	int EdgeN; // 간선의 갯수

	int startV, destV;

	// INPUT
	cin >> VertexN;
	cin >> startV >> destV;
	cin >> EdgeN;

	vector<tuple<int, int, int>> Edge;
	// 간선의 정보를 저장
	for (int i = 0; i < EdgeN; i++) {
		int A, B;
		cin >> A >> B;
		Edge.push_back(make_tuple(A, B, 1));
	}

	// 인접 행렬
	int graphMatrix[VSIZE + 1][VSIZE + 1] = { 0, };

	for (auto i : Edge) {
		int V1 = get<0>(i); // A
		int V2 = get<1>(i); // B
		int W = get<2>(i); // W
		// 양방향 기록
		graphMatrix[V1][V2] = W;
		graphMatrix[V2][V1] = W;
	}

	int startN = findParent(graphMatrix, startV);
	int destN = findParent(graphMatrix, destV);

	cout << startN + destN << endl;

	system("pause");

	return 0;

}

int findParent(int graph[VSIZE + 1][VSIZE + 1], int n) {

	int count = 0;

	while (true) {
		int i;
		for (i = 1; i <= n; i++) {
			if (graph[n][i] == 1) {
				if (i == 1) return 1;
				count++;
				count += findParent(graph, i);
				return count;
			}
		}
		if (i == n) return -1;
	}

	return count;
}