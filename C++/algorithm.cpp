#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <utility>
#include <cstring>
#include <unordered_set>
#define MAX 100

using namespace std;

struct pos {
	int y;
	int x;
};

bool isEnd = false;
int n, l, r;
int map[MAX][MAX];
bool visit[MAX][MAX];
bool isTemp = false;
int ans = 0;
int sum = 0;
int cnt = 0;
vector<pos> land;

int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };

void input() {
	cin >> n >> l >> r;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> map[i][j];
		}
	}
}

bool isAccessable(int y, int x) {
	return (y >= 0 && y < n) && (x >= 0 && x < n);
}

void BFS(int y, int x) {
	if (visit[y][x]) return;
	queue<pos> q;

	q.push({ y, x });

	while (!q.empty()) {
		int cy = q.front().y;
		int cx = q.front().x;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int ny = cy + dy[i];
			int nx = cx + dx[i];

			if (!isAccessable(ny, nx)) continue;
			if (visit[ny][nx]) continue;

			int diff = abs(map[cy][cx] - map[ny][nx]);

			if (diff >= l && diff <= r) {
				land.push_back({ ny ,nx });
				visit[ny][nx] = true;
				sum += map[ny][nx];
				cnt++;
				q.push({ ny, nx });
			}
		}
	}
}

void process() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (visit[i][j]) {
				map[i][j] = (sum / cnt);
			}
		}
	}
}

void reset() {
	ans++;
	cnt = 0;
	sum = 0;
	memset(visit, false, sizeof(visit));
}

void calc() {
	if (land.size() == 0) return;
	int c = 0;
	int s = 0;
	for (pos l : land) {
		c++;
		s += map[l.y][l.x];
	}
	int value = s / c;
	for (pos l : land) {
		map[l.y][l.x] = value;
	}
	land.clear();
}

void solution() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			BFS(i, j);
			calc();
		}
	}
}

int main() {
	input();
	while (true) {
		solution();
		if (cnt == 0) break;
		//process();
		reset();
	}

	cout << ans;

	return 0;
}