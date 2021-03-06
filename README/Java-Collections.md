# Java - Collections

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

    - **Capacity = 40** 으로 정한 ArrayList 를 만든 것

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

  - BufferedList `120MS`

  - Scanner `220MS`

  - 결국 ArrayList는 배열이기 때문에 추가, 값이 있는지 없는지 확인, 삭제 하는 것 모두 O(n) 이라는 시간이 걸림

  - ArrayList는 **그래프 문제의 인접 리스트를 만들 때**, 가장 많이 사용

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
  - peek : Looks at the object at the top of this stack without removing it from the stack.
  - Stack 문제시
    - Stack이 비어있는데 접근하지는 않는지
    - 인덱스 범위가 잘못 접근되지는 않는지
    - Scanner + StringTokenizer : `388MS`
    - BufferedReader + split : `248MS`
    - BufferedReader + StringTokenizer : `256MS`

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
      - 삽입/삭제/제거 연산의 시간복잡도가 `O(1)`
      - 순서가 보장되지 않음
      - 집합이 필요하긴 한데, 순서가 뒤바뀌어도 되는 경우에만 사용
        - **반드시 오름차순이거나 내림차순이 필요 없을 때**
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
      - 삽입/삭제/제거 연산의 시간 복잡도가 `O(logN)` 이다
      - **순서가 보장됨**
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

      - 삽입/삭제/제거 연산의 시간복잡도가 `O(1)` 임
      - 추가한 순서가 보장됨

  - **일반적인 경우에는 HashSet**

  - **순서가 중요한 경우에는 TreeSet**

    - Upper bound, Lower bound 를 사용해야 하는 경우
      - 가장 가까운 두점을 구하는 Line Sweep 알고리즘에서 사용

  - **입력으로 넣은 순서가 중요한 경우에는 LinkedHashSet**

- ### [숫자 카드](https://www.acmicpc.net/problem/10815)

  > 상근이가 가지고 있는 숫자카드를 모두 Set에 넣고, 있는지 없는지 확인하면 됨
  >
  > 단, 순서가 중요하지 않음 (어떤 카드를 가지고 있는지 아닌지만 중요)
  >
  > HashSet 사용 !

  - HashSet : `764 MS`
  - TreeSet : `1028 MS`
  - LinkedHashSet : `832 MS`

  ```java
  import java.util.*;
  import java.io.*;
  public class Main {
      public static void main(String args[]) throws IOException {
          BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
          int n = Integer.parseInt(bf.readLine());
          StringTokenizer st = new StringTokenizer(bf.readLine());
          HashSet<Integer> d = new HashSet<Integer>();
          while (st.hasMoreTokens()) {
              int num = Integer.parseInt(st.nextToken());
              d.add(num);
          }
          int m = Integer.parseInt(bf.readLine());
          st = new StringTokenizer(bf.readLine());
          StringBuilder sb = new StringBuilder();
          while (st.hasMoreTokens()) {
              int num = Integer.parseInt(st.nextToken());
              if (d.contains(num)) {
                  sb.append("1 ");
              } else {
                  sb.append("0 ");
              }
          }
          System.out.println(sb);
      }
  }
  ```

- ### 회사에 있는 사람

  ```java
  import java.util.*;
  import java.io.*;
  public class Main {
      public static void main(String args[]) throws IOException {
          BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
          int n = Integer.parseInt(bf.readLine());
          HashSet<String> d = new HashSet<String>();
          while (n-- > 0) {
              String[] line = bf.readLine().split(" ");
              if (line[1].equals("enter")) {
                  d.add(line[0]);
              } else {
                  d.remove(line[0]);
              }
          }
          String[] ans = d.toArray(new String[d.size()]);
          Arrays.sort(ans);
          int m = ans.length;
          for (int i=m-1; i>=0; i--) {
              System.out.println(ans[i]);
          }
      }
  }
  ```

  ```java
  import java.io.*;
  import java.util.TreeSet;

  public class Main {
      public static void main(String args[]) throws IOException {
          TreeSet<String> treeset = new TreeSet<>();
          BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
          int n = Integer.parseInt(bf.readLine());

          for (int i=0; i<n; i++) {
              String line = bf.readLine();
              String[] lines = line.split(" ");
              String name = lines[0];
              String type = lines[1];
              if (type.equals("enter")) {
                  treeset.add(name);
              } else if (type.equals("leave")) {
                  treeset.remove(name);
              }
          } // for i-n

          int size = treeset.size();

          for (int i=0; i<size; i++) {
              String s = treeset.last();
              System.out.println(s);
              treeset.remove(s);
          }
      } // MAIN
  }
  ```

  - Set에서 Array로 옮기는 코드

    ```java
    String[] ans = d.toArray(new String[d.size()]);
    ```

  ​

