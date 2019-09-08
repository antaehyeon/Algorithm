#include <iostream>
#include <algorithm>
#include <bitset>
#include <string>

using namespace std;

int main() {

	int ans = 0;
	int test = 1041;
	int cnt = 0;
	bool isFlag = false;

	cout << bitset<32>(test) << endl;

	string bitStr = bitset<32>(test).to_string();

	
	for (auto l : bitStr) {
		if (isFlag && l == '0') {
			cnt++;
		}
		else if (!isFlag && l == '1') {
			isFlag = true;
		}
		else {
			ans = ans > cnt ? ans : cnt;
			cnt = 0;
		}
	}

	cout << ans << endl;

	return 0;
}