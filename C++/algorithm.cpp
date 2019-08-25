#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int main() {

	int n, score, sum =0;
	cin >> n;

	for (int i=0; i<n; i++) {
		for(int j=0; j<5; j++) {
			cin >> score;
			if (score <= 40) sum += 40;
			else sum += score;
		}
		cout << "#" << i+1 << " " << sum/5 << endl;
		sum = 0;
	}

	return 0;
}