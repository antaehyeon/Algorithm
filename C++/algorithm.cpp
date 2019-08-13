#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
#define MAX 100

using namespace std;

int r, c, k, ans=-1;
int map[MAX][MAX] = {0, };
int cntArr[MAX] = {0, };

void Print() {
    cout << "#####################################\n";
    for (int i=0; i<MAX; i++) {
        cout << "\n";
        for (int j=0; i<MAX; j++) {
            cout << map[i][j] << " ";
        }
    }
    cout << "#####################################\n";
}

void Input() {
    cin >> r >> c >> k;
    for(int i=0; i<3; i++) {
        for (int j=0; j<3; j++) {
            cin >> map[i][j];
        }
    }
}

void Solution() {
    int hang=3, yul=3;
    int size = 0;

    if (hang >= yul) {
        for (int i=0; i<hang; i++) {
            vector<pair<int ,int>> V;
            memset(cntArr, 0, sizeof(cntArr));
            for (int j=0; j<yul; j++) cntArr[map[i][j]]++;
            for (int j=0; j<MAX; j++) {
                if (cntArr[j] == 0) continue;
                V.push_back(make_pair(cntArr[j], j));
            }
            sort(V.begin(), V.end());
            for (int j=0; j<yul; j++) map[i][j]=0;
            size = size > V.size() ? size : V.size();
            for (int j=0; j<size; j+=2) {
                int cnt=V[j/2].first;
                int num=V[j/2].second;
                map[i][j]=num;
                map[i][j+1]=cnt;
            }
        }
    } else {
        for (int i=0; i<yul; i++) {
            vector<pair<int ,int>> V;
            memset(cntArr, 0, sizeof(cntArr));
            for (int j=0; j<hang; j++) cntArr[map[j][i]]++;
            for (int j=0; j<MAX; j++) {
                if (cntArr[j] == 0) continue;
                V.push_back(make_pair(cntArr[j], j));
            }
            sort(V.begin(), V.end());
            for (int j=0; j<hang; j++) map[j][i]=0;
            size = size > V.size() ? size : V.size();
            for (int j=0; j<size; j+=2) {
                int cnt=V[j/2].first;
                int num=V[j/2].second;
                map[j][i] = num;
                map[j+1][i] = cnt;
            }
        }
    }
    ans++;
}

bool Check() {
    if (map[r][c] == k) return true;
    else if (ans > 100) {
        ans = -1;
        return true;
    }
    return false;
}

int main () {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);

    Input();
    while(1) {
        if (Check()) break;
        Solution();
        // Print();
    }

    cout << ans;
    return 0;
}