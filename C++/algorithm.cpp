#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <utility>
#include <string.h>
#define MAX 50
using namespace std;

int R, C, T;
int arr[MAX][MAX], tmp[MAX][MAX];
int dY[] = {1, 0, -1, 0};
int dX[] = {0, 1, 0, -1};
int cw[4] = {1, 0, 3, 2};
int ccw[4] = {1, 2, 3, 0};
queue<pair<int, int>> airQ;
queue<pair<int, int>> dustQ;
pair<int, int> firstAirQ;
pair<int, int> secondAirQ;

int isInArrRange(int X, int Y) {
    return (0 <= X && X < C) && (0 <= Y && Y < R);
}

void Print() {
    // cout << "-----------------------" << endl;
    for (int i=0; i<R; i++) {
        for (int j=0; j<C; j++) {
            cout << arr[i][j] << " ";
        }
        cout << "\n";
    }
    cout << "-----------------------" << endl;
}

void makeDustQ() {
    for (int i=0; i<R; i++) {
        for (int j=0; j<C; j++) {
            if (arr[i][j] >= 1) dustQ.push({i, j});
        }
    }
}

void BFS() {
    memcpy(tmp, arr, sizeof(arr));
    while (!dustQ.empty()) {
        int X = dustQ.front().second;
        int Y = dustQ.front().first;
        dustQ.pop();

        int virus = tmp[Y][X] / 5; // 여기에 임시배열을 쓰지 않으면 결과값이 이상하게 출력됨
        for (int i=0; i<4; i++) {
            int nextX = X + dX[i];
            int nextY = Y + dY[i];

            if (isInArrRange(nextX, nextY)) {
                if (tmp[nextY][nextX] >= 0) { // 여기에 임시배열을 쓰지 않으면 결과값이 이상하게 출력됨
                    arr[nextY][nextX] += virus;
                    arr[Y][X] -= virus;
                }
            }
        }
    }
}

void cleaning() {
    memcpy(tmp, arr, sizeof(arr));
    int X = firstAirQ.second+1;
    int Y = firstAirQ.first;
    arr[Y][X] = 0;

    for (int i=0; i<4; i++) {
        // cout << Y << "," << X << endl;
        while(1) {
            int nextX = X + dX[ccw[i]];
            int nextY = Y + dY[ccw[i]];
            // cout << dX[ccw[i]] << ", " << dY[ccw[i]] << endl;
            // cout << nextX << ", " << nextY << endl;

            if (nextX == firstAirQ.second && nextY == firstAirQ.first) break;
            if (!isInArrRange(nextX, nextY)) break;

            arr[nextY][nextX] = tmp[Y][X];
            X = nextX;
            Y = nextY;
        }
    }
}

void cleaning2() {
    memcpy(tmp, arr, sizeof(arr));
    int X = secondAirQ.second+1;
    int Y = secondAirQ.first;
    arr[Y][X] = 0;

    for (int i=0; i<4; i++) {
        while(1) {
            int nextX = X + dX[cw[i]];
            int nextY = Y + dY[cw[i]];

            if (nextX == secondAirQ.second && nextY == secondAirQ.first) break;
            if (!isInArrRange(nextX, nextY)) break;

            arr[nextY][nextX] = tmp[Y][X];
            Y = nextY;
            X = nextX;
        }
    }
}

int main () {
    int result = 0;
    cin >> R >> C >> T;

    for (int i=0; i<R; i++) {
        for (int j=0; j<C; j++) {
            cin >> arr[i][j];
            // 만약 공기청정기의 좌표라면 보관
            if (arr[i][j] == -1) airQ.push({i, j});
        }
    }

    firstAirQ = airQ.front();
    airQ.pop();
    secondAirQ = airQ.front();
    airQ.pop();

    for (int i=0; i<T; i++) {
        // cout << i << "번 째 --------------------" <<endl;
        // Print();
        makeDustQ();
        BFS(); // 미세먼지 확산을 동시에 일으킴
        cleaning();
        cleaning2();
    }

    for (int i=0; i<R; i++) {
        for (int j=0; j<C; j++) {
            if (arr[i][j] >= 1) result += arr[i][j];
        }
    }

    cout << result;

    return 0;
}