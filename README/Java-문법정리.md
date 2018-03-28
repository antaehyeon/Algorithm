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



















