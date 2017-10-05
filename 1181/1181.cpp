#include <iostream>
#include <string>
#include <string.h>

#include <array>

using namespace std;

int main() {

	// ���� �����
	int inputDataNumber = 0;		// ��� �����Ͱ� �Էµ� ������ '�� ó����' �޴� INT ����
	int whileCount = 0;				// while������ count�� üũ�ϱ� ���� INT ����

	array <int, 50> arrayCounts = { 0, };  // �� �迭�� �� ������ �ľ��ϱ� ���� INT �迭(50)

	string *wordArray[50];			// �ԷµǴ� �ܾ �ޱ����� �迭(�ִ� 50��)- ���� �����Ҵ�
	
	// �Է�
	cin >> inputDataNumber;

	// ���
	/* 1. �Էµ� ����(input Data)��ŭ ���ڿ��� �Է¹޴´� */
	while (whileCount < inputDataNumber) {
		string tempWord = "";

		cin >> tempWord;

		int wordLength = tempWord.length();

		/* 1-1. �迭�� 0���� �����ϹǷ� -1�� �ؼ� 0~49���� ����
				�׸��� �޸𸮸� �׳��� �Ƴ��� ���� ���ڿ��� ���̿� �ش��ϴ� �迭�� �����Ҵ� */
		if (arrayCounts[wordLength - 1] == 0) {
			wordArray[wordLength - 1] = new string[inputDataNumber];
		}

		/* 2. ������ ���̿� �´� �迭�� ���� �����Ѵ� */
		wordArray[wordLength - 1][arrayCounts[wordLength - 1]] = tempWord;

		/* 2-1. �� �迭���� ������ ������ �ľ��ϱ� ���ؼ� 1�� ������Ŵ(= �ܾ� 1���� ����) */
		arrayCounts[wordLength - 1] += 1;

		whileCount++;
	} // while

	whileCount = 0;

	/* 3. �� �迭���� ���ڸ� ���ؼ� �����Ѵ�*/
	while (whileCount < 50) {
		string currentWord = "";
		int index = whileCount;

		// �� �迭�� �ƹ��͵� ���� ���� �ʴٸ� (���ڸ� üũ�ϴ� �迭�� ī��Ʈ�� ���)
		if (arrayCounts[index] == 0) {
			whileCount++;
			continue;
		}

		// �迭�� ũ�� ���
		/*int arraySize = sizeof(wordArray[index]) / sizeof(*wordArray[index]);*/
		int arraySize = arrayCounts[index];
		
		// �� �迭 �ȿ��� ���ڵ��� ������
		for (int i = 0; i < arraySize; i++) {
			for (int j = i+1; j < arraySize; j++) {
				if (strcmp(wordArray[index][i].c_str(), wordArray[index][j].c_str()) >= 1) {
					swap(wordArray[index][i], wordArray[index][j]);
				} // if
			} // for
		} // for

		// 4. ���
		for (int i = 0; i < arraySize; i++) {
			if (currentWord == wordArray[index][i]) continue;

			currentWord = wordArray[index][i];

			cout << currentWord << endl;
		} // for - i - arraySize
		whileCount++;
	} // while

	system("pause");

	return 0;
}