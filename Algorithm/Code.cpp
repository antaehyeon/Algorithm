/*
A+B
A+B - 4 (https://www.acmicpc.net/problem/10951)
*/

#include <iostream>
#include <vector>

using namespace std;

int main() {

	int a = 0,
		b = 0;

	//vector <int> v;

	//while (scanf("%d %d", &a, &b) == 2) {

	//	v.push_back(a + b);
	//}

	//for (auto i : v) cout << i << endl;

	while (scanf("%d %d", &a, &b) == 2)
		cout << a + b << endl;

	return 0;

}