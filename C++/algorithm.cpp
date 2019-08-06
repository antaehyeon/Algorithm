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

void Print() {
    for (int i=0; i<N; i++) {
        cout << "\n";
        for (int j=0; j<M; j++) {
            cout << arr[i][j] << " ";
        }
    }
    cout << "\n";
}

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

void moveBack(int p) {
    if (p==0) r++;
    else if (p==1) c--;
    else if (p==2) r--;
    else c++;
}

void movePosition(int cnt, int p) {
    if (cnt == 4) {
        int b = backDirection(p);
        if (arr[r+dY[b]][c+dX[b]] == 1) {
            isExit = true;
        } else {
            moveBack(p);
        }
        return;
    }

    int nD = calDirection(p);

    int nR = r + dY[nD];
    int nC = c + dX[nD];

    if (arr[nR][nC] == 0) {
        d = nD;
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

    for (int i=0; i<N; i++) {
        for (int j=0; j<M; j++) {
            if (arr[i][j] == -1) res++;
        }
    }
            
    cout << res;
    return 0;
}