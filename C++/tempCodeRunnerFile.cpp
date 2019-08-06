#include <iostream>
#include <algorithm>
#include <queue>
#define MAX 9
using namespace std;

int N, M;
int zeroCnt = 0;
int maxZero = 0;
int arr[MAX][MAX], tmp[MAX][MAX];
int dX[4] = {0, 1, 0, -1}, dY[4] = {1, 0, -1, 0};
queue<pair<int, int>> virusQ;

bool isInRange(int X, int Y) {
    return (0<=X && X<M) && (0<=Y && Y<N);
}

void BFS(int& zero) {
    int afterWall[MAX][MAX];
    memcpy(afterWall, tmp, sizeof(tmp));
    queue<pair<int, int>> Q = virusQ;
    int _zero = zero;

    while(!Q.empty()) {
        int X = Q.front().second;
        int Y = Q.front().first;
        Q.pop();

        for (int i=0; i<4; i++) {
            int nX = X + dX[i];
            int nY = Y + dY[i];

            if (!isInRange(nX, nY)) continue; 

            if (afterWall[nY][nX] == 0) {
                afterWall[nY][nX] = 2;
                _zero--;
                Q.push({nY, nX});
            }
        }
    }
    maxZero = max(maxZero, _zero);
}

void makeWall (int cnt, int& zero) {
    if (cnt == 3) {
        BFS(zero);
        return;
    }

    for (int i=0; i<N; i++) {
        for (int j=0; j<M; j++) {
            if (tmp[i][j] == 0) {
                tmp[i][j] = 1;
                zero--;
                makeWall(cnt + 1, zero);
                tmp[i][j] = 0;
                zero++;
            }
        }
    }
}


int main () {

    cin >> N >> M;
    for (int i=0; i<N; i++) {
        for (int j=0; j<M; j++) {
            cin >> arr[i][j];
            if (arr[i][j] == 0) zeroCnt++;
            else if (arr[i][j] == 2) {
                virusQ.push({i, j});
            }
        }
    }

    for (int i=0; i<N; i++) {
        for (int j=0; j<M; j++) {
            if (arr[i][j] == 0) {
                memcpy(tmp, arr, sizeof(arr));
                tmp[i][j] = 1;
                zeroCnt--;
                makeWall(1, zeroCnt);
                tmp[i][j] = 0;
                zeroCnt++;
            }
        }
    }

    cout << maxZero;

    return 0;
}