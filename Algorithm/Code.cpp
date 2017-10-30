#include <iostream>
#include <string>

using namespace std;

int main() {

	int n;
	int nameCount[26] = { 0, };
	bool check = false;

	cin >> n;

	for (int i = 0; i < n; i++) {
		char name[31];
		cin >> name;
		nameCount[name[0] - 97]++;
	}

	for (int i = 0; i < 26; i++) {
		if (nameCount[i] >= 5) {
			char letter = 'a' + i;
			cout << letter;
			check = true;
		}
	}

	if (!check) cout << "PREDAJA" << endl;

	system("pause");

	return 0;
}