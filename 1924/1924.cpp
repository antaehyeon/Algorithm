#include <iostream>
#include <array>
#include <cstring>
#include <string>
using namespace std;

int main() {
	// 변수 선언 부
	int inputMonth = 0;
	int inputDay = 0;
	int whileCount = 1;

	int forDayCalculator = 0;
	
	array <string, 7> days = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
	array <int, 12> monthDay = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	// 기능
	cin >> inputMonth >> inputDay;

	while (whileCount < inputMonth) {
		forDayCalculator += monthDay[whileCount-1];
		whileCount++;
	}

	int calculatedDay = (forDayCalculator + inputDay) % 7;

	// 출력
	cout << days[calculatedDay] << endl;

	//system("pause");
	
	return 0;
}