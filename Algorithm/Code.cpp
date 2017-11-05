#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <queue>
#include <vector>
#include <tuple>
#include <utility>
#define VSIZE 100000

using namespace std;

struct Student {
	string name;
	int korean, english, math;
	Student(int x = 0, int y = 0, int z = 0):korean(x), english(y), math(z) {}
};

int main() {
	// C++ 에서도 입출력에 대해 C만큼의 속도를 낼 수 있는 코드
	// 그러나, scanf, printf 는 사용 불가능
	ios_base::sync_with_stdio(false);

	int n;
	cin >> n;

	vector<Student> v(n);

	for (auto &x : v) cin >> x.name >> x.korean >> x.english >> x.math;
	
	// 람다함수 적용
	//1. 국어 점수가 감소하는 순서로 = 국어점수가 다르면
	//2. 국어 점수가 같으면 영어 점수가 증가하는 순서로 = 영어점수가 다르면
	//3. 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로 = 수학점수가 다르면
	//4. 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로
	sort(v.begin(), v.end(), [](const Student &x, const Student &y) -> bool {
		if (x.korean != y.korean) return x.korean > y.korean; // 내림차순
		if (x.english != y.english) return x.english < y.english; // 오름차순
		if (x.math != y.math) return x.math > y.math; // 내림차순
		return x.name < y.name; // 내림차순
	});

	// C++11, foreach문
	// endl보다 \n이 훨씬 빠르기 때문에 대신사용
	for (auto &x : v) cout << x.name << '\n';

	system("pause");

	return 0;
}