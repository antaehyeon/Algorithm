#include <iostream>
#include <bitset>
#include <vector>
#include <string>
#include <cstring>
#include <algorithm>
#include <array>
#include "LRUCache.cpp"

using namespace std;

array<string, 10> testData = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };
array<string, 9> testData2 = { "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul" };
array<string, 12> testData3 = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome" };
array<string, 12> testData4 = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome" };
array<string, 4> testData5 = { "Jeju", "Pangyo", "NewYork", "newyork" };
array<string, 5> testData6 = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };

int main() {

	int val = 0,
		count = 0,
		time = 0,
		cacheNum = 0;

	cin >> cacheNum;

	if (!cacheNum) {
		for (int i = 0; i < testData3.size(); i++) {
			time += 5;
		}
		cout << time << endl;
		return 0;
	}

	LRUCache<string, int> cache(cacheNum);

	// 왜 일반배열에서 testData->size()는 4가나올까?
	for (int i = 0; i < testData3.size(); i++) {
		if (cache.lookup(testData3[i], val)) {
			time += val;
			continue;
		}
		cache.put(testData3[i], 1);
		time += 5;
	} // for

	cout << time;

	return 0;
}