- ### Map

  > SET과 비슷하지만 KEY, VALUE 쌍을 저장하는 'Map'

  ```java
  Map<K, V>
  void clear()
  boolean containsKey(Object key) - 어떤 KEY를 가지고 있는지 아닌지 판단
  boolean containsValue(Object value) - 어떤 VALUE를 가지고 있는지 아닌지 판단
  Set<Map.Entry<K,V>> entrySet() - KEY, VALUE의 쌍을 이용한 SET을 생성
  V get(Object key) - get(KEY)로 해당 VALUE를 리턴
  boolean isEmpty()
  Set<K> keySet() - KEY를 이용한 SET을 만들어줌
  V put(K key, V value) - KEY에 해당하는 VALUE를 지정
  boolean remove(Object o)
  int size() - MAP에 있는 KEY의 크기를 받아오는
  ```

  - 인터페이스

  - 중복된 KEY를 포함하지 않음

  - KEY-VALUE 쌍을 이룸

    - HashMap (HashTable 을 이용해 구현)
    - TreeMap (레드 블랙 트리)
    - LinkedHashMap (연결리스트와 HashTable을 이용해 구현)

  - 저항

    ```java
            HashMap<String, Integer> hmap = new HashMap<>();
            HashMap<String, Integer> innerMap = new HashMap<>();
            String[] colorArray = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

            int n = 1;
            for (int i=0; i<10; i++) {
                hmap.put(colorArray[i], i);
                innerMap.put(colorArray[i], n);
                n *= 10;
            }

            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            String a = bf.readLine();
            String b = bf.readLine();
            String c = bf.readLine();
            long ans = hmap.get(a)*10 + hmap.get(b);
            ans *= innerMap.get(c);

            System.out.println(ans);
    ```

    ​


  - 듣보잡

    > 순서가 중요하기 때문에 TreeMap을 이용해서 구현한다고 생각할 수 있다
    >
    > 그러나, 출력만 순차적으로 해주면 되기 때문에 HashMap을 이용해서 풀고 출력을 정렬해서 할 수 있다

    처음에 Set을 이용해서 풀려고 했으나, **시간초과**

    ```java
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] lines = bf.readLine().split(" ");
    int a = Integer.parseInt(lines[0]);
    int b = Integer.parseInt(lines[1]);

    HashMap<String, Integer> hm = new HashMap<>();
    for (int i=0; i<a; i++) {
        String name = bf.readLine();
        hm.put(name, 1);
    } // FOR-듣는사람 입력문
    for (int i=0; i<b; i++) {
        String name = bf.readLine();
        Integer c = hm.get(name);
        if (c == null) {
            c = 0;
        }
        c += 2;
        hm.put(name, c);
    } // FOR-보는사람 입력문

    ArrayList<String> list = new ArrayList<String>();
    for (Map.Entry<String, Integer> entry : hm.entrySet()) {
        if (entry.getValue() == 3) {
            list.add(entry.getKey());
        }
    }

    Collections.sort(list);
    System.out.println(list.size());

    for (String s : list) {
        System.out.println(s);
    }
    ```

    1. Integer 과 int의 차이
       - Integer 은 Wrapper Class 이므로 NULL 값을 받을 수 있음
       - SQL에서 많이 사용됨 (NULL 을 처리할 수 있으므로)
    2. Map에 기존의 KEY로 `put`을 진행시, `value`가 **업데이트**됨
    3. for (Map.Entry<String, Integer> entry : Map.entrySet()) { }
       - Key와 Value를 쌍으로 만든 SET을 리턴함
       - SET.getKey()
       - SET.getValue()

