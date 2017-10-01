// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

#include <iostream>
using namespace std;

int main() {

	int inputData = 0;

	cin >> inputData;

	int *arrayData = new int[inputData];

	for (int i = 0; i < inputData; i++) {
		cin >> arrayData[i];
	}

	for (int i = 0; i < inputData; i++) {
		for (int j = i+1; j < inputData; j++) {
			if (arrayData[i] > arrayData[j]) {
				int temp = arrayData[i];
				arrayData[i] = arrayData[j];
				arrayData[j] = temp;
			} // if
		} // for - j
	} // for - i

	for (int i = 0; i < inputData; i++) {
		cout << arrayData[i] << endl;
	}

	//system("pause");
	
	return 0;
}