#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> solution(int N) {

	vector<int> ans;

	if (N == 1) {
		ans.push_back(0);
		return ans;
	}
	
	for (int i = 1; i <= N / 2; i++) ans.push_back(i);
	if (N % 2 != 0) ans.push_back(0);
	for (int i = 1; i <= N / 2; i++) ans.push_back(-i);

	return ans;
}


int main() {

	for (int i : solution(10)) {
		cout << i << " ";
	}

	//cout << solution(3) << endl;
	//cout << solution(4) << endl;
	//cout << solution(3) << endl;

	return 0;
}