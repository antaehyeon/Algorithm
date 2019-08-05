#include <iostream>
#include <algorithm>
#include <vector>
#include <climits>

using namespace std;

#define MAX 21

int N, answer = INT_MAX;
int S[MAX][MAX];
bool chk[MAX];

void DFS(int cur, int cnt) {
    if (cnt == N/2) {
        vector<int> linkTeam, startTeam;
        for (int i=0; i<N; i++) {
            if (chk[i]) startTeam.push_back(i);
            else linkTeam.push_back(i);
        }

        // cout << "[DFS] cur:" << cur << ", cnt:" << cnt << endl;
        // cout << "[DFS] startTeam.size: " << startTeam.size() << endl;
        // cout << "[DFS] linkTeam.size: " << linkTeam.size() << endl;

        int startStat=0, linkStat=0;
        for (int i=0; i<startTeam.size(); i++) {
            for (int j=i+1; j<startTeam.size(); j++) {
                int startX = startTeam[i], startY = startTeam[j];
                int linkX = linkTeam[i], linkY = linkTeam[j];
                startStat += S[startX][startY] + S[startY][startX];
                linkStat += S[linkX][linkY] + S[linkY][linkX];
            }
        }
        
        answer = min(answer, abs(startStat - linkStat));
        return;
    }

    for (int i=cur+1; i<N; i++) {
        if (!chk[i])  {
            chk[i] = true;
            DFS(i, cnt+1);
            chk[i] = false;
        }
    }
}

int main() {
    cin.tie(NULL); cout.tie(NULL);
    ios_base::sync_with_stdio(false);

    cin >> N;
    for (int i=0; i<N; i++)
        for (int j=0; j<N; j++)
            cin >> S[i][j];

    DFS(0, 0);
    cout << answer;


    return 0;
}