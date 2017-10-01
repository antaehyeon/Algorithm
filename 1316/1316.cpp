/*
그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 

예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.

단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
*/

#include <iostream>
#include <string>
using namespace std;

bool continuedLetterCheck(string word);

int main() {
	// 변수 선언부
	int inputDataNumber = 0;
	int continuedLetterCount = 0;

	string inputLetterData = "";

	cin >> inputDataNumber;

	getline(cin, inputLetterData);

	for (int i = 0; i < inputDataNumber; i++) {
		getline(cin, inputLetterData);
		if (continuedLetterCheck(inputLetterData)) {
			continuedLetterCount++;
		}
	} // for

	cout << continuedLetterCount << endl;

	//system("pause");
	return 0;
} // main

bool continuedLetterCheck(string word) {
	
	int count = 0;
	int storedAlphabetNumber = 0;
	int stringLength = word.size();

	string storedAlphabetData[26] = { "", };
	string currentAlphabet = "";

	bool existLetter = false;

	for (int i = 0; i < stringLength; i++) {
		string letter = word.substr(i, 1);

		if (currentAlphabet == letter) {
			count++;
		}
		else {

			// 첫번 째 실수
			// 맨 처음에 storedAlphabetNumber 이 0 이기 때문에 FOR문에 들어가지 않음
			// 그래서 무조건 true로 리턴됨

			// 그래서 처음 초기조건을 생성함
			// storedAlphabetNumber == 0 : 아무것도 저장된것이 없을 경우
			// 첫 문자를 저장

			if (storedAlphabetNumber == 0) {
				storedAlphabetData[0] = letter;
				storedAlphabetNumber++;
				currentAlphabet = letter;
				continue;
			}

			//for (int i = 0; i < storedAlphabetNumber; i++) {
			//	if (storedAlphabetData[i] == letter) {
			//		return false;
			//	}
			//	else {
			//		storedAlphabetData[storedAlphabetNumber] = letter;
			//		storedAlphabetNumber++;
			//		break;
			//	}
			//} // for

			// 두번째 실수
			// FOR문 안에 if-else를 같이 구성시키다 보니
			// 배열을 전부 검사하는것이 아닌 한번만 검사하고 바로 else문으로 넘어가서
			// 제대로 된 검사가 되지 않았음
			// 그래서 구조를 변경

			for (int i = 0; i < storedAlphabetNumber; i++) {
				if (storedAlphabetData[i] == letter) {
					existLetter = true;
				}
			} // for

			if (existLetter) {
				return false;
			}
			else {
				storedAlphabetData[storedAlphabetNumber] = letter;
				storedAlphabetNumber++;
				existLetter = false;
			}
			currentAlphabet = letter;
		} // else
	} // for

	return true;
}