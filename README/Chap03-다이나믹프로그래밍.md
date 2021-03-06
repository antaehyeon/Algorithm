# 다이나익 프로그래밍 1

- ### 다이나믹 프로그래밍이란?

  큰 문제를 작은 문제로 나눠서 푸는 알고리즘

  Dynamic Programming의 Dynamic은 아무의미가 없음

  즉, 동적계획법의 동적이란 의미가 아님!

  (1940년 Richard Bellman은 멋있어보여서 사용함)

  ​

- ### 다이나믹 프로그래밍의 조건

  1. Overlapping Subproblem (겹치는 부분문제)
  2. Optimal Substructure (문제의 정답을 작은 문제의 부분에서 구할 수 있을 때)





- ### Overlapping Subproblem

  `문제를 작은 부분문제로 나눠서 푸는것이 핵심`

  - #### 피보나치 수

    F0 = 0, F1 = 1 일 때,

    Fn = Fn-1 + Fn-2 ( n>=2 )

    문제 : **N번째 피보나치 수를 구하는 문제**

    작은 문제 : **N-1번째 피보나치 수를 구하는 문제**, N-2번째 피보나치 수를 구하는 문제

    문제 : N-1번째 피보나치 수를 구하는 문제

    작은 문제 : **N-2번째 피보나치 수를 구하는 문제**, N-3번째 피보나치 수를 구하는 문제

    문제 : **N-2번째 피보나치 수를 구하는 문제**

    작은 문제 : N-3번째 피보나치 수를 구하는 문제, N-4번째 피보나치 수를 구하는 문제

  - #### 결론

    - 큰 문제와 작은 문제를 같은 방법으로 풀 수 있다
    - 문제를 작은 문제로 쪼갤 수 있다




- ### Optimal Substructure

  `문제의 정답을 작은 문제의 정답에서 구할 수 있다`

  - 예시

    `서울`에서 `부산`을 가는 가장 빠른 길이 `대전과 대구를 순서대로 거쳐야 한다`면

    `대전`에서 `부산`을 가는 가장 빠른 길은 `대구`를 거쳐야 한다

  - 피보나치

    **문제의 정답을 작은 문제의 정답을 합하는 것으로 구할 수 있다**

  - 결론

    Optimal Substructure를 만족한다면, 문제의 크기에 상관없이 `어떤 한 문제의 정답은 일정`함

    10번 째 피보나치 수를 구하면서 구한 **4번째 피보나치 수**

    9번 째 피보나치 수를 구하면서 구한 **4번째 피보나치 수**

    ...

    5번 째 피보나치 수를 구하면서 구한 **4번째 피보나치 수**

    4번 째 피보나치 수를 구하면서 구한 **4번째 피보나치 수**

    `즉, 4번째 피보나치 수는 항상 같다`



- ### 다이나믹 프로그래밍

  - 다이나믹 프로그래밍에서 각 문제는 한 번만 풀어야 한다.
  - Optimal Substructure를 만족하기 때문에, 같은 문제는 구할 때 마다 정답이 같다
  - 따라서, 정답을 한번 구했으면, 정답을 어딘가에 메모해놓는다.
  - 이런 메모하는 것을 코드의 구현에서는 배열에 저장하는 것으로 할 수 있다
  - 메모를 한다고 해서 영어로 `Memoization`이라고 한다
    - 배열에다가 저장하는 방식으로 구현



