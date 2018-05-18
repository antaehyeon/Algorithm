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

-  [람다표현식의 장점](http://qwefgh90.github.io/java/Lambda-Expression/)

  -[사칙 연산](https://www.acmicpc.net/problem/10869)

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

- # 인프런 알고리즘 강좌 (권오흠)

- ### 순환(Recursion)의 개념과 기본예제1

- #### Recursion (재귀함수)

  - 자기 자신을 호출하는 함수

  - Base case : 적어도 하나의 Recursion에 빠지지 않는 경우가 존재해야 한다

  - Recursive case : Recursion을 반복하다보면 결국 base case로 수렴해야 한다

  -  Factorial : n!

    - 0! = 1
    - n! = n*(n-1)! n>0

  - x^n

    - x^0 = 1
    - x^n = x*x^(n-1)  if n>0

  - Fibonacci Number

    - f0 = 0
    - f1 = 1
    - fn = fn-1 + fn-2  n>1

  - 최대공약수 : Euclid Method

    ```
    m>=n인 두 양의 정수 m과 n에 대해서 m이 n의 배수이면 gcd(m,n) = n이고, 그렇지 않으면 gcd(m,n) = gcd(n, m%n)이다.
    ```

    ```java
    public static double gcd(int m, int n) {
      if (m<n) {
        int tmp=m; m=n; n=tmp;		// swap m and n
      }
      if (m%n == 0)
      	return n;
      else
      	return gcd(n, m%n);
    }
    ```

    ```java
    gcd(p, q) = if q=0, p
    			otherwise, gcd(q, p%q)
    			
    public static int gcd(int p, int q) {
      if (q==0)
      	return p;
      else
      	return gcd(q, p%q);
    }

    ```

- ### 순환(Recursion)의 개념과 기본예제 2

  - #### 문자열의 길이 계산

    ![](2017-12-28_181926.png)

    ```java
    if the string is empty // base case
    	return 0;
    else
    	return 1 plus the length of the string that
    		excludes the first character;
    ```

    ![](2017-12-28_181949.png)

    ```java
    public static int length(String str) {
      if (str.equals(""))
      	return 0;
      else
      	return 1+length(str.substring(1));
    }
    ```

  - 기존의 문자열의 길이를 계산하는 방법(일반적인)

    - for문이나 while문을 통한 문자들을 카운트한다

  - Recursion

    - 첫번째 문자를 제거한 나머지 문자열의 길이를 계산한 다음 1을 더하면 된다 (Recursion 적인 문자열 계산방법)

  ​

  - #### 문자열의 프린트 (Recursion)

    ```java
    public static void printChars(String str) {
      if (str.length()==0)
      	return;
      else {
        System.out.print(str.charAt(0));
        printChars(str.substring(1));
      }
    }
    ```

  - #### 문자열을 뒤집어 프린트

    ```java
    public static void printChars(String str) {
      if (str.length()==0)
      	return;
      else {
        printChars(str.substring(1));
        System.out.print(str.charAt(0));
      }
    }
    ```

    - Recursion 의 재밌는 예 : print와 출력의 순서만 바꿔주면 된다

  - #### 2진수로 변환하여 출력

    ```java
    public void printInBinary(int n) {
      if (n<2)
      	System.out.print(n);
      else {
        printInBinary(n/2);
        System.out.print(n%2);
      }
    }

    ```

  - #### 배열의 합 구하기

    ```java
    public static int sum(int n, int [] data) {
      if (n<=0)
      	return 0;
      else
      	return sum(n-1, data) + data[n-1];
    }
    ```

    - data[0]에서 data[n-1]까지의 합을 구하여 반환한다

  - #### 데이터파일로 부터 n개의 정수 읽어오기

    ```java
    public void readFrom(int n, int [] data, Scanner in) {
      if (n==0)
      	return;
      else {
        readFrom(n-1, data, in);
        data[n-1] = in.nextInt();
      }
    }
    ```

  - #### Recursion vs Iteration

    1. 모든 순환함수는 반복문(iteration)으로 변경 가능
    2. 그 역도 성립함. 즉 **모든 반복문은 recursion으로 표현 가능함**
    3. 순환함수는 복잡한 알고리즘을 알기쉽게 표현하는 것을 가능하게 함
    4. 하지만 함수 호출에 따른 오버헤드가 존재 (매개변수 전달, 액티베이션 프레임 생성 등)

    ​


# 백준 알고리즘 강의 정리

> ### 프로그래밍 대회에서 사용하는 Java

1. #### [Java 입/출력](https://github.com/antaehyeon/Algorithm/blob/master/%20README/JAVA%20%EC%9E%85:%EC%B6%9C%EB%A0%A5.md)

   1. [Hello World](https://github.com/antaehyeon/Algorithm/blob/master/README/Java-%EC%9E%85%EC%B6%9C%EB%A0%A5.md#hello-world)
   2. [Scanner](https://github.com/antaehyeon/Algorithm/blob/master/README/Java-%EC%9E%85%EC%B6%9C%EB%A0%A5.md#scanner)
   3. [BufferedReader](https://github.com/antaehyeon/Algorithm/blob/master/README/Java-%EC%9E%85%EC%B6%9C%EB%A0%A5.md#bufferedreader)
   4. [stringTokenizer](https://github.com/antaehyeon/Algorithm/blob/master/README/Java-%EC%9E%85%EC%B6%9C%EB%A0%A5.md#bufferedreader)
   5. [StringBuilder](https://github.com/antaehyeon/Algorithm/blob/master/README/Java-%EC%9E%85%EC%B6%9C%EB%A0%A5.md#stringbuilder-javalangstringbuilder)

2. #### [Java - Collections](https://github.com/antaehyeon/Algorithm/blob/master/%20README/Java%20-%20Collections.md)

   1. [ArrayList](https://github.com/antaehyeon/Algorithm/blob/master/README/Java-Collections.md#arraylist)
   2. [Stack](https://github.com/antaehyeon/Algorithm/blob/master/README/Java-Collections.md#stack)
   3. [Set](https://github.com/antaehyeon/Algorithm/blob/master/README/Java-Collections.md#set)
      1. HashSet
      2. TreeSet
      3. LinkedHashSet
   4. [Map](https://github.com/antaehyeon/Algorithm/blob/master/README/Java-Collections.md#map)
   5. [Queue](https://github.com/antaehyeon/Algorithm/blob/master/README/Java-Collections.md#queue)
   6. [PriorityQueue](https://github.com/antaehyeon/Algorithm/blob/master/README/Java-Collections.md#priorityqueue)

3. [Java 정렬](https://github.com/antaehyeon/Algorithm/blob/master/README/Java-Sort.md)




> 알고리즘 기초

1. [알고리즘과 입/출력](https://github.com/antaehyeon/Algorithm/blob/master/README/Chap01-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EA%B3%BC%EC%9E%85%EC%B6%9C%EB%A0%A5.md)
2. [자료구조 1](https://github.com/antaehyeon/Algorithm/blob/master/README/Chap02-%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0.md)
3. 다이나믹 프로그래밍 1
4. 수학 1
5. 정렬
6. 그래프 1
7. 트리 1







