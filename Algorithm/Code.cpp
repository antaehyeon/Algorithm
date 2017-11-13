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

	int r = 0,
		size = 0;

	cin >> dartResult;

	for (int i = 0; i < dartResult.length(); i++) {
		int number = stoi(to_string(dartResult.at(i)));

		// 0 ~ 9 �Ǻ�����
		if (number >= 48 && number <= 57) {
			result.push_back(number - 48);
			// ���� 10�ϰ��
			if (stoi(to_string(dartResult.at(i + 1))) == 48) {
				result.pop_back();
				result.push_back(10);
				i++;
			}
			continue;
		}
		
		// S�ϰ��
		if (number == 83) continue;

		// D�ϰ��
		if (number == 68) {
			int d = result.back();
			result.pop_back();
			result.push_back(pow(d, 2));
			continue;
		}
		// T�ϰ��
		if (number == 84) {
			int d = result.back();
			result.pop_back();
			result.push_back(pow(d, 3));
			continue;
		}
		// *�ϰ��
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
			d2 *= 2;
			result.push_back(d2);
			d *= 2;
			result.push_back(d);
			continue;
		}
		// #�ϰ��
		if (number == 35) {
			int d = result.back();
			result.pop_back();
			result.push_back(-d);
			continue;
		}
	}

	size = result.size();

	for (int i = 0; i < size; i++) {
		r += result.back();
		result.pop_back();
	}

	cout << r << endl;

	return 0;
}