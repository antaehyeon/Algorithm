#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <queue>
#include <vector>
#include <tuple>
#include <utility>
#define VSIZE 100000

using namespace std;

int index;
vector <tuple<string, int, int, int>> studentInfo[VSIZE + 1];

bool nameSort(const tuple<string, int, int, int> &A,
			  const tuple<string, int ,int, int> &B) {
	return get<0>(A) < get<0>(B);
}

int main() {

	int n;

	cin >> n;
	
	for (int i = 0; i < n; i++) {

		string name;
		int korean, english, math;

		cin >> name;

		scanf("%d %d %d", &korean, &english, &math);

		studentInfo[i].push_back(make_tuple(name, korean, english, math));

	}

	sort(studentInfo->begin(), studentInfo->end(), nameSort);

	for (auto i : studentInfo) {
		cout << get<0>(i[0]) << endl;
	}

	//tuple<string, int, int, int> temp = studentInfo[0][0];
	//cout << get<0>(temp) << endl;

	return 0;
}