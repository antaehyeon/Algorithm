# 순열

1 부터 N 까지로 이루어진 순열
순서가 중요하다

- 다음 순열

  C++ STL 의 next_permutation, prev_permutation 를 사용

  1. A[i-1] < A[i] 를 만족하는 가장 큰 i를 찾는다 
  2. j >= i 이면서 A[j] > A[i-1] 를 만족하는 가장 큰 j를 찾는다
  3. A[i-1] 과 A[j]를 swap 한다
  4. A[i] 부터 순열을 뒤집는다



























