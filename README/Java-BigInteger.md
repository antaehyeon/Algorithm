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



