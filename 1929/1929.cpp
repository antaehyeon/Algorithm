#include <iostream>
#include <time.h>

using namespace std;

void getChe1(int start, int dest);
void getChe2(int start, int dest);

// 문제번호 1929
// 소수 구하기
// https://www.acmicpc.net/problem/1929
//int main() {
//
//	// VARIABLE
//	int inputNumberOne = 0;
//	int inputNumberTwo = 0;
//	int numberOfRepeat = 0;
//
//	// INPUT
//	cin >> inputNumberOne >> inputNumberTwo;
//
//	// FUNCTION
//	for (int i = inputNumberOne; i <= inputNumberTwo; i++) {
//		if (i == 1) continue;
//		if (i < 10) {
//			if (i == 2 || i == 3 || i == 5 || i == 7) {
//				cout << i << endl;
//				continue;
//			} // if 
//		} // if i < 10
//			
//		if (((i % 2) == 0) || ((i % 3) == 0) || ((i % 5) == 0) || ((i % 7) == 0)) continue;
//		else																	  cout << i << endl;
//	} // for
//	
//	system("pause");
//
//	return 0;
////}

//int main() {
//	clock_t start, end;
//	
//	int inData1, inData2;
//
//	cin >> inData1 >> inData2;
//
//	start = clock();
//	getChe1(inData1, inData2);
//	end = clock();
//
//	double time = (double)(end - start) / CLOCKS_PER_SEC;
//	cout << "수행시간 : " << time;
//
//	system("pause");
//	
//	return 0;
//}
//
//void getChe1(int start, int dest) {
//	int *arr;
//	int *arr2;
//
//	int count = 0;
//	
//	arr = (int *)malloc(sizeof(int) * dest);
//	arr2 = (int *)malloc(sizeof(int) * dest);
//
//	for (int i = 2; i <= dest; i++) {
//		arr[i] = i;
//	}
//
//	arr[0] = 0;
//
//	for (int i = 2; i <= dest; i++) {
//		if (arr[i] == 0) continue;
//		
//		for (int j = i + i; j <= dest; j += i) {
//			arr2[count] = arr[i];
//		}
//
//		count++;
//	}
//
//	//for (int i = 2; i <= dest; i++) {
//	//	if (i >= start && arr[i] != 0) {
//	//		cout << arr[i] << endl;
//	//		//cout << arr[i] << endl;
//	//	}
//	//}
//
//	for (int i = 0; i < count; i++) {
//		cout << arr2[i] << endl;
//	}
//}
//
//void getChe2(int start, int dest) {
//	int *arr;
//	arr = (int *)malloc(sizeof(int) * dest);
//
//	for (int i = 2; i <= dest; i++) {
//		arr[i] = i;
//	}
//
//	for (int i = 2; i <= dest; i++) {
//		for (int j = 2; j <= dest; j++) {
//			if (arr[j] != i && arr[j] % i == 0) {
//				arr[j] = 0;
//			}
//		}
//	}
//
//	for (int i = 2; i <= dest; i++) {
//		if (i >= start && arr[i] != 0) {
//			cout << arr[i] << endl;
//		}
//	}
//}

// 에라스토테네스체 알고리즘
// 소수 구하는데 가장 많이 사용
int main() {
	// 변수 선언부
	int *array;
	int start, dest;

	cin >> start >> dest;

	array = new int[dest + 1];

	// 초기화
	for (int i = 0; i <= dest; i++) {
		array[i] = i;
	} // for

	for (int i = 2; i <= dest; i++) {
		for (int j = 2; j*i <= dest; j++) {
			if (array[j*i] == 0) continue;
			array[j*i] = 0;
		} // for j
	} // for i

	for (int i = start; i <= dest; i++) {
		if (array[i] == 0 || i == 1) continue;
		cout << array[i] << endl;
	}

	system("pause");


} // main