#include <iostream>
#include <algorithm>
#include <vector>
#include <utility>

using namespace std;

struct info {
	int start;
	int end;
	int size;
};

bool compare(info a, info b) {
	return a.size > b.size;
}

int solution(vector<int> &A) {
	int start;
	int end;
	bool isFlag = false;
	vector<info> v;
	int size = A.size();

	for (int i = 1; i < size; i++) {
		if (isFlag) {
			if (A[i - 1] > A[i]) {
				isFlag = false;
				v.push_back({ start, end, end - start + 1 });
			}
			else {
				end = i;
			}
		}
		else {
			if (A[i - 1] < A[i]) {
				isFlag = true;
				start = i - 1;
				end = i;
			}
		}

		v.push_back({ i - 1, i, 1 });
	}

	v.push_back({ size-1, size-1, 1 });

	sort(v.begin(), v.end(), compare);

	// cout << v[0].start << endl;

	//for (auto t : v) {
	// 	cout << "start : " << t.start << " end : " << t.end << " size : " << t.size << endl;
	//}

	return v[0].start;
}


int main() {

	vector<int> A({ 2, 2, 2, 2, 1, 2, -1, 2, 1, 3 });
	vector<int> B({30, 20, 10 });

	cout << solution(A) << endl;

	return 0;
}