#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

bool compare(char a, char b) {
	return a > b;
}

int main() {
	string str;
	cin >> str;
	long long sum = 0;
	bool zero = false;

	for (auto c : str) {
		sum += (c - '0');
		if (!(c - '0')) zero = true;
	}

	if (sum % 3 || !zero) cout << -1;
	else {
		sort(str.begin(), str.end(), compare);
		cout << str;
	}


	return 0;
}