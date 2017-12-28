#include <iostream>
#include <vector>
#include <algorithm>
#include <string.h>
#include <cstring>
#include <string>

using namespace std;

/*
* Description :
* Time complexity :
* Space complexity :
*/
bool match(string &pat, string &s) {
	// TODO implement your codes to here.

	if (pat.compare(s) == 0) return true;
	else {

		vector<char> a;
		vector<char> b;

		char letter;

		for (auto c : pat) {
			a.push_back(c);
		}

		for (auto c : s) {
			b.push_back(c);
		}

		auto findQ = find(a.begin(), a.end(), '?');
		auto findS = find(a.begin(), a.end(), '*');

		if (findQ != a.end()) {
			for (int i = 0; i < pat.size(); i++) {
				if (!(pat[i] == s[i]))
					if (pat[i] == '?') continue;
					else return false;
			}
			return true;
		}

		else if (findS != a.end()) {
			for (int i = 0; i < a.size(); i++) {
				auto index = distance(a.begin(), findS);
				letter = a[index + 1];
				a.erase(a.begin() + index,a.begin() + index + 2);
			}
			int bSize = b.size();
			for (int i = 0; i < bSize-1; i++) {
				auto index = distance(b.begin(), find(b.begin(), b.end(), letter));
				b.erase(b.begin() + index);
			}

			for (int i = 0; i < a.size(); i++) {
				if (a[i] != b[i]) {}
				else return true;
			}

		}
		else return false;
	}
}

int main(int argc, const char *argv[]) {
	int TC;
	string pattern, target_string;
	cin >> TC;
	for (int t = 0; t < TC; t++) {
		cin >> pattern >> target_string;
		cout << (match(pattern, target_string) ? 'O' : 'X') << endl;
	}
	return 0;
}
