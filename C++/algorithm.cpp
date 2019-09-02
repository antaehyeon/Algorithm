#include <iostream>
#include <algorithm>
#include <string.h>
#define endl "\n"
#define MAX 50

using namespace std;

int w, h, ans = 0;
int map[MAX][MAX];

int dx[8] = { 1, -1, 0, 0, -1, 1, 1, -1 };
int dy[8] = { 0, 0, 1, -1, -1, -1, 1, 1 };

void input() {
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			cin >> map[i][j];
		}
	}
}

bool isAccessable(int y, int x) {
	return (y >= 0 && y < h) && (x >= 0 && x < w);
}

void DFS(int y, int x) {
	map[y][x] = 2;

	for (int i = 0; i < 8; i++) {
		int nextX = x + dx[i];
		int nextY = y + dy[i];

		if (!isAccessable(nextY, nextX)) continue;

		if (map[nextY][nextX] == 1) {
			DFS(nextY, nextX);
		}
	}
}

void solution() {
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			
			if (map[i][j] == 1) {
				ans++;
				DFS(i, j);
			}

		}
	}
}

void reset() {
	for (int i = 0; i < h; i++) {
		memset(map[i], 0, sizeof(map[i]));
	}
	ans = 0;
}

int main() {
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	while (1) {
		cin >> w >> h;

		if (w == 0 && h == 0) break;

		input();
		solution();
		cout << ans << endl;
		reset();
	}

	



}