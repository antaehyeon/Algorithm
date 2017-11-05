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
	// C++ ������ ����¿� ���� C��ŭ�� �ӵ��� �� �� �ִ� �ڵ�
	// �׷���, scanf, printf �� ��� �Ұ���
	ios_base::sync_with_stdio(false);

	int n;
	cin >> n;

	vector<Student> v(n);

	for (auto &x : v) cin >> x.name >> x.korean >> x.english >> x.math;
	
	// �����Լ� ����
	//1. ���� ������ �����ϴ� ������ = ���������� �ٸ���
	//2. ���� ������ ������ ���� ������ �����ϴ� ������ = ���������� �ٸ���
	//3. ���� ������ ���� ������ ������ ���� ������ �����ϴ� ������ = ���������� �ٸ���
	//4. ��� ������ ������ �̸��� ���� ������ �����ϴ� ������
	sort(v.begin(), v.end(), [](const Student &x, const Student &y) -> bool {
		if (x.korean != y.korean) return x.korean > y.korean; // ��������
		if (x.english != y.english) return x.english < y.english; // ��������
		if (x.math != y.math) return x.math > y.math; // ��������
		return x.name < y.name; // ��������
	});

	// C++11, foreach��
	// endl���� \n�� �ξ� ������ ������ ��Ż��
	for (auto &x : v) cout << x.name << '\n';

	system("pause");

	return 0;
}