#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <utility>
#include <cstring>
#define MAX 21

using namespace std;

int n;
int map[MAX][MAX], tmp[MAX][MAX];
int size = 2;
int time = 0;
bool isEnd = false;
int upgradeCnt = 0;

int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };

struct pos {
	int y;
	int x;
	int s;
	int d;
};

vector<pos> sharks;
pos mainShark;


void input() {
	cin >> n;
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> map[i][j];
			if (map[i][j] == 9) {
				mainShark.y = i;
				mainShark.x = j;
				mainShark.s = 2;
			}
		}
	}
}

bool isAccessable(int y, int x) {
	return (y >= 0 && y < n) && (x >= 0 && x < n);
}

bool compare(pos p1, pos p2) {

	// return (p1.x < p2.x) && (p1.y < p2.y) && (p1.s < p2.s);

	return p1.x < p2.x;
}

bool compare2(pos p1, pos p2) {
	return p1.y < p2.y;
}

bool compare3(pos p1, pos p2) {
	return p1.d < p2.d;
}

void reset() {
	// vector<pos> sv;
	// sharks.swap(sv);
	// sharks.erase(sharks.begin(), sharks.end() + 1);
	sharks.clear();

	for (int i = 0; i < n; i++) {
		memset(tmp[i], 0, sizeof(tmp[i]));
	}
}

void BFS() {
	queue<pos> list;
	list.push({ mainShark.y, mainShark.x, mainShark.s });

	while (!list.empty()) {
		int x = list.front().x;
		int y = list.front().y;
		int v = tmp[y][x];
		list.pop();
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (!isAccessable(ny, nx)) continue;
			if (tmp[ny][nx] > 0) continue;
			if (map[ny][nx] > mainShark.s) continue;
			if (map[ny][nx] > 0 && map[ny][nx] != 9 && map[ny][nx] != mainShark.s) {
				sharks.push_back({ ny, nx, map[ny][nx], v+1 });
			}
			tmp[ny][nx] = v + 1;
			list.push({ ny, nx, map[ny][nx] });
		}
	}
}

void cal() {
	if (sharks.size() == 0) {
		isEnd = true;
		return;
	}

	sort(sharks.begin(), sharks.end(), compare);
	sort(sharks.begin(), sharks.end(), compare2);
	sort(sharks.begin(), sharks.end(), compare3);

	if (mainShark.s > sharks[0].s) {
		map[mainShark.y][mainShark.x] = 0;
		map[sharks[0].y][sharks[0].x] = mainShark.s;
		upgradeCnt++;
		time += sharks[0].d;
	}
	else {
		isEnd = true;
		return;
	}

	mainShark.y = sharks[0].y;
	mainShark.x = sharks[0].x;
	
	if (upgradeCnt == mainShark.s) {
		mainShark.s = upgradeCnt + 1;
		upgradeCnt = 0;
	}
}

void solution() {

	while (true) {
		BFS();
		cal();
		if (isEnd) break;
		reset();
	}
}


int main() {
	input();
	solution();

	cout << time;

	return 0;
}