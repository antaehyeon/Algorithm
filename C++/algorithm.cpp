#include <iostream>
#include <algorithm>
#include <unordered_set>
#include <vector>

using namespace std;

int main() {
	vector<int> A;
	unordered_set<int> us;

	A.push_back(9);
	A.push_back(3);
	A.push_back(9);
	A.push_back(3);
	A.push_back(9);
	A.push_back(7);
	A.push_back(9);

	for (auto n : A) {
		auto a = us.find(n);
		
		if (a == us.end()) us.insert(n);
		else us.erase(a);
	}

	cout << *us.begin() << endl;
	return *us.begin();
}