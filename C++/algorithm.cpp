#include <iostream>
#include <algorithm>
#define MAX 22

int n, m, x, y, k;
int map[MAX][MAX];
int command[1002];
int dice[7] = { 0, };

int dx[4] = { 1, -1, 0 ,0 };
int dy[4] = { 0, 0, -1, 1 };

using namespace std;

void move() {
	for (int i = 0; i < k; i++) {
		int direction = command[i];
		int floorN = map[y][x];

		int nextX = x + dx[direction - 1];
		int nextY = y + dy[direction - 1];

		if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) continue;

		x = nextX; y = nextY;

		int top = dice[1];
		if (direction == 1) {
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = top;
		}
		else if (direction == 2) {
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = top;
		}
		else if (direction == 3) {
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[2];
			dice[2] = top;
		}
		else {
			dice[1] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = top;
		}

		if (map[y][x] == 0) map[y][x] = dice[6];
		else {
			dice[6] = map[y][x];
			map[y][x] = 0;
		}

		cout << dice[1];
		if (i != k - 1) cout << "\n";
	}
}

int main() {

	cin >> n >> m >> y >> x >> k;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
		}
	}
	for (int i = 0; i < k; i++) {
		cin >> command[i];
	}

	move();

	return 0;
}