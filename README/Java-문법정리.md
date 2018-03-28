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

  ​