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

### 프로그래밍 대회에서 사용하는 Java

1. ### Java 입/출력

   - #### Hello World

     ```java
     public class Main {
       public static void main(String args[]) {
         System.out.println("Hello World!");
       }
     }
     ```

     - Class 이름은 Main 으로 보통 지정함
     - Main Class 안에 main 함수를 만들어 코드를 실행시키는 방식으로 진행함
     - print**ln** : 줄바꿈
     - print : 줄을 바꾸지 않음

     ```java
     System.out.printf("%d", n);
     ```

     - C에서와 같이 printf를 사용하면 정수형, 실수형, 문자형을 출력할 수 있음

   - #### Scanner

     > java.util.Scanner

     - Java에서 입력을 받을 때 사용

     ```java
     Scanner sc = new Scanner(System.in);
     int a, b;
     a = sc.nextInt();
     b = sc.nextInt();
     System.out.println(a + b);
     ```

     - **next자료형**을 이용해서 입력을 받음
       - nextInt
       - nextString

     ```java
     Scanner sc = new Scanner (System.in);
     int sum = 0;
     while (sc.hasNextInt()) {
       sum += sc.nextInt();
     }
     System.out.println(sum);
     ```

     - **hasNext자료형**을 이용해서 입력받을 수 있는 자료형이 있는지 구할 수 있음

     ```java
     Scanner sc = new Scanner (System.in);
     int n = sc.nextInt();
     String s = sc.nextLine();
     System.out.println(n + "\n" + s);
     ```

     - int와 String을 동시에 받을 때
     - 입력 : 1, hi
     - 그러나, 1 뒤에 줄바꿈이 존재하기 때문에 n에는 1이 들어가지만
     - s 에는 줄바꿈 문자가 들어가므로 올바른 결과를 얻을 수 없음

     ```java
     Scanner sc = new Scanner (System.in);
     int n = sc.nextInt();
     sc.nextLine();
     String s = sc.nextLine();
     System.out.println(n + "\n" + s);
     ```

     - 중간에 줄바꿈이 한번 있어야 (sc.nextLine();) 원하는 결과를 얻을 수 있음

   - #### BufferedReader

     - Scanner은 느린경우가 많기 때문에, 속도가 중요하다면 BufferedReader 을 사용!

     - [네 수](https://www.acmicpc.net/problem/10824)

       ```java
       import java.io.*
       public class Main {
         public static void main(String args[]) throws IOException {
           BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
           String[] line = bf.readLine().split(" ");
           String a = line[0] + line[1];
           String b = line[2] + line[3];
           long ans = Long.valueOf(a) + Long.valueOf(b);
           System.out.println(ans);    
         }
       }
       ```

       - throws IOException
       - 스플릿 후, 각각의 숫자를 합침
       - int 의 범위를 고려하여 Long 형식으로 구현

     - read와 readLine만 있기 때문에, 정수는 파싱을 해야함

   - #### stringTokenizer

     - 어떤 문자열이 있을때 특정 토큰으로 자를 수 있음

     - [더하기 3](https://www.acmicpc.net/problem/11023)

       ```java
       BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
       String line = bf.readLine();
       StringTokenizer st = new StringTokenizer(line, ",");
       int num = 0;
       while (st.hasMoreTokens() {
       		sum += Integer.valueOf(st.nextToken());
       	}
       	System.out.println(sum);
       )
       ```

   - #### StringBuilder (java.lang.StringBuilder)

     - 출력해야할 것이 많은 경우에는 StringBuilder 을 이용해 문자열을 만들고, 출력하는 것이 좋음

     - [N찍기](https://www.acmicpc.net/problem/2741)

       ```java
       Scanner sc = new Scanner (System.in);
       int n = sc.nextInt();
       for (int i=1; i<=n; i++) {
         System.out.println(i);
       }
       ```

       - 해당 코드의 수행시간은 880 MS

       ```
       Scanner sc = new Scanner (System.in);
       int n = sc.nextInt();
       StringBuilder sb = new StringBuilder();
       for (int i=1; i<=n; i++)
       	sb.append(i+"\n");
       System.out.print(sb);
       ```

       - 해당 코드의 수행시간은 156 MS

2. ### Java - Collections

   > 자바 콜렉션에서 많이 사용되는 것

   - ### C++ STL

     - vector, deque, list, set, map, Stack, Queue

   - #### ArrayList

     - 길이가 정해져있지 않고 변하는 배열을 뜻함

     - C++ STL 에서는 vector이 해당됨

     - ArrayList( )

       ```java
       ArrayList<Integer> a = new ArrayList<Integer>();
       ```

     - ArrayList(intinitialCapacity)

       ```java
       ArrayList<Integer> b = new ArrayList<Integer>(40);
       ```

       - Capacity = 40 으로 정한 ArrayList 를 만든 것

     - 주로 많이 사용하는 메소드들

       - boolean add(E e) : 뒤에 e를 추가
       - void add (int index, E element) : index 번 째 추가
       - void clear ( )
       - boolean Contains(Object o)
         - Object o 에 들어있는지 아닌지에 대한
       - E get (int index) : arr[index] 라는 표현도 가능함
       - boolean isEmpty( )
       - E remove(int index)
       - E set (int index, E element)
       - Object [ ]  toArray( )

     ```java
     int[] arr = (int [])a.toArray();
     ```

   - ### [수 정렬하기](https://www.acmicpc.net/problem/2750)

     ```java
     ArrayList<Integer> a = new ArrayList<Integer>();
     for (int i=0; i<n; i++) {
       int temp = sc.nextInt();
       a.add(tmp);
     }
     Collections.sort(a);
     for (int x : a) {
       System.out.println(x);
     }
     ```

     ```java
     Collections.sort(a);
     for (int i=0; i<n; i++) {
       System.out.println(x);
     }
     ```

     - 결국 ArrayList는 배열이기 때문에 추가, 값이 있는지 없는지 확인, 삭제 하는 것 모두 O(n) 이라는 시간이 걸림

     - ArrayList는 그래프 문제의 인접 리스트를 만들 때, 가장 많이 사용

       ```java
       ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n+1];
       for (int i=1; i<=n; i++) {
         a[i] = new ArrayList<Integer>();
       }
       for (int i=0; i<m; i++) {
         int u = sc.nextInt();
         int v = sc.nextInt();
         a[u].add(v);
         a[v].add(u);
       }
       ```

   - ### LinkedList

     > 이중연결 리스트 (C++ LIST)

     - 프로그래밍 대회에서 LinkedList 를 사용하는 경우는 드물다

   - ### Stack

     > 한쪽 끝에서만 자료를 넣고 뺄 수 있는 자료구조
     >
     > Last In First Out (LIFO)

     - push: E push(E item)
     - pop: E pop()
       - C++ 에서는 pop 에 대하여 리턴값이 없음 (void)
       - 그러나 Java에서는 리턴값이 존재
     - top: E peek()
     - empty: bool empty()
     - size: int size()

   - ### Set

     > 인터페이스, 중복된 원소를 포함하지 않는다

     - boolean add(E e)

     - void clear()

     - boolean contains(Object o)

     - boolean isEmpty()

     - boolean remove(Object o)

     - int size()

     - Obejct[] toArray()

       - **HashSet**

         ```java
         public class Main {
           public static void main(String args[]) {
             HashSet<Integer> d = new HashSet<Integer>();
             for (int i=10; i>=1; i--) {
               d.add(i);
             }
             for (int x : d) {
               System.out.print(x + " ");
             }
           }
         }
         ```

         - 해시테이블을 이용해서 구현되어 있다
         - 삽입/삭제/제거 연산의 시간복잡도가 O(1)
         - 순서가 보장되지 않음
         - 집합이 필요하긴 한데, 순서가 뒤바뀌어도 되는 경우에만 사용
           - 반드시 오름차순이거나 내림차순이 필요 없을 때
         - 위의 코드의 출력 결과는 아무도 모름
         - 그래서 **HashSet은 어떤 데이터가 포함되었는지 유/무 를 체크할 때 사용**

       - **TreeSet**

         > STL Set과 매우 비슷

         ```java
         TreeSet<Integer> d = new TreeSet<Integer>();
         for (int i=10; i>=1; i--) {
           d.add(i);
         }
         for (int x : d) {
           System.out.print(x + " ");
         }
         ```

         - 이진 검색 트리(레드 블랙 트리)로 구현되어 있음
         - 삽입/삭제/제거 연산의 시간 복잡도가 O(logN) 이다
         - 순서가 보장됨
         - 오름차순으로 출력됨 (1, 2, 3, 4, 5, 6 ...)

       - **LinkedHashSet**

         > 해시테이블과 연결리스트를 이용해서 구현되어 있음

         ```java
         LinkedHashSet<Integer> d = new LinkedHashSet<Integer>();
         for (int i=10; i>=1; i--) {
           d.add(i);
         }
         for (int x : d) {
           System.out.print(x + " ");
         }
         ```

         - 삽입/삭제/제거 연산의 시간복잡도가 O(1) 임
         - 추가한 순서가 보장됨

     - 일반적인 경우에는 HashSet

     - 순서가 중요한 경우에는 TreeSet

       - Upper bound, Lower bound 를 사용해야 하는 경우
         - 가장 가까운 두점을 구하는 Line Sweep 알고리즘에서 사용

     - 입력으로 넣은 순서가 중요한 경우에는 LinkedHashSet

   - ### [숫자 카드](https://www.acmicpc.net/problem/10815)

     > 상근이가 가지고 있는 숫자카드를 모두 Set에 넣고, 있는지 없는지 확인하면 됨
     >
     > 단, 순서가 중요하지 않음 (어떤 카드를 가지고 있는지 아닌지만 중요)
     >
     > HashSet 사용 !

     ​









