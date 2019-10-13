#include <iostream>
#include <algorithm>
#include <utility>
#include <vector>
#include <queue>

using namespace std;

bool sorted(int a, int b) {
	return a > b;
}

int calc(vector<int> v) {
	int res = 0;
	
	for (int i = 0; i < v.size()-1; i++) {
		res += abs(v[i] - v[i + 1]);
	}

	return res;
}

int solution(int v[], int vLen) {

	vector<int> des;
	vector<int> asc;
	vector<int> res;

	for (int i = 0; i < vLen; i++) {
		des.push_back(v[i]);
		asc.push_back(v[i]);
	}

	sort(des.begin(), des.end(), sorted);
	sort(asc.begin(), asc.end());

	cout << des[0] << endl;

	for (int i = 0; i < vLen/2; i++) {
		res.push_back(asc[i]);
		res.push_back(des[i]);
	}

	for (auto n : res) cout << n << " ";

	return calc(res);
}

int solution2(int v[], int vLen) {
	
	int res = -1;
	vector<int> t(v, v + vLen);
	sort(t.begin(), t.end());

	do {
		int sum = calc(t);
		res = sum > res ? sum : res;
	} while (next_permutation(t.begin(), t.end()));

	return res;
}

int main() {

	int v[] = { 20,8,10,1,4,15 };

	cout << solution2(v, 6) << endl;

	return 0;
}