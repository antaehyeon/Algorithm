#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

int money, ans = 0;
int coinList[6] = { 500, 100, 50, 10, 5, 1 };

int main() {
	cin >> money;
	int targetMoney = 1000 - money;

	int a;

	for (int i = 0; i < 6; i++) {
		ans += (targetMoney / coinList[i]);
		targetMoney %= coinList[i];
		if (targetMoney == 0) break;
	}

	cout << ans;
	
	return 0;
}