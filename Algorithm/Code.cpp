#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

vector<string> stringV1, stringV2;
string tmp = "";
int unionN = 0,
	intersectionN = 0;

vector<string> splitString(string str) {

	vector<string> tempV;

	for (int i = 0; i < str.length()-1; i++) {
		if (str.at(i) < 97 || str.at(i) > 122) {
			continue;
		}
		if (str.at(i + 1) < 97 || str.at(i + 1) > 122) {
			i++;
			continue;
		}

		tmp = tmp + str.at(i) + str.at(i + 1);
		tempV.push_back(tmp);
		tmp = "";

	}

	return tempV;
}


void solution(string str1, string str2) {

	transform(str1.begin(), str1.end(), str1.begin(), tolower);
	transform(str2.begin(), str2.end(), str2.begin(), tolower);
	
	stringV1 = splitString(str1);
	stringV2 = splitString(str2);

	for (int i = 0; i < stringV1.size(); i++) {
		for (int j = 0; j < stringV2.size(); j++) {
			if (stringV1[i] == stringV2[j]) {
				intersectionN++;
				stringV1.erase(stringV1.begin() + i);
				stringV2.erase(stringV2.begin() + j);
				i = 0, j = 0; // stringV1의 사이즈가 유동적으로 변하므로 
							  // 항상 처음부터 시작 해줘야함
				break;
			} // if
		} //for j
	} // for i

	unionN = stringV1.size() + stringV2.size() + intersectionN;

	double result = (double)intersectionN / (double)unionN;

	cout << (int)(result * 65536) << endl;

}

int main() {

	solution("FRANCE", "french");
	solution("handshake", "shake hands");
	solution("aa1+aa2", "AAAA12");
	solution("E=M*C^2", "e=m*c^2");

	return 0;
}