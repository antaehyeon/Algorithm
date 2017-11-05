#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <queue>
#include <vector>
#include <tuple>
#include <utility>
#include <stdlib.h>
#define VSIZE 1000000

using namespace std;

int visit[10] = { 0, };

int main() {

	char strArr[VSIZE + 1];
	int x	  = 0,
		index = 0,
		max	  = 0;

	cin >> strArr;

	while (strArr[index] != '\0') {
		visit[(int)strArr[index++] - 48]++;
	}

	for (auto i : visit)
		if (i > max) max = i;

	if (max == visit[6] || max == visit[9]) {
		if (max % 2 == 1) {
			max = max / 2 + 1;
		}
		else {
			max = max / 2;
		}
	}

	cout << max;

	return 0;
}