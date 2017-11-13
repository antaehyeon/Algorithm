#include <iostream>
#include <bitset>
#include <vector>
#include <string>
#include <cstring>
#include <algorithm>

using namespace std;

int main() {

	vector<int> data;
	vector<char> result;

	string dartResult = "";

	int r = 0;

	bool sharp = false;

	cin >> dartResult;

	for (int i = 0; i < dartResult.length(); i++) {
		int number = stoi(to_string(dartResult.at(i)));

		// 0 ~ 9 魄喊扼牢
		if (number >= 48 && number <= 57) {
			result.push_back(number - 48);
			continue;
		}
		
		// S老版快
		if (number == 83) continue;

		// D老版快
		if (number == 68) {
			int d = result.back();
			result.pop_back();
			result.push_back(pow(d, 2));
			continue;
		}
		// T老版快
		if (number == 84) {
			int d = result.back();
			result.pop_back();
			result.push_back(pow(d, 3));
			continue;
		}
		// *老版快
		if (number == 42) {
			int n = result.size();
			if (n == 1) {
				int d = result.back();
				result.pop_back();
				result.push_back(d * 2);
				continue;
			}
			int d = result.back();
			result.pop_back();
			int d2 = result.back();
			result.pop_back();
			if (sharp) {
				d2 *= -2;
				result.push_back(d2);
				d *= 2;
				result.push_back(d);
				continue;
			}
			d *= 2;
			result.push_back(d);
			d2 *= 2;
			result.push_back(d2);
			continue;
		}
		// #老版快
		if (number == 35) {
			sharp = true;
			int d = result.back();
			result.pop_back();
			result.push_back(-d);
			continue;
		}
	}

	for (int i = 0; i < result.size(); i++) {
		r += result.back();
		result.pop_back();
	}

	cout << r << endl;

	return 0;
}