/*
NHN Ent 2017 Pre-Test 1차
NHN엔터의 모험
*/

#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <deque>
using namespace std;

int main() {

	deque<int> inven;
	vector<int> inputList;

	string inputData;

	int n, count = 0;

	getline(cin, inputData);

	for (auto a : inputData) {
		if (a == ' ') continue;
		
		int n = a - 48;

		auto f = find(inven.begin(), inven.end(), n);

		if (inven.size() == 3) {
			
			if (f == inven.end()) {
				cout << inven.front() << endl;
				count++;
				inven.pop_front();
				inven.push_back(n);
			}
			else {
				switch (distance(inven.begin(), f))
				{
				case 0:
					inven.pop_front();
					inven.push_back(n);
					break;
				case 1:
					swap(inven[1], inven[2]);
					break;
				default:
					break;
				}
			}
		}
		else {
			inven.push_back(n);
		}
	}

	if (count == 0) {
		cout << 0 << endl;
	}
}