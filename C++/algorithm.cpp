#include <iostream>
#include <algorithm>
#include <queue>
#define MAX 51

using namespace std;
int N, M;
int r, c, d;
int currentD;

int arr[MAX][MAX];
int dX[4] = {0, 1, 0, -1};
int dY[4] = {-1, 0, 1, 0};

bool isExit = false;

int calDirection(int p) {
    if (p == 0) return 3;
    else if (p == 3) return 2;
    else if (p == 2) return 1;
    else return 0;
}

int backDirection(int p) {
    if (p==0) return 2;
    else if (p==2) return 0;
    else if (p==3) return 1;
    else return 3;
}

void moveBackTwoStep(int p) {
    if (p==0) r+=2;
    else if (p==1) c-=2;
    else if (p==2) r-=2;
    else c+=2;
}

void movePosition(int cnt, int p) {
    if (cnt == 5) {
        int b = backDirection(p);
        if (arr[r+dY[b]][c+dX[b]] != 0) {
            isExit = true;
        } else {
            moveBackTwoStep(p);
        }
        return;
    }

    int nD = calDirection(p);


    int nR = r + dY[nD];
    int nC = c + dX[nD];

    if (arr[nR][nC] == 0) {
        r = nR;
        c = nC;
    } else {
        movePosition(cnt+1, nD);
    }
    return;
}

int main() {
    int res = 0;

    cin >> N >> M;
    cin >> r >> c >> d;

    for (int i=0; i<N; i++) {
        for (int j=0; j<M; j++) {
            cin >> arr[i][j];
        }
    }

    while(1) {
        arr[r][c] = -1;
        movePosition(0, d);
        if (isExit) break;
    }

    for (int i=0; i<N; i++)
        for (int j=0; j<M; j++)
            if (arr[i][j] == -1) res++;

    cout << res;
    return 0;
}