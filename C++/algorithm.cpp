#include <iostream>
#include <algorithm>
#include <deque>
#include <vector>

using namespace std;

vector<int> test{ 3, 8, 9, 7, 6 };
int K = 3;

vector<int> solution(vector<int>& A, int K) {
	// write your code in C++14 (g++ 6.2.0)
	vector<int> empty;
	int len = A.size();

	if (len == 0) return empty;

	int r = K % len;

	deque<int> dq({ A.begin(), A.end() });
	
	for (int i = 0; i < r; i++) {
		int temp = dq.back();
		dq.pop_back();
		dq.push_front(temp);
	}

	return vector<int>({ dq.begin(), dq.end() });
}


int main() {
	
	for (auto i : solution(test, K)) {
		cout << i << " ";
	}

	return 0;
}