/*
�׷� �ܾ�� �ܾ �����ϴ� ��� ���ڿ� ���ؼ�, �� ���ڰ� �����ؼ� ��Ÿ���� ��츸�� ���Ѵ�. 

���� ���, ccazzzzbb�� c, a, z, b�� ��� �����ؼ� ��Ÿ����, kin�� k, i, n�� �����ؼ� ��Ÿ���� ������ �׷� �ܾ�������, aabbbccb�� b�� �������� ��Ÿ���� ������ �׷� �ܾ �ƴϴ�.

�ܾ� N���� �Է����� �޾� �׷� �ܾ��� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
*/

#include <iostream>
#include <string>
using namespace std;

bool continuedLetterCheck(string word);

int main() {
	// ���� �����
	int inputDataNumber = 0;
	int continuedLetterCount = 0;

	string inputLetterData = "";

	cin >> inputDataNumber;

	getline(cin, inputLetterData);

	for (int i = 0; i < inputDataNumber; i++) {
		getline(cin, inputLetterData);
		if (continuedLetterCheck(inputLetterData)) {
			continuedLetterCount++;
		}
	} // for

	cout << continuedLetterCount << endl;

	//system("pause");
	return 0;
} // main

bool continuedLetterCheck(string word) {
	
	int count = 0;
	int storedAlphabetNumber = 0;
	int stringLength = word.size();

	string storedAlphabetData[26] = { "", };
	string currentAlphabet = "";

	bool existLetter = false;

	for (int i = 0; i < stringLength; i++) {
		string letter = word.substr(i, 1);

		if (currentAlphabet == letter) {
			count++;
		}
		else {

			// ù�� ° �Ǽ�
			// �� ó���� storedAlphabetNumber �� 0 �̱� ������ FOR���� ���� ����
			// �׷��� ������ true�� ���ϵ�

			// �׷��� ó�� �ʱ������� ������
			// storedAlphabetNumber == 0 : �ƹ��͵� ����Ȱ��� ���� ���
			// ù ���ڸ� ����

			if (storedAlphabetNumber == 0) {
				storedAlphabetData[0] = letter;
				storedAlphabetNumber++;
				currentAlphabet = letter;
				continue;
			}

			//for (int i = 0; i < storedAlphabetNumber; i++) {
			//	if (storedAlphabetData[i] == letter) {
			//		return false;
			//	}
			//	else {
			//		storedAlphabetData[storedAlphabetNumber] = letter;
			//		storedAlphabetNumber++;
			//		break;
			//	}
			//} // for

			// �ι�° �Ǽ�
			// FOR�� �ȿ� if-else�� ���� ������Ű�� ����
			// �迭�� ���� �˻��ϴ°��� �ƴ� �ѹ��� �˻��ϰ� �ٷ� else������ �Ѿ��
			// ����� �� �˻簡 ���� �ʾ���
			// �׷��� ������ ����

			for (int i = 0; i < storedAlphabetNumber; i++) {
				if (storedAlphabetData[i] == letter) {
					existLetter = true;
				}
			} // for

			if (existLetter) {
				return false;
			}
			else {
				storedAlphabetData[storedAlphabetNumber] = letter;
				storedAlphabetNumber++;
				existLetter = false;
			}
			currentAlphabet = letter;
		} // else
	} // for

	return true;
}