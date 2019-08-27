#include <iostream>
#include <algorithm>
#include <vector>
#include <utility>
#include <string.h>
#define MAX 8

using namespace std;

int n, m, ans = 987654321;
int map[MAX][MAX];
vector <pair<int, pair<int, int>>> cctvList;

void Print(int arr[MAX][MAX]) {
	cout << "#########" << endl;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cout << arr[i][j] << " ";
		}
		cout << endl;
	}
	
}

void detect(int visited[][MAX], int y, int x, int dir) {
	switch (dir) {
	case 0: // right
		for (int i = x; i < m; i++) {
			if (visited[y][i] == 6) break;
			visited[y][i] = 7;
		}
		break;
	case 1: // bottom
		for (int i = y; i < n; i++) {
			if (visited[i][x] == 6) break;
			visited[i][x] = 7;
		}
		break;
	case 2: // left
		for (int i = x; i >= 0; i--) {
			if (visited[y][i] == 6) break;
			visited[y][i] = 7;
		}
		break;
	case 3: // top
		for (int i = y; i >= 0; i--) {
			if (visited[i][x] == 6) break;
			visited[i][x] = 7;
		}
		break;
	}
}

void search(int idx, int prev[][MAX]) {
	int visited[MAX][MAX];


	if (idx == cctvList.size()) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (prev[i][j] == 0) cnt++;
			}
		}

		if (ans > cnt) ans = cnt;
	}
	else {
		pair<int, pair<int, int>> p = cctvList.at(idx);
		int y = p.first;
		int x = p.second.first;
		int type = p.second.second;

		switch (type) {
		case 1:
			for (int i = 0; i < 4; i++) {
				for (int k = 0; k < n; k++) {
					memcpy(visited[k], prev[k], sizeof(prev[k]));
				}
				detect(visited, y, x, i);
				search(idx + 1, visited);
			}
			break;
		case 2:
			for (int i = 0; i < 2; i++) {
				for (int k = 0; k < n; k++) {
					memcpy(visited[k], prev[k], sizeof(prev[k]));
				}
				detect(visited, y, x, i);
				detect(visited, y, x, i + 2);
				search(idx + 1, visited);
			}
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				for (int k = 0; k < n; k++) {
					memcpy(visited[k], prev[k], sizeof(prev[k]));
				}
				detect(visited, y, x, i);
				detect(visited, y, x, (i + 1) % 4);
				search(idx + 1, visited);
			}
			break;
		case 4:
			for (int i = 0; i < 4; i++) {
				for (int k = 0; k < n; k++) {
					memcpy(visited[k], prev[k], sizeof(prev[k]));
				}
				detect(visited, y, x, i);
				detect(visited, y, x, (i + 1) % 4);
				detect(visited, y, x, (i + 2) % 4);
				search(idx + 1, visited);
			}
			break;
		case 5:
			for (int k = 0; k < n; k++) {
				memcpy(visited[k], prev[k], sizeof(prev[k]));
			}
			detect(visited, y, x, 0);
			detect(visited, y, x, 1);
			detect(visited, y, x, 2);
			detect(visited, y, x, 3);
			search(idx + 1, visited);
			break;
		}
	}
}


int main() {
	
	cin >> n >> m;
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
			if (map[i][j] != 0 && map[i][j] != 6) {
				cctvList.push_back(make_pair(i, make_pair(j, map[i][j])));
			}
		}
	}

	search(0, map);

	cout << ans;

	return 0;
}

