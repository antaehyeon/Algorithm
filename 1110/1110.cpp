#include <iostream>
using namespace std;

/*
0보다 크거나 같고, 99보다 작거나 같은 정수가 주어질 때 다음과 같은 연산을 할 수 있다. 

먼저 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고, 각 자리의 숫자를 더한다. 

그 다음, 주어진 수의 가장 오른쪽 자리 숫자와 앞에서 구한 합의 가장 오른쪽 자리 숫자를 이어 붙이면 새로운 수를 만들 수 있다. 다음 예를 보자.

26부터 시작한다. 2+6 = 8이다. 새로운 숫자는 68이다. 6+8 = 14이다. 새로운 숫자는 84이다. 8+4 = 12이다. 새로운 숫자는 42이다. 4+2 = 6이다. 새로운 숫자는 26이다.

위의 예는 4번만에 원래 숫자로 돌아올 수 있다. 따라서 26의 사이클의 길이는 4이다.

N이 주어졌을 때, N의 사이클의 길이를 구하는 프로그램을 작성하시오.
*/
int main() {

	// 변수 선언 부
	int originalInputData = 0;

	int a = 0, b = 0, c = 0, d = 0;
	int x = 0, y = 0;

	int cycle = 0;

	cin >> originalInputData;

	x = originalInputData;

	// 계산
	while (true) {
		if (x < 10) {
			a = 0; b = x;
		} else {
			a = x / 10; 
			b = x % 10;
		}

		y = a + b;

		if (y < 10) {
			c = 0; d = y;
		} else {
			c = y / 10;
			d = y % 10;
		}

		cycle++;

		a = b; b = d;

		x = (a * 10) + b;

		if (x == originalInputData) {
			cout << cycle << endl;
			break;
		} else continue;
	} // while (true)
	return 0;
}