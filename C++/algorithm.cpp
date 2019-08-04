#include <iostream>
#include <algorithm>
#define MAX 100

using namespace std;
int N, L, ans=0, i, j, c, cur, next;
int arr[MAX*2][MAX];

int main() {
    cin >> N >> L;

    for (i=0; i<N; i++)
        for (j=0; j<N; j++)
            cin >> arr[i][j];
    
    for (i=0; i<N; i++)
        for (j=0; j<N; j++)
            arr[i+N][j] = arr[j][i];

    for (i=0; i<N*2; i++) {
        c=1;
        for (j=0; j<N-1; j++) {
            cur = arr[i][j];
            next = arr[i][j+1];
            if (cur == next c++;
            else if (cur+1 == next && c >= L) c=1;
            else if (cur-1 == next && c >= 0) c = -L+1;
            else break;
        }
        if (j == N-1 && c >= 0) ans++;
    }
    cout << ans;
    return 0;
}