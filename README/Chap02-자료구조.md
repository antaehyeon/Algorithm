# Chap 02. 자료구조

1. ### 스택

   > Last In First Out (LIFO)

   - **push**
   - **pop**
   - **top**
   - **empty**
   - **size**

   **C++** 에서는 `STL stack` 을 사용

   **JAVA**에서는 `java.util.Stack` 사용

   만약 **Stack** 을 구현해야 한다면 `Array` 를 통해서 구현

   - **push**

     `array` 의 `size` 번째에 데이터를 넣는 식으로 구현

     ```java
     stack[size] = v;
     size += 1;
     ```

   - **top**

     `stack` 의 `size-1` 번 째를 지워버리면 됨

     ```
     stack[size-1] = 0;
     size -= 1;
     ```

   - [괄호](https://www.acmicpc.net/problem/9012)




2. ### 큐

   > 한쪽 끝에서만 자료를 넣고 다른 한쪽 끝에서만 뺄 수 있는 구조 (FIFO)

   - push
   - pop
   - front : 큐의 가장 앞에있는 자료를 보는 연산
   - back : 큐의 가장 뒤에있는 자료를 보는 연산
   - empty
   - size

   **C++** 은 `STL`

   **Java**는 `java.util.Queue`

   만약 Queue 를 구현해야 한다면, `begin` 과 `end` 를 이용

   - **push**

     ```
     queue[end] = val
     end += 1
     ```

   - **pop**

     ```
     queue[begin] = 0
     begin += 1
     ```



3. ### 덱

   > 양 끝에서만 자료를 넣고 뺄 수 있는 자료구조
   >
   > Double-ended queue의 약자

   - push_front
   - push_back
   - pop_front
   - pop_back
   - front : 덱의 가장 앞에 있는 자료를 보는 연산
   - back : 덱의 가장 뒤에 있는 자료를 보는 연산





















