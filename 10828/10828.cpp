#include <iostream>
#include <cstring>
#include <string>
using namespace std;

int CheckCommandType(string command);
int Size(int *DataSet);

static const int PUSH = 1;
static const int POP = 2;
static const int SIZE = 3;
static const int EMPTY = 4;
static const int TOP = 5;

int main() {
	// 변수 선언 부
	int *STACK;
	int inputDataNumber = 0;
	int stackSize = 0;

	string *commandArray;

	// 입력
	cin >> inputDataNumber;

	// 동적할당
	STACK = new int[inputDataNumber];
	commandArray = new string[inputDataNumber];

	cin.get();

	for (int i = 0; i < inputDataNumber; i++) {
		string command;
		getline(cin, commandArray[i]);
	} // for 1 - inputDataNumber

	for (int i = 0; i < inputDataNumber; i++) {
		int commandType = CheckCommandType(commandArray[i]);

		switch (commandType)
		{
		case PUSH:
			commandArray[i].replace(0, 4, "");
			STACK[stackSize] = atoi(commandArray[i].c_str());
			stackSize++;
			break;
		case POP:
			if (stackSize == 0) {
				cout << -1 << endl;
				break;
			}
			commandArray[i].replace(0, 3, "");
			cout << STACK[stackSize - 1] << endl;
			STACK[stackSize - 1] = -1;
			stackSize--;
			break;
		case SIZE:
			cout << stackSize << endl;
			break;
		case EMPTY:
			if (stackSize == 0)		cout << 1 << endl;
			else					cout << 0 << endl;
			break;
		case TOP:
			if (stackSize == 0) {
				cout << -1 << endl;
				break;
			}
			cout << STACK[stackSize - 1] << endl;
			break;
		default:
			break;
		} // switch
	}

	//system("pause");

	return 0;
} // main

int CheckCommandType(string command) {
	if (command.find("push") == 0)			return PUSH;
	else if (command.find("pop") == 0)		return POP;
	else if (command.find("size") == 0)		return SIZE;
	else if (command.find("empty") == 0)	return EMPTY;
	else if (command.find("top") == 0)		return TOP;
	else									return -1;
}

int Size(int *DataSet) {
	//return sizeof(DataSet) / sizeof(*DataSet);	// 0
	//return _msize(DataSet) / sizeof(*DataSet);		// 14
}