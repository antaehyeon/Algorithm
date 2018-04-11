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

     ​