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

	// 입력
	cin >> inputDataNumber;

	// 동적할당
	STACK = new int[inputDataNumber];

	for (int i = 0; i < inputDataNumber; i++) {
		string command = "";
		//cin >> command;
		getline(cin, command);
		
		int commandType = CheckCommandType(command);
		int stackSize = Size(STACK);
		switch (commandType)
		{
		case PUSH:
			command.replace(0, 4, "");
			STACK[stackSize] = atoi(command.c_str());
			break;
		case POP:
			if (stackSize == 0) {
				cout << -1 << endl;
				break;
			}
			command.replace(0, 3, "");
			cout << STACK[stackSize - 1] << endl;
			STACK[stackSize - 1] = NULL;
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
		}
	}

	system("pause");

	return 0;
}

int CheckCommandType(string command) {
	if (command.find("push") == 1)			return PUSH;
	else if (command.find("pop") == 1)		return POP;
	else if (command.find("size") == 1)		return SIZE;
	else if (command.find("empty") == 1)	return EMPTY;
	else if (command.find("top") == 1)		return TOP;
}

int Size(int *DataSet) {
	return sizeof(DataSet) / sizeof(*DataSet);
}