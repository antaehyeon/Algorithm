#include <iostream>
#include <algorithm>
#include <vector>
#define MAX 25

using namespace std;

int n, cnt = 0;
vector<int> v;
int map[MAX][MAX];

int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0 ,0, 1, -1 };

void input() {
	cin >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%1d", &map[i][j]);
		}
	}
}

bool isAccessable(int y, int x) {
	return (y >= 0 && y < n) && (x >= 0 && x < n);
}

void DFS(int y, int x) {
	map[y][x] = 2;
	for (int i = 0; i < 4; i++) {
		int nextX = x + dx[i];
		int nextY = y + dy[i];

		if (!isAccessable(nextY, nextX)) continue;

		if (map[nextY][nextX] == 1) {
			cnt++;
			DFS(nextY, nextX);
		}
	}
}

void solution() {

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			int data = map[i][j];

			if (data == 1) {
				cnt++;
				DFS(i, j);
				v.push_back(cnt);
				cnt = 0;
			}
		}
	}

}

void print() {

	cout << v.size() << endl;

	sort(v.begin(), v.end());

	for (auto i : v) {
		cout << i << endl;
	}

}

int main() {
	input();
	solution();
	print();

	return 0;
}