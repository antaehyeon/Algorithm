# Java - BigInteger

- #### BigInteger : 큰 정수를 나타낼 때 사용

  - Int : 2^-31 ~ 2^31 -1
  - long : 2^-63 ~ 2^63 -1

- #### BigInteger 기본 문법

```java
BigInteger a = new BigInteger("10000");
BigInteger b = new BigInteger("1000");
BigInteger c = a.add(b);

System.out.println("a = " + a); // 10,000
System.out.println("b = " + b); // 1,000
System.out.println("c = " + c); // 11,000
```

- #### BigInteger 사칙연산

![](https://i.imgur.com/HtMRyTy.png)

- Point
  - 최대공약수 `gcd(a,b) = a.gcd(b)`
  - 부호를 바꾸는 경우 `a.negate()`
  - 자주 사용하는 0, 1, 10 을 `ZERO`, `ONE`, `TEN` 을 사용해서 간단하게 생성



- #### 입력 - 비교 (대소비교)

  ```java
  BigInteger a = sc.nextBigInteger();
  BigInteger b = sc.nextBigInteger();

  int c = a.compareTo(b);

  if (c < 0) System.out.println("<");
  else if (c == 0) System.out.println("==");
  else System.out.println(">");

  System.out.println("compareTo = " + c);
  ```

  - compare 는 그대로 비교하면 됨
    - c가 0보다 크다 `c < 0` 는 `a < b`  느낌

  ​

- #### 비교 (equals)

  ```java
  boolean e = a.equals(b);
  if (e) System.out.println("==");
  else System.out.println("!=");
  System.out.println("equals = " + e);
  ```

  ​

- #### [피보나치 수 4](https://www.acmicpc.net/problem/10826) 

  - 2의 10000승은 int나 long으로 구할 수 없음
  - BigInteger 을 사용

  ```java
  public class Main {
      public static void main(String args[]) throws IOException {
          BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
          int n = Integer.parseInt(bf.readLine());
          BigInteger[] d = new BigInteger[Math.max(n+1, 2)];
          d[0] = BigInteger.ZERO;
          d[1] = BigInteger.ONE;
          for (int i=2; i<=n; i++) {
              d[i] = d[i-1].add(d[i-2]);
          }
          System.out.println(d[n]);
      }
  }
  ```

  - `BigInteger[] d = new BigInteger[Math.max(n+1, 2)]`
    - Array를 만들 때, 기본 할당량을 처리하기 위해서 `Math.max` 를 사용
      - Math.max(A, B) = 둘중 큰 수를 리턴
  - 이후 피보나치의 기본 공식 `n-1` + `n-2` 를 적용



- #### [큰 수 A+B](https://www.acmicpc.net/problem/10757)

  - **Scanner** 사용 (18760KB, 320MS)

    ```java
    public class Main {
        public static void main(String args[]) throws IOException {
            //BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            Scanner sc = new Scanner(System.in);
            BigInteger a = sc.nextBigInteger();
            BigInteger b = sc.nextBigInteger();
            System.out.println(a.add(b));
        }
    }
    ```

  - **StringBuilder, BufferedReader** 사용 (10776KB, 196MS)

    ```java
    public class Main {
        public static void main(String args[]) throws IOException {

            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String line = bf.readLine();
            String[] lines = line.split(" ");

            BigInteger a = new BigInteger(lines[0]);
            BigInteger b = new BigInteger(lines[1]);

            System.out.println(a.add(b));
        }
    }
    ```

    - BigInteger 의 인자로 String 값을 넘겨주면, 자동으로 변환되어 BigInteger 이 생성됨 (new)