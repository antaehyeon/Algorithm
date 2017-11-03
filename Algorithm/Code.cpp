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

vector <Student> v;

bool CompareName(const Student &a, const Student &b) {
	return a.name < b.name;
}

bool CompareKorean(const Student &a, const Student &b) {
	return a.korean > b.korean;
}

bool CompareEnglish(const Student &a, const Student &b) {
	return a.english < b.english;
}

bool CompareMath(const Student &a, const Student &b) {
	return a.math < b.math;
}


int main() {

	int n;

	cin >> n;
	
	for (int i = 0; i < n; i++) {

		string name;
		int korean, english, math;

		cin >> name;
		scanf("%d %d %d", &korean, &english, &math);

		v.push_back(Student(name, korean, english, math));
	}

	sort(v.begin(), v.end(), CompareName);
	sort(v.begin(), v.end(), CompareMath);
	sort(v.begin(), v.end(), CompareEnglish);
	sort(v.begin(), v.end(), CompareKorean);

	for (auto i : v) {
		cout << i.name << endl;
	}

	cout << endl;

	/*for (int i = 0; i < v.size(); i++) {
		cout << v[i].name << endl;
	}*/

	system("pause");

	return 0;
}