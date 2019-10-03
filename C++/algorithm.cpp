#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
#define MAX 101

using namespace std;

int r, c, m, ans = 0;
int dx[5] = {0, 0, 0, 1, -1};
int dy[5] = {0, -1, 1, 0, 0};

struct Fish
{
	int y;
	int x;
	int s; // speed
	int d; // direction
	int z; // size
};

queue<Fish> fq;
vector<Fish> map[MAX][MAX];

void input()
{
	cin >> r >> c >> m;
	for (int i = 0; i < m; i++)
	{
		int y, x, s, d, z;
		cin >> y >> x >> s >> d >> z;
		map[y][x].push_back({y, x, s, d, z});
	}
}

void findAndInitMap()
{
	for (int i = 1; i <= r; i++)
	{
		for (int j = 1; j <= c; j++)
		{
			if (map[i][j].size())
			{
				fq.push(map[i][j][0]);
				map[i][j].clear();
			}
		}
	}
}

bool isAccessable(int y, int x)
{
	return (y > 0 && y <= r) && (x > 0 && x <= c);
}

int changeDirection(int dir)
{
	if (dir == 1)
		return 2;
	else if (dir == 2)
		return 1;
	else if (dir == 3)
		return 4;
	else if (dir == 4)
		return 3;
	else
		return -1;
}

void moveFish()
{
	findAndInitMap();
	while (!fq.empty())
	{
		Fish fish = fq.front();
		int y = fish.y;
		int x = fish.x;
		int size = fish.z;
		int speed = fish.s;
		int direction = fish.d;
		fq.pop();

		for (int i = 0; i < speed; i++)
		{
			int ny = y + dy[direction];
			int nx = x + dx[direction];

			if (!isAccessable(ny, nx))
			{
				direction = changeDirection(direction);
				i--;
				continue;
			}
			else
			{
				y = ny;
				x = nx;
			}
		}

		if (map[y][x].size())
		{
			if (map[y][x][0].z < size)
			{
				map[y][x].clear();
				map[y][x].push_back({y, x, speed, direction, size});
			}
		}
		else
		{
			map[y][x].push_back({y, x, speed, direction, size});
		}
	}
}

void solution()
{
	for (int x = 1; x <= c; x++)
	{
		for (int y = 1; y <= r; y++)
		{
			if (map[y][x].size())
			{
				ans += map[y][x][0].z;
				map[y][x].clear();
				break;
			}
		}
		moveFish();
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	input();
	solution();
	cout << ans;

	return 0;
}