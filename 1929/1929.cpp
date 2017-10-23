#include <iostream>

using namespace std;


// 문제번호 1929
// 소수 구하기
// https://www.acmicpc.net/problem/1929
int main() {

	// VARIABLE
	int inputNumberOne = 0;
	int inputNumberTwo = 0;
	int numberOfRepeat = 0;

	// INPUT
	cin >> inputNumberOne >> inputNumberTwo;

	// FUNCTION
	for (int i = inputNumberOne; i <= inputNumberTwo; i++) {
		if (i < 10) {
			if (i == 1 || i == 2 || i == 3 || i == 5 || i == 7) cout << i << endl;
			else												continue;
		} // if i < 10

		if (((i % 2) > 0) || ((i % 3) > 0)) continue;
		else								cout << i << endl;
	} // for
	
	system("pause");

	return 0;
}