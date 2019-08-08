#include <iostream>
#include <algorithm>
#include <deque>
#define MAX 101

using namespace std;

int n, x, y, d, g, ans;
int map[MAX][MAX] = {0, };
int dX[4] = {1, 0, -1, 0};
int dY[4] = {0, -1, 0, 1};
deque<int> dq;


void Print(deque<int> deque) {
    while (!deque.empty()) {
        cout << deque.front() << " ";
        deque.pop_front();
    }
    cout << '\n';
}

void PrintMap() {
    for (int i=0; i<MAX; i++) {
        cout << "\n";
        for (int j=0; j<MAX; j++) {
            cout << map[i][j] << " ";
        }
    }
}

void makePath() {
    dq.push_back(d);

    for (int i=1; i<=g; i++) {
        for (int j=dq.size(); j>0; j--) {
            int b = dq.at(j-1)+1 == 4 ? 0 : dq.at(j-1)+1;
            // cout << "[push:" << b << "]\n";
            dq.push_back(b);
        }
        // Print(dq);
    }
    // cout << "[dq_size:" << dq.size() << "]\n";
}

void move() {
    map[y][x] = 1;
    while(!dq.empty()) {
        int t = dq.front();
        dq.pop_front();
        x = x + dX[t];
        y = y + dY[t];
        map[y][x] = 1;
    }
}

void checkSquare() {
    for (int i=1; i<MAX; i+=2) {
        for (int j=1; j<MAX; j++) {
            if (map[i][j] == 1 && map[i][j+1] == 1 && map[i+1][j] == 1 && map[i+1][j+1] == 1) ans++;
            if (map[i][j] == 1 && map[i-1][j] == 1 && map[i][j+1] == 1 && map[i-1][j+1] == 1) ans++;
        }
    }
}

int main() {

    cin >> n;

    for (int i=0; i<n; i++) {
        cin >> x >> y >> d >> g;
        makePath();
        move();
    }

    checkSquare();

    // PrintMap();

    cout << ans << "\n";

    return 0;
}