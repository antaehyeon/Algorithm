백준 알고리즘 정리
==================

백준 알고리즘 문제에 대해서 기술적으로 기억할 부분을 정리할 예정입니다.
-----------------------------------------------------------------------

-	[8진수, 10진수, 16진수](https://www.acmicpc.net/problem/11816)

```
scanf("%i", &var);
0으로 시작하면 8진수
0x로 시작하면 16진수
나머지는 10진수로 출력됨
```

-	[그대로 출력하기](https://www.acmicpc.net/problem/11718)

```
getline(cin, var);
cout << var << endl;
```

-	[X보다 작은 수](https://www.acmicpc.net/problem/10871)

```
람다함수 이용(밖에 있는 변수(x)를 참조하기 위해선 []안에 &를 써야함)
auto function = [&](int num) {
  return num < x;
};


if(function(var)) {
  var 보다 큰 수만 출력하는 코드
}
```

-	[피보나치 수 5](https://www.acmicpc.net/problem/10870)

```
람다함수를 재귀적으로 사용하려면
#include <functional>

function<int(int)> f = [](int n) {
  if (n <= 1) return n;
  else return f(n-1) + f(n-2);
};

위와 같이 auto가 아닌 function<리턴타입(자료형, ...)>으로 사용해야 한다
```

-	[람다표현식의 장점](http://qwefgh90.github.io/java/Lambda-Expression/)

-	[사칙 연산](https://www.acmicpc.net/problem/10869)

```
vector<function<int(int, int)>> d;

  d.push_back([](int x, int y) {
    return x + y;
  });

  ... 나머지 함수 추가

  for (auto &f : d) {
  cout << f(a, b) << endl;
}
```

-	NHN Ent 2017 Pre-Test 1차, NHN엔터의 모험

```
getline(cin, string);
for (auto c : string) {
  if (a == ' ') continue;
  // 값 보관
}
한줄의 문자열에 대해서 해당 문자열 기준으로 하나씩 짤려서 c에 들어간다
(int형으로 출력되니 -48해주면 원래의 값을 찾을 수 있음)

auto f = find(q.begin(), q.end(), 찾을 값);
distance(q.begin(), f) : 해당 값의 위치를 찾을 수 있음 (0부터 시작)
```

-	NHN Ent 2017 Pre-Test 1차, NHN엔터의 모험

```
rotate(q.begin(), q.begin()+num, q.end());

rotate(q.rbegin(), q.rbegin()+num, q.rend());

vector 와 string 을 이용하면 특정문자열로 찢기가 편함
그리고 string 하나 선언해서 문자열을 붙이면 원하는 문자열도 생성가능
```
