#include <iostream>
#include <algorithm>
#include <vector>
#include <cstdlib>
#include <climits>
#define N 1000000
using namespace std;


int main() {
    int prime[N];
    int pn = 0;
    bool check[N+1];
    for (int i=2; i*i<=N; i++) {
        if (!check[i]) {
            prime[pn++] = i;
            // 이쪽 for문은 N에 따라서 i*i 또는 i*2로 바꾸는 것이 좋다 (i가 백만인 경우 i*i는 범위를 넘어감)
            for(int j=i*i; j<=N; j+=i) check[j] = true;
        }
    }

    while(1) {
        bool flag = false;
        int n;
        scanf("%d", &n);

        if (n==0) break;

        for(int i : prime) {
            if (i == 2) continue;
            if (!check[n-i]) {
                flag = true;
                printf("%d = %d + %d\n", n, i, n-i);
                break;
            }
        }

        if (!flag) printf("Goldbach's conjecture is wrong.");
    }
}