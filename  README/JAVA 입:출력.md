# Java 입/출력

- ### Hello World

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

- ### [Scanner](https://docs.oracle.com/javase/9/docs/api/java/util/Scanner.html)

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
  - INPUT
    - 1 2 3 4 5 6 a b c d e
  - OUTPUT
    - 21 (숫자만 더해서 출력)

  ```java
  Scanner sc = new Scanner (System.in);
  int n = sc.nextInt();
  String s = sc.nextLine();
  System.out.println(n + "\n" + s);
  ```

  - int와 String을 동시에 받을 때
  - 입력 : 1

      ​	  hi
  - 그러나, 1 뒤에 줄바꿈이 존재하기 때문에 n에는 1이 들어가지만
  - s 에는 줄바꿈 문자가 들어가므로 **올바른 결과를 얻을 수 없음**

  ```java
  Scanner sc = new Scanner (System.in);
  int n = sc.nextInt();
  sc.nextLine();
  String s = sc.nextLine();
  System.out.println(n + "\n" + s);
  ```

  - 중간에 줄바꿈이 한번 있어야 (sc.nextLine();) 원하는 결과를 얻을 수 있음

- ### [BufferedReader](https://docs.oracle.com/javase/9/docs/api/java/io/BufferedReader.html)

  - Scanner은 느린경우가 많기 때문에, **속도가 중요하다면 BufferedReader 을 사용!**

    ```java
    Scanner sc = new Scanner(System.in);

    int a, b;

    a = sc.nextInt();
    b = sc.nextInt();

    System.out.print(a + b);

    116 MS
    ```

    ```java
    BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));

    int a, b;

    a = bf.read();
    bf.read();
    b = bf.read();

    System.out.print(Character.getNumericValue(a) + Character.getNumericValue(b));

    72 MS
    ```

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

    84 MS
    ```

    - throws IOException

    - 스플릿 후, 각각의 숫자를 합침

    - int 의 범위를 고려하여 Long 형식으로 구현

    - **valueOf vs parseInt**

      ```java
      Integer.valueOf(String) == Integer.parseInt(String)
      ```

      - 객체로 받아오고 싶을 때는 valueOf (String) 을 사용
      - 아닐 경우에는 parseInt(String)

  - read와 readLine만 있기 때문에, **정수는 파싱**을 해야

    ```java
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("input a number");
    int n = Integer.parseInt(br.readLine());
    ```

- ### [stringTokenizer](https://docs.oracle.com/javase/9/docs/api/java/util/StringTokenizer.html)

  ![스크린샷 2018-01-09 오후 6.40.27](/Users/hyeon/Algorithm/image/스크린샷 2018-01-09 오후 6.40.27.png)

  - 어떤 문자열이 있을때 특정 토큰으로 자를 수 있음

  - [더하기 3](https://www.acmicpc.net/problem/11023)

    ```java
    public static void main(String[] args) throws IOException{
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

      String line = bf.readLine();

      StringTokenizer st = new StringTokenizer(line, " ");

      int sum = 0;

      while (st.hasMoreTokens()) {
        sum += Integer.valueOf(st.nextToken());
      }
      System.out.println(sum);
    }

    100 MS
    ```

    ![스크린샷 2018-01-09 오후 6.55.18](/Users/hyeon/Algorithm/image/스크린샷 2018-01-09 오후 6.55.18.png)

    - hasMoreElements() 가 내부적으로 hasMoreTokens() 를 호출하므로 통상적으로 hasMoreTokens()를 이용하는게 좋음
    - hasMoreElements () : **Returns** the same value as the **hasMoreTokens method.**
    - hasMoreTokens() : Tests if there are more tokens available from this tokenizer's string.

- ### [StringBuilder (java.lang.StringBuilder)](https://docs.oracle.com/javase/9/docs/api/java/lang/StringBuilder.html)

  - 출력해야할 것이 많은 경우에는 StringBuilder 을 이용해 문자열을 만들고, 출력하는 것이 좋음

  - [N찍기](https://www.acmicpc.net/problem/2741)

    ```java
    Scanner sc = new Scanner (System.in);
    int n = sc.nextInt();
    for (int i=1; i<=n; i++) {
      System.out.println(i);
    }

    668 MS
    ```

    - 해당 코드의 수행시간은 668 MS

    ```java
    Scanner sc = new Scanner (System.in);
    int n = sc.nextInt();
    StringBuilder sb = new StringBuilder();
    for (int i=1; i<=n; i++)
    	sb.append(i+"\n");
    System.out.print(sb);

    256 MS
    ```

    - 해당 코드의 수행시간은 256 MS

    ```java
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(bf.readLine());

    for (int i = 1; i <= n; i++) {
      sb.append(i + "\n");
    }
    System.out.print(sb);
    bf.close();

    216 MS
    ```

- ### ASCII 데이터를 숫자로 변경하기

  ```java
  int asciiValue = 53;
  int numericValue = Character.getNumericValue(asciiValue);

  System.out.println(numericValue);
  ```

  ​