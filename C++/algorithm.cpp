#include <iostream>
#include <algorithm>
#include <vector>
#include <utility>
#include <math.h>
#define MAX 51
#define INF 987654321

using namespace std;

int n, m, ans = INF;
int map[MAX][MAX];
vector<pair<int, int>> homeList;
vector<pair<int, int>> chickenList;
vector<vector<int>> permutation;

int calAbs(int a, int b, int c, int d) {
	int t1 = a > b ? (a - b) : (b - a);
	int t2 = c > d ? (c - d) : (d - c);

	return t1 + t2;
}

void cal(vector<pair<int, int>> v) {

	int res = 0;
	int cnt = INF;

	for (pair<int, int> home : homeList) {
		for (pair<int, int> c : v) {
			cnt = min(cnt, calAbs(home.first, c.first, home.second, c.second));
		}
		res += cnt;
		cnt = INF;
	}

	ans = min(ans, res);
}


void solution(vector<int> v) {

	vector<pair<int, int>> cl;
	for (int idx : v) {
		cl.push_back(make_pair(chickenList[idx].first, chickenList[idx].second));
	}
	cal(cl);
}

void check() {
	vector<int> tmp;
	int chickenListN = chickenList.size();

	if (chickenListN > m) {
		for (int i = 0; i < chickenListN - m; i++) {
			tmp.push_back(0);
		}
	}

	for (int i = 0; i < m; i++) tmp.push_back(1);

	do {
		vector<int> selChickenIdx;
		for (int i = 0; i < chickenListN; i++) {
			if (tmp[i] == 1) selChickenIdx.push_back(i);
		}
		solution(selChickenIdx);
	} while (next_permutation(tmp.begin(), tmp.end()));
}



int main() {

	cin >> n >> m;
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> map[i][j];
			if (map[i][j] == 1) homeList.push_back(make_pair(i, j));
			else if (map[i][j] == 2) chickenList.push_back(make_pair(i, j));
		}
	}

	check();

	cout << ans;

	return 0;
}