- ### 피보나치 수 

  ```java
  int fibonacci (int n) {
      if (n <= 1) {
          return n;
      } else {
          return fibonacci(n-1) + fibonacci(n-2);
      }
  }
  ```

  - fibonacci(5) 를 수행했을 경우

  ![](https://imgur.com/ZAO0BLe.png)

  ![](https://imgur.com/LuF9D4z.png)

  ![](https://imgur.com/9DAnuH5.png)

  - 초록색으로 칠해진 f(3)이 왼쪽과 오른쪽에서 중복되므로
  - 오른쪽의 f(3)을 중복적으로 처리할 필요가 없음

  ```java
  int fibonacci (int n) {
      if (n <= 1) {
          return n;
      } else {
      	if (memo[n] > 0) {
              return memo[n]; // 다시 계산하지 않고 return
      	}
      	memo[n] = fibonacci(n-1) + fibonacci(n-2);
      	return memo[n];
      }
  }
  ```



- ### 다이나믹 프로그래밍

  1. Top-down : 큰 문제를 점점 작게 풀어나가는 방법
  2. Bottom-up : 작은 문제부터 풀어가는 방법

  - 구현을 어떻게 하냐의 차이일 뿐, 둘 중 하나만 먼저 잘하는 것도 좋다



- ### Top-down

  1. 문제를 작은 문제로 나눈다.
  2. 작은 문제를 푼다.
  3. 작은 문제를 풀었으니, 이제 문제를 푼다.

  

- ### Top-down

  1. 문제를 풀어야 한다
     - fibonacci(n)
  2. 문제를 작은 문제로 나눈다
     - fibonacci(n-1) 과 fibonacci(n-2) 로 문제를 나눈다.
  3. 작은 문제를 푼다.
     - fibonacci(n-1)과 fibnoacci(n-2)를 호출해 문제를 푼다.
  4. 작은 문제를 풀었으니, 이제 문제를 푼다.
     - fibonacci(n-1)의 값과 fibonacci(n-2)의 값을 더해 문제를 푼다.

  - 보통 재귀함수를 이용해서 풀음
  - 시간복잡도 계산 (피보나치의 경우 O(N))
    - 채워야 하는 칸의 수 x 1칸을 채우는 복잡도
      - 채워야 하는 칸의 수 : memo 배열에 몇개의 수가 채워질 것인가
      - 피보나치의 경우 n개가 채워짐
      - 1칸을 채우는 복잡도
        - fibonacci 의 경우 더하는 것 하나밖에 없기 때문에 O(1) 이라는 시간복잡도가 표현됨



- ### Bottom-up

  1. 문제를 크기가 작은 문제부터 차례대로 푼다.
  2. 문제의 크기를 조금씩 크게 만들면서 문제를 점점 푼다.
  3. 작은 문제를 풀면서 왔기 때문에, 큰 문제는 항상 풀 수 있다.
  4. 그러다보면, 언젠간 풀어야 하는 문제를 풀 수 있다.

  ```java
  int d[100];
  int fibonacci(int n) {
      d[0] = 0;
      d[1] = 1;
      for (int i=2; i<=n; i++) {
          d[i] = d[i-1] + d[i-2];
      }
      return d[n];
  }
  ```

  - 제일 작은문제 (i=2) 부터 제일 큰문제 (i<=n) 까지 푼다



- ### Top-down 은 재귀를 이용, Bottom-up 은 for문을 이용



- ### 피보나치에서 변수 표현
  - memo[i] = i 번째 피보나치 수
  - d[i] , dp[i] 정도로 표현함
  - i-1번째 피보나치 수 = d[i-1]
  - i-2 번째 피보나치 수 = d[i-2]
  - d[i] = d[i-1] + d[i-2]



- ### 다이나믹 문제풀이 전략

  - 문제에서 구하려고 하는 답을 문장으로 나타낸다
  - 예: 피보나치 수를 구하는 문제
  - N번째 피보나치 수
  - 이제 그 문장에 나와있는 변수의 개수만큼 메모하는 배열을 만든다
  - Top-down 인 경우에는 재귀 호출의 인자의 갯수
  - 문제를 작은 문제로 나누고, 수식을 이용해서 문제를 표현해야 한다



- ### [1로 만들기](https://www.acmicpc.net/problem/1463)

  - 세준이는 어떤 정수 N에 다음과 같은 연산중 하나를 할 수 있다
    - N이 3으로 나누어 떨어지면, 3으로 나눈다.
    - N이 2로 나누어 떨어지면, 2로 나눈다.
    - 1을 뺀다.
  - 12의 경우
    - 12 / 3 = 4
    - 4 / 2 = 2
    - 2 - 1 = 1
  - 10의 경우 (1)
    - 10 / 2 = 5
    - 5 - 1 = 4
    - 4 / 2 = 2
    - 2 - 1 = 1
  - 10의 경우 (2)
    - 10 - 1 = 9
    - 9 / 3 = 3
    - 3 / 3 = 1
  - D[N] = N을 1로 만드는데 필요한 연산의 최솟 값
  - N에서 3로 나눴을 경우
    -  N -> N/3 까지의 계산횟수는 1번
    - 즉, D[N] = D[N/3] + 1
  - N에서 2로 나눴을 경우
    - N -> N/2 까지의 계산횟수는 1번
    - 즉, D[N] = D[N/2] + 1
  - N에서 1을 뺐을 경우
    - N -> N-1 까지의 계산횟수는 1번
    - 즉, D[N] = D[N-1] + 1

  ```java
  // TOP-DOWN
  int go (int n) {
      if (n == 1) return 0;
      if (d[n] > 0) return d[n];
      d[n] = go(n-1) + 1;
      if (n%2 == 0) {
          int temp = go(n/2) + 1;
          if (d[n] > temp) d[n] = temp;
      }
      if (n%3 == 0) {
          int temp = go(n/3) + 1;
          if (d[n] > temp) d[n] = temp;
      }
      return d[n];
  }
  ```

  D[N] 을 전부 채우는데 N개가 필요함 * 1칸을 채우는데 걸리는 비용 = N * O(1)

  O(1)

  - go(n-1) + 1
  - go(n/2) + 1
  - go(n/3) + 1

  ```java
  // Bottom-up
  public static int bottomUp (int n) {
      d[1] = 0;
      for (int i=2; i<=n; i++) {
          d[i] = d[i-1] + 1;
          if (i%2 == 0 && d[i] > d[i/2] + 1) {
              d[i] = d[i/2] + 1;
          }
          if (i%3 == 0 && d[i] > d[i/3] + 1) {
              d[i] = d[i/3] + 1;
          }
      }
      return d[n];
  }
  ```

  



- ### [2 x n 타일링](https://www.acmicpc.net/problem/11726)

  2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

  아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.

  d[n] = `2 x n` 크기의 직사각형을 채우는 방법의 갯수

  - 2 x 0 = 1
    - 공집합도 1개
    - 빈 스트링도 1개
    - 그러므로, 없는 사각형이지만 1개로 구분
  - 2 x 1 = 1

  ![](https://imgur.com/QerwLQd.png)

  즉, `d[n] = d[n-2] + d[n-1]`

  - d[n-2] 의 사각형 오른쪽에 누워진 직사각형 2개가 붙음
  - d[n-1]의 사각형 오른쪽에 세워진 직사각형 1개가 붙음

  ```java
  //TOP-DOWN
      public static int topDown (int n) {
          if (n == 0 || n == 1) return 1;
          if (d[n] > 0) return d[n];
  
          d[n] = topDown(n-2) + topDown(n-1);
          d[n] %= 10007; // 여기서 10007 나머지계산을 하지 않으면, 이전의 d[n] 도 값이 전부 틀려져버리기 때문에 d[n]을 구할 때 마다 10007의 나머지계산을 진행 후에 저장
  
          return d[n];
      }
  ```

  ```java
  //BOTTOM-UP
      public static int bottomUp (int n) {
          d[0] = 1;
          if (n > 0) d[1] = 1;
          for (int i=2; i<=n; i++) {
              d[i] = d[i-2] + d[i-1];
              d[i] %= 10007; // 이 부분도 마찬가지
          }
          System.out.println(d[n]);
          return d[n];
      }
  ```

  어떻게보면 피보나치랑 비슷하기도 함 :)



- ### [2 x n 타일링 2](https://www.acmicpc.net/problem/11727)

  점화식 : `D[i] = 2 * D[i-2] + D[i-1]`

  2x2 타일이 늘어난 것은, 누워진 직사각형 2개가 붙은 `D[i-2] 와 동일한 부분`임

  ```java
  // BOTTOM-UP
  public static int bottomUp (int n) {
      d[0] = 1;
      if (n > 0) d[1] = 1;
      for (int i=2; i<=n; i++) {
          d[i] = (2 * d[i-2]) + d[i-1];
          d[i] %= 10007;
      }
      return d[n];
  }
  ```

  ```java
  // TOP-DOWN
  public static int topDown (int n) {
      if (n == 0 || n == 1) return 1;
      if (d[n] > 0) return d[n];
  
      d[n] = 2 * topDown(n-2) + topDown(n-1);
      d[n] %= 10007;
  
      return d[n];
  }
  ```




- ### [1, 2, 3 더하기](https://www.acmicpc.net/problem/9095)

  정수 4를 1, 2, 3의 조합으로 나타내는 방법은 총 7가지가 있다.

  - 1+1+1+1
  - 1+1+2
  - 1+2+1
  - 2+1+1
  - 2+2
  - 1+3
  - 3+1

  정수 n이 주어졌을 때, n을 1,2,3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

  `D[n] = n을 1, 2, 3의 조합으로 나타내는 방법의 수`

  `D[i] = D[i-1] + D[i-2] + D[i-3]`

  - 4일 경우
    - D[n-1] = D[3]
      - D[n-1] = D[2]
      - D[n-2] = D[1]
      - D[n-3] = D[0]
    - D[n-2] = D[2]
      - D[n-1] = D[1]
      - D[n-2] = D[0]
      - D[n-3] = D[-1]
    - D[n-3] = D[1]
  - D[0] = 1
    - DP 에서는 0도 1로 처리(?)
    - 빈 스트링
  - D[1] = 1
    - 1
  - D[2] = 2
    - 1+1
    - 2
  - D[3] = D[0] + D[1] + D[2] = 4
    - 1+1+1
    - 1+2
    - 2+1
    - 3

  ```java
  //TOP-DOWN
  public static int topDown (int n) {
      if (n == 0) {
          DP[0] = 1;
      }
      if (n == 1) {
          DP[1] = 1;
      }
      if (n == 2) {
          DP[2] = 2;
      }
      if (n >= 3) {
          DP[n] = topDown(n-1) + topDown(n-2) + topDown(n-3);
      }
      return DP[n];
  }
  ```

  ```java
  //BOTTOM-UP
  public static int bottomUp (int n) {
      DP[0] = 1; DP[1] = 1; DP[2] = 2;
      for (int i=3; i<=n; i++) {
          DP[i] = DP[i - 1] + DP[i - 2] + DP[i - 3];
      }
      return DP[n];
  }
  ```

  

- ### [붕어빵 판매하기](https://www.acmicpc.net/problem/9095)

  - `D[n] = n개 팔아서 얻을 수 있는 최대 수익`

  - 1개를 팔았을 경우

    `D[n-1] + P[1]`

  - 2개를 팔았을 경우

    `D[n-2] + P[2]`

  - 최대의 경우 `n개`

    `D[0] + P[n]`

  - 점화식 (i개를 팔았을 경우)

    `D[n-i] + P[i]`

  - `D[n] = max(D[n-i] + P[i])`

    - 1 <= i <= n

  - D[n] 한칸을 채우는데 `O(n)`

  - 붕어빵 판매하기의 시간 복잡도는 `O(n^2)`

  ```java
  //BOTTOM-UP
  public static int bottomUp (int n) {
      DP[0] = 0;
      for (int i=1; i<=n; i++) {
          for (int j=1; j<=i; j++) {
              DP[i] = Math.max(DP[i], DP[i-j] + P[j]);
          }
      }
      return DP[n];
  }
  ```




- ### [이친수](https://www.acmicpc.net/problem/2193)

  `0과 1로만 이루어진 수`를 이진수라 한다. 이러한 이진수 중 **특별한 성질**을 갖는 것들이 있는데, 이들을 `이친수(pinary number)`라 한다. 이친수는 다음의 성질을 만족한다.

  1. 이친수는 0으로 시작하지 않는다.
  2. 이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.

  예를 들면 1, 10, 100, 101, 1000, 1001 등이 이친수가 된다. 하지만 0010101이나 101101은 각각 1, 2번 규칙에 위배되므로 이친수가 아니다.

  N(1≤N≤90)이 주어졌을 때, N자리 이친수의 개수를 구하는 프로그램을 작성하시오.

  

  - D[n] = n자리 이친수

    1. n번째 자리에 0 이 오는 경우 : D[n-1]
    2. n번째 자리에 1 이 오는 경우
       - n-1번째 자리에 0이 와야 하고 즉, D[n-1] = 0
       - n-2번째 자리에는 0 또는 1이 올 수 있다 D[n-2] = 0 or 1

    - 점화식 : D[n] = D[n-1] + D[n-2]

  - `D[N][L]`

    - N자리 이친수 갯수 중에서 L로 끝나는 것의 갯수
    - 0으로 끝나는 경우
      - `D[N][0] ` = `D[N-1][0] + D[N-1][1]`
    - 1으로 끝나는 경우
      - `D[N][1]` = `D[N-1][0]`
    - 점화식 `D[N]` = `D[N][0] + D[N][1]`

  - 항상 자료형 신경쓸 것, `1<=N<=90` 이므로 `int`가 아닌 `Long` 으로 선언해주어야 함

    ```java
    //BOTTOM-UP
    public static long bottomUp (int n) {
        /*
                1: 1
                2: 10
                3: 100, 101
                4: 1000, 1001, 1010
                5: 10000, 10001, 10100, 10101, 10010
        */
    
        DP[0] = 0; DP[1] = 1;
    
        if (n == 1) {
            return DP[1];
        }
    
        for (int i=2; i<=n; i++) {
            DP[i] = DP[i-1] + DP[i-2];
        }
    
        return DP[n];
    }
    ```

    ```java
    //TOP-DOWN
    public static long topDown (int n) {
    
        if (n == 0 || n == 1 || n == 2) {
            return 1;
        }
    
        if (DP[n] > 0) {
            return DP[n];
        }
    
        DP[n] = topDown(n-1) + topDown(n-2);
    
        return DP[n];
    }
    ```



- ### [쉬운 계단 수](https://www.acmicpc.net/problem/10844)

  - `계단 수` 인접한 자리의 차이가 1이 나는 수 (예: 45656)
  - `길이가 N`인 계단 수의 개수를 구하는 문제
  - `D[N][L]` = N자리 계단수 (마지막 수 L)
  - `N`번째 자리가 `L ` 이라면,  `N-1`번째 자리는 `L-1` 과 `L+1`
    - 대신 `L` 은 `1<=L<=8` 이다 (0일경우 -1, 9일경우 10이되므로)
    - `D[N][0] = D[N-1][1]`
    - `D[N][9] = D[N-1][8]`
  - `D[N][L]` = `D[N-1][L-1]` + `D[N-1][L+1]`

  ```java
      public static long bottomUp (int n) {
  
          final long mod = 1000000000;
  
          /*
              갯수를 구하는 문제
              1 : D[1][1...9] = 9
              2 : D[2][?] = D[N-1][?-1] + D[N-1][?+1]
              10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98
          */
  
          // D[1][1...9] = 1
          for (int i=1; i<=9; i++) D[1][i] = 1;
          for (int i=2; i<=n; i++) {
              for (int j=0; j<=9; j++) {
                  /*
                      D[2][0] 은 1 (D[1][1] = 1)
                      D[2][1] 은 2 (D[1][0](0) + D[1][2])
                      D[2][2] 은 2 (D[1][1] + D[1][3])
                      D[2][3] 은 2 (D[1][2] + D[1][4])
                      ...
                      D[2][8] 은 2 (D[1][7] + D[1][9])
                      D[2][9] 은 1 (D[1][8])
                      D[2] = 17
                  */
                  D[i][j] = 0;
                  if (j-1 >= 0) D[i][j] += D[i-1][j-1];
                  if (j+1 <= 9) D[i][j] += D[i-1][j+1];
                  D[i][j] %= mod;
              }
          }
  
          long ans = 0;
          for (int i=0; i<=9; i++) ans += D[n][i];
          ans %= mod;
  
          return ans;
      }
  ```



- ### [오르막 수](https://www.acmicpc.net/problem/11057)

  - `오르막 수` 수의 자리가 오름차순을 이루는 수

  - 인접한 수가 같아도 오름차순으로 친다

  - 수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 문제
  - 수는 `0으로 시작`할 수 있음
  - 예: 1233345, 357, 8888888, 1555999
  - `D[N][L]` N자리 오르막 수 (마지막 수 L)
    - `N`의 자리에는 `L`이 온다면
    - `N-1` 의 자리에는 `0~L` 까지의 숫자가 오게 됨
      - `1233345` 에서 `L`은 `5` 이며, 그 앞자리는 `0`부터 `5`까지의 숫자로 채워짐
    - `K` = `0~L`

  ```java
  // BOTTOM UP    
  public static long bottomUp (int n) {
  
      final long mod = 10007;
  
      for (int i=0; i<=9; i++) D[1][i] = 1;
      for (int i=2; i<=n; i++) {
          for (int j=0; j<=9; j++) {
              // k = 0~J 까지의 범위를 뜻함
              // 인접한 수가 같아도 오름차순으로 치기 때문에
              // 해당 J까지의 반복문이 필요
              for (int k=0; k<=j; k++) {
                  D[i][j] += D[i-1][k];
                  D[i][j] %= mod;
              }
          }
      }
      long ans = 0;
      for (int i=0; i<=9; i++) ans += D[n][i];
      ans %= mod;
  
      return ans;
  }
  ```



- ### [스티커](https://www.acmicpc.net/problem/9465)

  - 스티커 2n개가 2 x n 모양으로 배치되어 있음

  - 스티커 한 장을 떼면 변을 공유하는 스티커는 모두 찢어져서 사용할 수 없음

  - 점수의 합을 최대로 만드는 문제

    ![](https://www.acmicpc.net/upload/images/sticker.png)

  - 점수를 무조건 최대로 만드는 부분으로 접근하면 안됨

    |  99  | 100  |  99  |
    | :--: | :--: | :--: |
    |  1   |  99  |  1   |

    100을 뜯어버리게 되면, 맨끝의 99와 가운데 99를 사용할 수 없게 되므로 합은 `102` 가 됨

    99를 뜯게 되면, 합은 `297` 이 됨

  - 스티커를 떼는 순서는 정해져있지 않음 (= 스티커를 떼는 순서를 맘대로 정해도 됨)

  - 왼쪽에서부터 스티커를 한 열씩 뜯을지/말지 고민할 수 있음

    |  X   |  O   |  X   |  O   |
    | :--: | :--: | :--: | :--: |
    |  X   |  X   |  O   |  O   |
    |  0   |  1   |  2   |  3   |

    3 번의 경우는 일어날 수 없음 (문제의 조건에 위배됨)

  - 점화식 `D[N][S] = 2 x n 스티커`

    - `S` `n번 열의 상태`
    - `A[i][j]`
    - `i` 열 `j` 행
    - `j=0` 뜯지 않음
    - `j=1` 위쪽 스티커를 뜯음
    - `j=2` 아래쪽 스티커를 뜯음

  - `D[N][0]` 이라면

    - MAX (`D[N-1][0]` `D[N-1][1]` `D[N-1][2]`)

  - `D[N][1]` 이라면

    - MAX (`D[N-1][0]` `D[N-1][2]`) + `A[N][1]`
    - `D[N-1][1]` 은 **같은 변을 공유**하기 때문에 불가능

  - `D[N][2]` 이라면

    - MAX (`D[N-1][0]` `D[N-1][1]`) + `A[N][2]`

  - 답 

    - MAX (`D[n][0]` `D[n][1]` `D[n][2]`)

  ```java
  import java.io.BufferedReader;
  import java.io.IOException;
  import java.io.InputStreamReader;
  
  public class Main {
  
      static long [][] D;
      static long [][] A;
  
      public static void main(String[] args) throws IOException {
          BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  
          int T = Integer.parseInt(bf.readLine());
  
          for (int i=0; i<T; i++) {
              int n = Integer.parseInt(bf.readLine());
              A = new long[2][n+1];
              String[] datas = bf.readLine().split(" ");
              String[] datas2 = bf.readLine().split(" ");
              for (int k=0; k<n; k++) {
                  A[0][k] = Long.parseLong(datas[k]);
                  A[1][k] = Long.parseLong(datas2[k]);
              }
              System.out.println(bottomUp(n));
          }
      }
  
      public static long topDown (int n) {
          return 0;
      }
  
      public static long bottomUp(int n) {
  
          /*
              초기값이 무엇일까?
              D[0][0]
  
              D[0][1]
              D[0][2]
              
              행렬 구분에 따라서 [0][i], [i][0] 순으로 변경됨
              현재 코드는 [행][렬]
          */
  
          long[][] d = new long[3][n+1];
          for (int i=1; i<=n; i++) {
              d[0][i] = Math.max(d[0][i-1], Math.max(d[1][i-1], d[2][i-1]));
              d[1][i] = Math.max(d[0][i-1], d[2][i-1]) + A[0][i-1];
              d[2][i] = Math.max(d[0][i-1], d[1][i-1]) + A[1][i-1];
          }
  
          long ans = 0;
          ans = Math.max(d[0][n], Math.max(d[1][n], d[2][n]));
  
          return ans;
      }
  }
  ```

  

- ### [포도주 시식](https://www.acmicpc.net/problem/9465)

  - 포도주가 일렬로 놓여져 있고, 다음과 같은 2가지 규칙을 지키면서 포도주를 최대한 많이 마시려고 함

  1. 포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
  2. 연속으로 놓여 있는 3잔을 모두 마실 수는 없다.

  - `D[i][j]` = A[1] ~ A[i] 포도주
  - `A[i]` : i번째 잔의 양
  - i번째 잔 : 연속 j 번
  - 0번 연속 : `D[n][0]` = `max(D[n-1][0], D[n-1][1], D[n-1[2])`
  - 1번 연속 : `D[n][1]` = `D[n-1][0] + A[n]`
  - 2번 연속 : `D[n][2]` = `D[n-1][1] + A[n]`
  -  
  - `D[i] = A[1], ... , A[i]` 까지 포도주를 마셨을 때, 마실 수 있는 포도주의 최대 양
  - 0번 연속해서 마신 포도주 : `A[i]` 를 마시지 않음
  - 1번 연속해서 마신 포도주 : `A[i-1]` 를 마시지 않음
  - 2번 연속해서 마신 포도주 : `A[i-1]` 을 마시고, `A[i-2]` 는 마시지 않았어야 함
  - 0번 연속 : `D[n-1]`
  - 1번 연속 : `D[n-2] + A[n]`
  - 2번 연속 : `D[n-3] + A[n] + A[n-1]`
  - 









