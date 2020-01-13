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

queue<rotateInfo> vri;

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
		if (currentDirection - LEFT_SIDE == -1) return 3;
		return currentDirection - LEFT_SIDE;
	}
	else if (nextDirectionLetter == "D") {
		if (currentDirection + RIGHT_SIDE == 4) return 0;
		return currentDirection + RIGHT_SIDE;
	}
}

void processInput() {
	cin >> n >> k;

	for (int i = 0; i < k; i++) {
		int ax, ay;
		cin >> ax >> ay;
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

	map[0][0] = SNAKE;

	while (1) {
		timeCount++;

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

		// set the next snake coordinate
		map[nY][nX] = SNAKE;
		dir[cY][cX] = currentDirection;

		// checkExist
		if (!checkExistApple(cX, cY)) {
			map[ty][tx] = SPACE;
			int _direction = dir[ty][tx];

			ty += yD[_direction];
			tx += xD[_direction];
		}

		// check timeCount (rotate Direction)
		if (vri.size() != 0 && vri.front().time == timeCount) {
			currentDirection = rotateDirection(currentDirection, vri.front().direction);
			vri.pop();
		}

		cX = nX; cY = nY;
	}
}