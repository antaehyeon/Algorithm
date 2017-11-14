#include <iostream>
#include <bitset>
#include <vector>
#include <string>
#include <cstring>
#include <algorithm>
#include "LRUCache.cpp"

using namespace std;

int main() {

	LRUCache<string, int> cache(5);
	cache.put("A", 1);
	cache.put("B", 2);
	cache.put("C", 3);
	cache.put("D", 4);
	cache.put("E", 5);
	int val;
	if (cache.lookup("A", val)) { //'A' is updated. So 'B' becomes the oldest.
		cout << "A's value is " << val << endl; //expected result
	}
	else {
		cout << "A: Not found" << endl;
	}
	cache.put("F", 6); //Cache replacement. 'B' is removed and 'C' becomes the oldest
	if (cache.lookup("B", val)) {
		cout << "B's value is " << val << endl;
	}
	else {
		cout << "B: Not found" << endl; //expected
	}
	cache.put("C", 7); //'C' is updated. Now 'D' becomes the oldest
	if (cache.lookup("C", val)) {
		cout << "C's value is " << val << endl; //expected
	}
	else {
		cout << "C: Not found" << endl;
	}
	cache.put("G", 8); //Cache replacement. 'D' is removed and 'E' becomes the oldest
	if (cache.lookup("D", val)) {
		cout << "D's value is " << val << endl;
	}
	else {
		cout << "D: Not found" << endl; //expected result
	}
	return 0;

}