#include <iostream>
#include <algorithm>
#include <deque>
#include <stdio.h>

#define cw 1
#define ccw -1


using namespace std;

int k, a, b, ans=0;
bool isSpin[5] = {false, };
int isDirection[5] = {0, };
deque<int> w[5];

void Input() {
    for(int i=1; i<5; i++) {
        for (int j=0; j<8; j++) {
            int t;
            scanf("%1d", &t);
            w[i].push_back(t);
        }
    }
}

void Print() {
    cout << "\n";
    for (int i=1; i<5; i++) {
        for (int j=0; j<8; j++) {
            cout << w[i].at(j) << " ";
        }
        cout << "\n";
    }
}

void Spin(int idx, int mode) {
    // cout << "Spin [idx:" << idx << "][mode:" << mode << "]\n";
    if (mode == cw) {
        int t = w[idx].back();
        w[idx].pop_back();
        w[idx].push_front(t);
    } else {
        int t = w[idx].front();
        w[idx].pop_front();
        w[idx].push_back(t);
    }
}

void processSpin() {
    for (int i=1; i<5; i++) {
        if (isSpin[i]) {
            Spin(i, isDirection[i]);
        }
    }
    for (int i=1; i<5; i++) {
        isSpin[i] = false;
        isDirection[i] = 0;
    }
}

void left(int current, int mode) {
    // cout << "left [current:" << current << "][mode:" << mode << "]\n";
    // if (current < 1) return;

    if (current == 1) {
        isSpin[current] = true;
        isDirection[current] = mode;
        return;
    }

    int cwv = w[current].at(6);
    int pwv = w[current-1].at(2);

    // cout << "LEFT [cwv:" << cwv << "][pwv:" << pwv << "]\n";

    if (cwv != pwv) {
        left(current-1, (mode == cw) ? ccw : cw);
        isSpin[current] = true;
        isDirection[current] = mode;
    }
}

void right(int current, int mode) {
    // cout << "right [current:" << current << "][mode:" << mode << "]\n";
    // if (current >= 4) return;
    
    if (current == 4) {
        isSpin[current] = true;
        isDirection[current] = mode;
        return;
    }

    int cwv = w[current].at(2);
    int pwv = w[current+1].at(6);

    // cout << "RIGHT [cwv:" << cwv << "][pwv:" << pwv << "]\n";

    if (cwv != pwv) {
        right(current+1, (mode == cw) ? ccw : cw);
        isSpin[current] = true;
        isDirection[current] = mode;
    }
}

void calResult() {
    // N-0, S-1
    if (w[1].at(0) == 1) ans += 1;
    if (w[2].at(0) == 1) ans += 2;
    if (w[3].at(0) == 1) ans += 4;
    if (w[4].at(0) == 1) ans += 8;
}

int main() {
    Input();
    // Print();

    cin >> k;
    for (int i=0; i<k; i++) {
        cin >> a >> b;
        left(a, b);
        right(a, b);
        isSpin[a] = true;
        isDirection[a] = b;
        processSpin();

        // Print();
    }

    calResult();

    cout << ans;
}