- ### Queue

  > 한쪽 끝에서만 자료를 넣고 다른 한쪽 끝에서만 뺄 수 있는 자료구조 (일방향 통로)
  >
  > 먼저 넣은 것이 가장 먼저 나오기 때문에 First In First Out (FIFO) 구조라고 함

  ```java
  push
  pop
  front
  back - 큐에서는 사실 가장 앞에있는 데이터가 중요하지 뒤에 있는 데이터는 별로 중요하지 않음
  empty
  size
  ```

  - 인터페이스
  - ArrayDeque
  - LinkedList
  - PriorityQueue

  ```java
  push: boolean offer(E e)
  pop:E poll()
  front: E peek()
  empty: boolean isEmpty()
  size: int size()
  ```

  - add와 offer의 차이점

    - boolean add(E e)
      - Queue에 추가를 실패하였을 경우 예외를 던짐
    - boolean offer(E e)
      - Queue에 추가를 실패하였을 경우 false값을 리턴한 후, 예외를 던짐

  - [ArrayDeque 와 LinkedList 의 차이점](http://brianandstuff.com/2016/12/12/java-arraydeque-vs-linkedlist/)

  - C++ STL 과 차이점

    - pop 을 할 때 poll 이 가장 앞에 있는것을 출력해주고 
    - STL 은 pop을 할 때 리턴값이 존재하지 않고 기능만 처리

  - 큐(문제번호 10845)

    ```java
    import java.util.*;
    import java.io.*;
    public class Main {
        public static void main(String args[]) throws IOException {
            ArrayDeque<String> a = new ArrayDeque<>();
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bf.readLine());
            for (int i=0; i<n; i++) {
                String[] lines = bf.readLine().split(" ");
                switch (lines[0]) {
                    case "push":
                        a.offer(lines[1]);
                        break;
                    case "pop":
                        if (a.isEmpty()) {
                            System.out.println("-1");
                            break;
                        }
                        System.out.println(a.poll());
                        break;
                    case "size":
                        System.out.println(a.size());
                        break;
                    case "empty":
                        if(a.isEmpty()) System.out.println("1");
                        else            System.out.println("0");
                        break;
                    case "front":
                        if (a.isEmpty()) {
                            System.out.println("-1");
                            break;
                        }
                        System.out.println(a.peekFirst());
                        break;
                    case "back":
                        if (a.isEmpty()) {
                            System.out.println("-1");
                            break;
                        }
                        System.out.println(a.peekLast());
                        break;
                } // switch
            } // for i-n
        } // Main
    }
    ```

    - LinkedList `240MS`
    - ArrayDeque `236MS`

- ### PriorityQueue

  >우선순위 큐, 큐에 들어있는 것 중에서 **우선순위가 가장 높은것 부터** pop 이 되는 큐
  >
  >최대힙, 최소힙을 구현할 때 주로 사용

  - 최소 힙

  ```java
  Scanner sc = new Scanner(System.in);
  PriorityQueue<Integer> q = new PrioirtyQueue<Integer>();
  int n = sc.nextInt();
  while(n-- > 0) {
    int x = sc.nextInt();
    if (x == 0) {
      if (q.isEmpty()) {
        	System.out.println(0);
      } else {
        	System.out.println(q.poll());
      }
    } else {
      q.offer(x);
    }
  }
  ```

   - 우선순위가 낮은 것(작은 것)부터 나오는 큐이기 때문에 offer 을 하고 poll 으로 진행
  - 최대 힙

  ```java
  static class Compare implements Comparator<Integer> {
    public int compare(Integer one, Integer two) {
      return two.compareTo(one);
    }
  }
  ```

  ```java
  Scanner sc = new Scanner(System.in);
  Compare cmp = new Compare();
  PriorityQueue<Integer> q = new PrioirtyQueue<Integer>(1, cmp);
  int n = sc.nextInt();
  while(n-- > 0) {
    int x = sc.nextInt();
    if (x == 0) {
      if (q.isEmpty()) {
        	System.out.println(0);
      } else {
        	System.out.println(q.poll());
      }
    } else {
      q.offer(x);
    }
  }
  ```

  ​

