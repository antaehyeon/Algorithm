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

class Student {
public:
	string name;
	int korean,
		english,
		math;

	Student(string name, int korean, int english, int math) {
		this->name = name;
		this->korean = korean;
		this->english = english;
		this->math = math;
	}
};

bool Student::operator>(Student &obj) {

}

vector <Student> v;

bool compare(const Student &a, const Student &b) {

	if ((a.korean == b.korean) && (a.english == b.english) && (a.math == b.math)) {
		return a < b;
	}
	else if (a.korean == b.english) {
		return a.math > b.math;
	}
	else if (a.korean == b.korean) {
		return a.english > b.english;
	}
	else {
		return a.korean > b.korean;
	}

}

int main() {
	ios_base::sync_with_stdio(false);

	int n;

	cin >> n;
	
	for (int i = 0; i < n; i++) {

		string name;
		int korean, english, math;

		cin >> name >> korean >> english >> math;
		//scanf("%d %d %d", &korean, &english, &math);

		v.push_back(Student(name, korean, english, math));
	}

	sort(v.begin(), v.end(), compare);

	for (auto i : v) {
		cout << i.name << endl;
	}

	/*cout << endl;

	for (int i = 0; i < v.size(); i++) {
		cout << v[i].name << endl;
	}*/

	system("pause");

	return 0;
}