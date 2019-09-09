#include <iostream>
#include <algorithm>
#include <set>
#include <deque>
#include <vector>
#include <string>
#include <sstream>

using namespace std;

vector<string> split(string str, char delimiter) {
	vector<string> internal;
	stringstream ss(str);
	string temp;

	while (getline(ss, temp, delimiter)) {
		internal.push_back(temp);
	}

	return internal;
}

string solution(string& message, int k) {
	string ans = "";
	vector<string> sv;
	int firstSpaceIdx = 987654321;
	bool isFlag = false;

	int len = message.length();

	if (len <= k) return message;

	for (int i = 0; i < k; i++) {
		ans += message[i];
		if (!isFlag && message[i] == ' ') {
			firstSpaceIdx = i;
			isFlag = true;
		}
	}

	if (ans.length() < firstSpaceIdx) return "";

	if (message[k-1] != ' ' && message[k] != ' ') {
		auto splited = split(ans, ' ');

		ans = "";

		if (splited.size() == 1) ans = splited[0];
		else {
			for (int i = 0; i < splited.size() - 1; i++) {
				ans += splited[i];

				if (splited.size() - 2 != i) ans += ' ';
			}
		}
	}

	if (ans[ans.length() - 1] == ' ') ans.erase(ans.length() - 1, 1);

	cout << ans << endl;
}


int main() {

	string test = "Codility we test corder";

	solution(test, 18);
	// solution(test, 2);
	// solution(test, 3);
	// solution(test, 4);
	// solution(test, 5);
	// solution(test, 6);
	// solution(test, 7);
	// solution(test, 8);
	// solution(test, 9);

	return 0;
}