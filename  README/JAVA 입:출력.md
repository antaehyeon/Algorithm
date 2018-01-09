# Java 입/출력

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