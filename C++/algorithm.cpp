#include <iostream>
#include <algorithm>
#include <string.h>
#include <queue>
#define endl "\n"
#define MAX 101

using namespace std;

int n, m;
int map[MAX][MAX];

int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };

void input() {
	cin >> n >> m;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			scanf("%1d", &map[i][j]);
		}
	}
}

bool isAccessable(int y, int x) {
	return (y > 0 && y <= n) && (x > 0 && x <= m);
}

void BFS() {
	int cv = 0;
	queue<pair<int, int>> q;

	q.push(make_pair(1, 1));

	while (!q.empty()) {
		int cx = q.front().second;
		int cy = q.front().first;
		q.pop();
		cv = map[cy][cx];

		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (!isAccessable(ny, nx)) continue;

			if (map[ny][nx] == 1) {
				map[ny][nx] = cv + 1;
				q.push(make_pair(ny, nx));
			}
		}
	}
}


int main() {
	// ios_base::sync_with_stdio(false);
	// cin.tie(NULL); cout.tie(NULL);

	input();
	BFS();

	cout << map[n][m] << endl;

	return 0;
}