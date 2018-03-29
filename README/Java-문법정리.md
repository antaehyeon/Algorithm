# JAVA

- EOF처리

  ```
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  while ((line = br.readLine()) != null && line.length() != 0) {
    ///..
  }

  근데 엔터는 한번 더 쳐야된다는게 함정

  Scanner sc = new Scanner(System.in);

  while(sc.hasNextLine()) {
    sc.nextLine();
  }

  while(sc.hasNextInt()) {
    sc.nextInt();
  }
  ```

- DFS / BFS

  ![](https://cdn.namuwikiusercontent.com/s/1fe9246903b78fae07577b243a0b22791e02cb39640d5cbaae10d9849343b4ea6f162a9a677a5892fbf7819abd4ef7221ebd3608849cfb66793411fb5e6439514ed5c5e86db6d87a310ee3a249998ad2?e=1528159424&k=r3mCuuvSpH1FMcdeAaKDiw)

- .trim() : 앞뒤 공백을 다 잘라버림

- Queue

  - offer [객체를 넣음]
  - poll [큐에서 데이터를 꺼냄]
  - peek [맨 아래의 객체를 반환함, 대신 큐에서 제거하진 않음]

- 재귀를 사용할때에는 변수 자체의 값을 바꿔서 보내지말고, 바꾼 값을 보낼 것

- 검사문을 따로 빼는것도 좋은 방법




- 순열 사이클

  ![](http://postfiles16.naver.net/MjAxNzAxMjBfMTAg/MDAxNDg0ODg2MjQ2MDg2.afKKnIG5_x6NGwtMXs27WOn00RVMJJk9tdZy6P86PpEg.6iMeKjDmWjhaUPRNo98wPa27duA-yhDLulf5dCWYDJMg.JPEG.occidere/image_1720970261484886234692.jpg?type=w773)



- 숫자를 하나씩 찢어버리기

  ```java
      public static int[] splitNumber (int n) {

          int size = String.valueOf(n).length();

          int[] result = new int[size];

          String temp = String.valueOf(n);
          String[] datas = temp.split("");

          for (int i=0; i<size; i++) {
              result[i] = Integer.parseInt(datas[i]);
          }

          return result;

      }
  ```

- FastScanner

  ```java
  class FastScanner {
      BufferedReader br;
      StringTokenizer st;

      FastScanner(InputStream i) throws Exception {
          br = new BufferedReader(new InputStreamReader(i));
      }

      String next() throws Exception {
          while (st == null || !st.hasMoreTokens()) {
              st = new StringTokenizer(br.readLine());
          }
          return st.nextToken();
      }

      int nextInt() throws Exception {
          return Integer.parseInt(next());
      }
  }
  ```

- char to int

  `char - '0'`


















