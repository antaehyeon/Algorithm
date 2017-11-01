#include <iostream>
#include <vector>
#include <tuple>
#include <stdlib.h>
#define VSIZE 101

using namespace std;

bool visit[VSIZE];
int graphMatrix[VSIZE + 1][VSIZE + 1]; // 최대 갯수만큼 미리 선언
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

	int VertexN; // 정점의 갯수
	int EdgeN; // 간선의 갯수
	cin >> VertexN >> EdgeN;
	vector<tuple<int, int, int>> Edge;

	// 간선의 정보를 저장
	for (int i = 0; i < EdgeN; i++) {
		int A, B, W; // A에서 B로 W의 가중치를 가진다
		cin >> A >> B;
		Edge.push_back(make_tuple(A, B, 1));
	}

	// 인접 행렬
	for (auto i : Edge) {
		// i 체크해보기
		int V1 = get<0>(i); // A
		int V2 = get<1>(i); // B
		int W = get<2>(i); // W
						   // 양방향 기록
		graphMatrix[V1][V2] = W;
		graphMatrix[V2][V1] = W;
	}

	// 인접 리스트
	for (auto i : Edge) {
		int V1 = get<0>(i); // A
		int V2 = get<1>(i); // B
		int W = get<2>(i); // Weight
						   // 양방향 기록
		graphList[V1].push_back(make_pair(V2, W));
		graphList[V2].push_back(make_pair(V1, W));
	}

	dfs(1);

	cout << cnt;

	system("pause");

	return 0;
}