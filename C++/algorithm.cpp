#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

bool isCollection(char s) {
	if (s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u') return true;
	return false;
}

string solution(string str) {
	string temp = "";
	
	for (int i=0; i<str.length(); i++) {
		if (!isCollection(str[i])) temp += str[i];
	}

	return temp;
}

int main() {

	int n;
	cin >> n;

	string str;

	for (int i=0; i<n; i++) {
		cin >> str;
		cout << "#" << i+1 << " " << solution(str) << endl;
	}

	return 0;
}