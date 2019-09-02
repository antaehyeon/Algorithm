#include <iostream>
#include <algorithm>
#include <utility>
#include <string.h>
#include <queue>
#define endl "\n"
#define MAX 1001

using namespace std;

int n, m, ans = 0;
int map[MAX][MAX];
queue<pair<int, int>> q;

int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };

void input() {
	cin >> m >> n;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			cin >> map[i][j];
			if (map[i][j] == 1) {
				q.push(make_pair(i, j));
			}
		}
	}
}

bool isAccessable(int y, int x) {
	return (y > 0 && y <= n) && (x > 0 && x <= m);
}

void BFS() {
	int cv = 0;

	while (!q.empty()) {
		int cx = q.front().second;
		int cy = q.front().first;
		q.pop();
		cv = map[cy][cx];

		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (!isAccessable(ny, nx)) continue;

			if (map[ny][nx] == 0) {
				map[ny][nx] = cv + 1;
				q.push(make_pair(ny, nx));
			}
		}
	}
}

void print() {
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (map[i][j] == 0) {
				ans = -1;
				return;
			}
			else {
				ans = max(ans, map[i][j]);
			}
		}
	}
}


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	input();
	BFS();
	print();

	ans = ans == -1 ? -1 : ans - 1;
	cout << ans << endl;

	return 0;
}