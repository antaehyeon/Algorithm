// N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.

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