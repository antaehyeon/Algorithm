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
