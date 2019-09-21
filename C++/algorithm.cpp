#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
#include <deque>
#include <string>
#define MAX 1000

using namespace std;

struct Doc
{
	int pi;
	int start;
	int pn;
};

deque<Doc> docV;

int _time = 0;

bool compare(Doc d1, Doc d2) {
	if (d1.pn <= d2.pn) {
		if (d1.pn == d2.pn) {
			return d1.start < d2.start;
		}
		return true;
	}
	return false;
}

void solution3(vector<vector<int>> data) {
	int idx = 1;
	vector<int> ans;

	ans.push_back(1);
	_time += data[0][2]+1;

	while (data.size() != ans.size()) {
		if (_time >= data[idx][1]) {
			docV.push_back({ data[idx][0], data[idx][1], data[idx][2] });
			++idx;
		}
		else {

			if (docV.empty()) {
				_time++;
				continue;
			}

			cout << endl;
			sort(docV.begin(), docV.end(), compare);

			for (auto t : docV) {
				cout << "[i: " << t.pi << " start: " << t.start << " pn: " << t.pn << "]\n";
			}

			_time += (docV.front().pn+1);
			cout << "[time: " << _time << "]\n";
			ans.push_back(docV.front().pi);
			docV.pop_front();
		}
	}

	for (int seq : ans) {
		cout << seq << " ";
	}
}

string map[MAX][MAX];


int main() {

	solution3({ {1, 0, 5}, {2, 2, 2}, {3, 3, 1}, {4, 4, 1}, {5, 10, 2} });
	// solution3({ {1,0,3}, {2,1,3}, {3,3,2}, {4,9,1}, {5,10,2} });
	// solution3({ {1,2,10}, {2,5,8}, {3,6,9}, {4,20,6}, {5,25,5} });

	// solution2({ "######", ">#*###", "####*#", "#<#>>#", ">#*#*<", "######" });
	
	return 0;
}