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

struct Student {
	string name;
	int korean, english, math;
	Student(int x = 0, int y = 0, int z = 0):korean(x), english(y), math(z) {}
};

int main() {
	ios_base::sync_with_stdio(false);

	int n;
	cin >> n;

	vector<Student> v(n);

	for (auto &x : v) cin >> x.name >> x.korean >> x.english >> x.math;
	
	sort(v.begin(), v.end(), [](const Student &x, const Student &y) -> bool {
		if (x.korean != y.korean) return x.korean > y.korean;
		if (x.english != y.english) return x.english < y.english;
		if (x.math != y.math) return x.math > y.math;
		return x.name < y.name;
	});

	for (auto &x : v) cout << x.name << '\n';

	system("pause");

	return 0;
}