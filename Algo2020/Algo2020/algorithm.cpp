#include <iostream>
#include <algorithm>
#include <queue>
#include <string>

using namespace std;

int timeCount = 0;
int map[101][101];
int dir[101][101];
int n, k, l, cX = 1, cY = 1;
int tx = 1, ty = 1;
int currentDirection = 0;

int xD[4] = { 1, 0, -1, 0 };
int yD[4] = { 0, 1, 0, -1 };

const int SNAKE = 10;
const int APPLE = 100;
const int SPACE = 0;
const int RIGHT_SIDE = 1;
const int LEFT_SIDE = 1;
const int L = -1;
const int D = -2;

struct rotateInfo {
	int time;
	string direction;
};

struct coordinate {
	int x;
	int y;
};

queue<rotateInfo> vri;
queue<coordinate> snakeQ;

bool checkInMap(int x, int y) {
	return (x > 0 && y > 0) && (x <= n && y <= n);
}

bool checkSnake(int x, int y) {
	return map[y][x] == SNAKE;
}

bool checkExistApple(int x, int y) {
	return map[y][x] == APPLE;
}

int rotateDirection(int currentDirection, string nextDirectionLetter) {
	if (nextDirectionLetter == "L") {
		if (currentDirection - LEFT_SIDE < 0) return 3;
		return currentDirection - LEFT_SIDE;
	}
	else if (nextDirectionLetter == "D") {
		return (currentDirection + RIGHT_SIDE) % 4;
	}
}

void printMap() {
	for (int i = 1; i <= 10; i++) {
		cout << endl;
		for (int j = 1; j <= 10; j++) {
			cout << map[i][j] << "  ";
		}
	}

	cout << "\n\n\n\n\n" << endl;
}

void processInput() {
	cin >> n >> k;

	for (int i = 0; i < k; i++) {
		int ax, ay;
		cin >> ay >> ax;
		map[ay][ax] = APPLE;
	}

	cin >> l;

	for (int i = 0; i < l; i++) {
		int t;
		string direction;

		cin >> t >> direction;
		vri.push({ t, direction });
	}

}

int main() {

	processInput();

	map[1][1] = SNAKE;
	dir[1][1] = 0;

	snakeQ.push({ 1, 1 });

	while (1) {
		timeCount++;

		// printMap();

		// if exist snake and out of map -> exit condition
		if (!checkInMap(cX + xD[currentDirection], cY + yD[currentDirection])) {
			cout << timeCount;
			break;
		}

		// set the next coordinate
		int nX = cX + xD[currentDirection];
		int nY = cY + yD[currentDirection];

		// check snake
		if (checkSnake(nX, nY)) {
			cout << timeCount;
			break;
		}

		// check exist apple
		if (!checkExistApple(nX, nY)) {

			int tailX = snakeQ.front().x;
			int tailY = snakeQ.front().y;

			map[tailY][tailX] = SPACE;
			snakeQ.pop();
		}

		// set the next snake coordinate
		map[nY][nX] = SNAKE;
		snakeQ.push({ nX, nY });


		// check timeCount (rotate Direction)
		if (vri.size() != 0 && vri.front().time == timeCount) {
			currentDirection = rotateDirection(currentDirection, vri.front().direction);
			vri.pop();
		}

		cX = nX; cY = nY;
	}
}