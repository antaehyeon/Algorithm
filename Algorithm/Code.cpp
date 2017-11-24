/*
NHN Ent 2017 Pre-Test 1차
암복호화
*/

#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

char sumAlphabet(char a, char b) {

	int n = (a - 97) + (b - 97);
	
	if (n > 26) n -= 26;
	
	return (char)n + 97;
}

char minusAlphabet(char a, char b) {
	int n = (a - 97) - (b - 97);
	
	if (n < 0) {
		n += 26;
	}

	return (char)n + 97;
}

int main() {

	string s = "",
		mode = "",
		secretKey = "",
		message = "",
		temp = "";

	int rotateNum = 0,
		stringMode = 0;

	vector <char> answer;

	getline(cin, s);

	for (auto c : s) {
		if (c == ' ') {
			stringMode++;
			continue;
		}

		switch (stringMode)
		{
		case 0:
			mode += c;
			break;
		case 1:
			secretKey += c;
			break;
		case 2:
			rotateNum = c - 48;
			break;
		case 3:
			message += c;
			break;
		default:
			break;
		}
	}



	if (mode == "encrypt") {
		for (int i = 0; i < message.length(); i++) {
			char c = sumAlphabet(secretKey[i], message[i]);

			answer.push_back(c);
		}
		rotateNum %= message.length();
		
		rotate(answer.begin(), answer.begin() + rotateNum, answer.end());

		for (auto c : answer) {
			cout << c;
		}
	}
	else if (mode == "decrypt") {

		rotateNum %= message.length();

		rotate(message.rbegin(), message.rbegin() + rotateNum, message.rend());

		for (int i = 0; i < message.length(); i++) {
			char c = minusAlphabet(message[i], secretKey[i]);

			answer.push_back(c);
		}

		for (auto c : answer) {
			cout << c;
		}
	}	

	return 0;
}