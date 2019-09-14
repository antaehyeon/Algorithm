#include <iostream>
#include <algorithm>
#include <utility>
#include <string>

int ans = 987654321;

using namespace std;

void solution(string &str, int k) {
	int strSize = str.length();
	int cnt = 0;
	bool isFlag = false;
	string prevStr = str.substr(0, k);
	string nextStr = "";

	if (k == strSize) {
		ans = ans > cnt ? cnt : ans;
		return;
	}

	for (int i = k; i < strSize; i++) {
		nextStr += str[i];
		if (i % k == 0) {
			if (prevStr.length() > strSize - i) {
				cnt += (strSize - i);
			}

			if (prevStr != nextStr) {
				if (!isFlag) cnt += k;
				isFlag = false;
			}
			else if (prevStr == nextStr) {
				if (!isFlag) cnt += (k + 1);
				isFlag = true;
			}

			prevStr = nextStr;
			nextStr = "";
		}
	}

	ans = ans > cnt ? cnt : ans;
}

int main() {

	string t1 = "aabbaccc";

	for (int i = 1; i <= 8; i++) {
		solution(t1, i);
	}

	cout << ans << endl;


	return 0;
}