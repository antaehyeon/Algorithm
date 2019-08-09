#include <iostream>
#include <algorithm>
#define MAX 500
using namespace std;

int n, m;
int dY[4] = {0, 1, 0, -1};
int dX[4] = {1, 0, -1, 0};
int map[MAX][MAX];
bool visited[MAX][MAX] = {false, };

bool isInArrange(int y, int x) {
    return (0<=y && y<n) && (0<=x && x<m);
}

int DFS(int y, int x, int cnt) {
    if (cnt == 4) return map[y][x];
    int sum = 0;
    for (int i=0; i<4; i++) {
        int nextY = y + dY[i];
        int nextX = x + dX[i];

        if (isInArrange(nextY, nextX) && !visited[nextY][nextX]) {
            visited[nextY][nextX] = true;
            sum = max(sum, map[y][x] + DFS(nextY, nextX, cnt+1));
            visited[nextY][nextX] = false;
        }
    }
    return sum;
}

int middle(int y, int x) {
    int res=0;

    if (y>=1 && x>=1 && x<m-1) {
        res=max(res, map[y][x] + map[y][x-1] + map[y][x+1] + map[y-1][x]);
    }
    if (y>=1 && y<n-1 && x<m-1) {
        res = max(res, map[y][x] + map[y-1][x] + map[y+1][x] + map[y][x+1]);
    }
    if (x>=1 && y<n-1 && x<m-1) {
        res = max(res, map[y][x] + map[y][x-1] + map[y][x+1] + map[y+1][x]);
    }
    if (x>=1 && y>=1 && y<n-1) {
        res = max(res, map[y][x] + map[y-1][x] + map[y+1][x] + map[y][x-1]);
    }

    return res;
}

int main() {

    cin >> n >> m;
    
    for (int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
            cin >> map[i][j];
        }
    }

    int result = 0;
    for (int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
            visited[i][j] = true;
            result = max(result, DFS(i, j, 1));
            result = max(result, middle(i, j));
            visited[i][j] = false;
        }
    }

    cout << result;

    return 0;
}