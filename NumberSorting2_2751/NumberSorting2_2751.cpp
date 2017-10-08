#include <iostream>
using namespace std;

void quickSort(int dataSet[], int left, int right);

int main() {
	// 변수 선언 부
	int *dataSet;
	int inputDataNumber;

	// INPUT
	cin >> inputDataNumber;
	
	// INIT
	dataSet = new int[inputDataNumber];

	for (int i = 0; i < inputDataNumber; i++) {
		cin >> dataSet[i];
	}

	quickSort(dataSet, 0, inputDataNumber - 1);

	for (int i = 0; i < inputDataNumber; i++) {
		cout << dataSet[i] << endl;
	}

	//system("pause");

	return 0;
}

void quickSort(int dataSet[], int left, int right) {
	int i = left, j = right;
	int tmp;
	int pivot = dataSet[(left + right) / 2];

	/* partition */
	while (i <= j) {
		while (dataSet[i] < pivot)
			i++;
		while (dataSet[j] > pivot)
			j--;
		if (i <= j) {
			tmp = dataSet[i];
			dataSet[i] = dataSet[j];
			dataSet[j] = tmp;
			i++;
			j--;
		} // if
	};

	/* recursion */
	if (left < j)
		quickSort(dataSet, left, j);
	if (i < right)
		quickSort(dataSet, i, right);
}