#include <iostream>
#include <string>
#include <string.h>

#include <array>

using namespace std;

int main() {

	// 변수 선언부
	int inputDataNumber = 0;		// 몇개의 데이터가 입력될 것인지 '맨 처음에' 받는 INT 변수
	int whileCount = 0;				// while문에서 count를 체크하기 위한 INT 변수

	array <int, 50> arrayCounts = { 0, };  // 각 배열에 들어간 갯수를 파악하기 위한 INT 배열(50)

	string *wordArray[50];			// 입력되는 단어를 받기위한 배열(최대 50자)- 이후 동적할당
	
	// 입력
	cin >> inputDataNumber;

	// 기능
	/* 1. 입력된 숫자(input Data)만큼 문자열을 입력받는다 */
	while (whileCount < inputDataNumber) {
		string tempWord = "";

		cin >> tempWord;

		int wordLength = tempWord.length();

		/* 1-1. 배열이 0부터 시작하므로 -1을 해서 0~49까지 맞춤
				그리고 메모리를 그나마 아끼기 위해 문자열의 길이에 해당하는 배열만 동적할당 */
		if (arrayCounts[wordLength - 1] == 0) {
			wordArray[wordLength - 1] = new string[inputDataNumber];
		}

		/* 2. 문자의 길이에 맞는 배열에 각자 삽입한다 */
		wordArray[wordLength - 1][arrayCounts[wordLength - 1]] = tempWord;

		/* 2-1. 각 배열마다 문자의 갯수를 파악하기 위해서 1을 증가시킴(= 단어 1개가 들어갔다) */
		arrayCounts[wordLength - 1] += 1;

		whileCount++;
	} // while

	whileCount = 0;

	/* 3. 각 배열마다 문자를 비교해서 정렬한다*/
	while (whileCount < 50) {
		string currentWord = "";
		int index = whileCount;

		// 각 배열에 아무것도 들어와 있지 않다면 (문자를 체크하는 배열의 카운트를 계산)
		if (arrayCounts[index] == 0) {
			whileCount++;
			continue;
		}

		// 배열의 크기 계산
		/*int arraySize = sizeof(wordArray[index]) / sizeof(*wordArray[index]);*/
		int arraySize = arrayCounts[index];
		
		// 각 배열 안에서 문자들을 정렬함
		for (int i = 0; i < arraySize; i++) {
			for (int j = i+1; j < arraySize; j++) {
				if (strcmp(wordArray[index][i].c_str(), wordArray[index][j].c_str()) >= 1) {
					swap(wordArray[index][i], wordArray[index][j]);
				} // if
			} // for
		} // for

		// 4. 출력
		for (int i = 0; i < arraySize; i++) {
			if (currentWord == wordArray[index][i]) continue;

			currentWord = wordArray[index][i];

			cout << currentWord << endl;
		} // for - i - arraySize
		whileCount++;
	} // while

	system("pause");

	return 0;
}