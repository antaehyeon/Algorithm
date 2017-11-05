#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <queue>
#include <vector>
#include <tuple>
#include <utility>
#define VSIZE 1000000

using namespace std;

int card[10] = { 0, };

int main() {

	string str;
	int x	  = 0,
		maxN  = 0;

	cin >> str;

	for (auto i : str)
		card[i - '0']++;

	for (int i = 0; i < 10; i++) {
		if (i == 6 || i == 9) continue;
		maxN = max(maxN, card[i]);
	}

	cout << max(maxN, (card[6] + card[9] + 1)/2);

	return 0;
}