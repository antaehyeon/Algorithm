#include <iostream>
#include <string>
#define size 7

using namespace std;

int arr[size][size] =
{
	0, 1, 1, 0, 0, 0, 0,
	1, 0, 0, 1, 1, 0, 0,
	1, 0, 0, 0, 0, 0, 1,
	0, 1, 0, 0, 0, 1, 0,
	0, 1, 0, 0, 0, 1, 0,
	0, 0, 0, 1, 1, 0, 1,
	0, 0, 1, 0, 0, 1, 0
};

int visited[size] = { 0, };
int queue[size];
int front = -1;
int rear = -1;

void Put(int data) {
	rear++;
	queue[rear] = data;
}

int isEmpty() {
	if (rear == front)
		return 1;
	return 0;
}

int Pop() {
	if (isEmpty())
		return -1;
	else {
		front++;
		return queue[front];
	}
}

void bfs(int d) {
	Put(d);

	if (visited[d] == 0) {
		cout << d << " ";
		visited[d] = 1;
	}
	while (!isEmpty()) {
		int t = Pop();
		for (int i = 0; i < size; i++) {
			if (arr[t][i] == 1 && visited[i] == 0) {
				Put(i);
				cout << i << " ";
				visited[i] = 1;
			}
		}
	}
}

int main() {
	bfs(0);

	return 0;
}