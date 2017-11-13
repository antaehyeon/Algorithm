#include <iostream>
#include <bitset>
#include <vector>

using namespace std;

int main() {

	vector<int> map1;
	vector<int> map2;

	int n = 0,
		data = 0;

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> data;
		map1.push_back(data);
	}

	for (int i = 0; i < n; i++) {
		cin >> data;
		map2.push_back(data);
	}

	for (int i = 0; i < n; i++) {
		// 비트셋은 정확한 숫자를 입력해야함, 문자로 초기화 안됨
		bitset<16> data1(map1[i]);
		bitset<16> data2(map2[i]);
		bitset<16> result = (data1 | data2);

		for (int j = n-1; j >= 0; j--) {
			if (result[j] == 1) cout << "#";
			else				cout << " ";
		}

		cout << endl;

	}

	return 0;
}