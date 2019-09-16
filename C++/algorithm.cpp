#include <iostream>
#include <vector>
#include <algorithm>
#define MAX 1001

using namespace std;

int n, m, k, cost = 0;
int vRoot[MAX] = { 0, };

struct Tunnel {
	int i;
	int j;
	int w;
};

vector<Tunnel> tunnel;

int findRoot(int v) {
	if (vRoot[v] == -1) return -1;
	else if (vRoot[v] == v) return v;
	return vRoot[v] = findRoot(vRoot[v]);
}

bool compare(Tunnel t1, Tunnel t2) {
	return t1.w < t2.w;
}

void kruskal() {
	sort(tunnel.begin(), tunnel.end(), compare);
	for (Tunnel t : tunnel) {
		int rootI = findRoot(t.i);
		int rootJ = findRoot(t.j);
		if (rootI != rootJ) {
			if (rootI == -1) vRoot[rootJ] = rootI;
			else if (rootJ == -1) vRoot[rootI] = rootJ;
			else vRoot[rootJ] = rootI;
			cost += t.w;
		}
	}
	cout << cost;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n >> m >> k;

	for (int i = 1; i <= n; i++) vRoot[i] = i;
	for (int i = 0; i < k; i++) {
		int idx;
		cin >> idx;
		vRoot[idx] = -1;
	}
	for (int k = 0; k < m; k++) {
		int i, j, w;
		cin >> i >> j >> w;
		tunnel.push_back({ i, j, w });
	}
	kruskal();
	return 0;
}
