#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#define MAX 1000

using namespace std;

struct pos {
	char mode;
	int degree;
};

struct loc {
	int x;
	int y;
};

int n;
pos map[MAX][MAX];
bool visit[MAX][MAX];
char curr;

int dx[4] = { 0, 1, 0, -1 };
int dy[4] = { -1, 0, 1, 0 };

char next(char p, char c) {
	if (p == 'F') return c;

	if (p == 'R') {
		if (c == 'F') return 'R';
		if (c == 'R') return 'B';
		if (c == 'L') return 'F';
		if (c == 'B') return 'L';
	}

	if (p == 'L') {
		if (c == 'F') return 'L';
		if (c == 'R') return 'F';
		if (c == 'L') return 'B';
		if (c == 'B') return 'R';
	}

	if (p == 'B') {
		if (c == 'F') return 'B';
		if (c == 'R') return 'L';
		if (c == 'L') return 'R';
		if (c == 'B') return 'F';
	}
}

loc adjustDirection(char mode, int degree, loc l) {

	if (mode == 'F') l.y -= degree;
	else if (mode == 'R') l.x += degree;
	else if (mode == 'L') l.x -= degree;
	else if (mode == 'B') l.y += degree;

	return l;
}

void solution() {
	int prev = 'B';
	int x = 0;
	int y = 0;

	while (true) {

		if (visit[y][x]) {
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cout << visit[i][j] << " ";
				}
				cout << endl;
			}

			cout << "[x: " << x << " y: " << y << "]\n";
			break;
		}

		visit[y][x] = true;
		char _curr = map[y][x].mode;
		cout << "[_curr: " << (char)_curr << "]\n";
		prev = next(prev, _curr);
		cout << "[next prev: " << (char)prev << "]\n";

		int _degree = map[y][x].degree;
		loc _nextL = adjustDirection(prev, _degree, { x, y });
		x = _nextL.x;
		y = _nextL.y;
	}
}

void input() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			string s;
			cin >> s;
			map[i][j] = { s[0], s[1] - '0' };
		}
	}
}

int main() {
	input();
	solution();
}

