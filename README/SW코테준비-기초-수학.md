# 최대공약수

- GCD
- 약수 : N을 나눌 수 있는 수 
  - 24 : 1,2,3,4,6,8,12,24

```
int g = 1;
for (int i=2; i<=min(a,b); i++) {
	if(a%i == 0 && b%i == 0) {
		g = i
	}
}
```

- 유클리드 호제법

  - GCD(a, b) == GCD(b, a%b)
  - GCD(24, 16) = GCD(16, 8) = GCD(8, 0) = 8

  ```
  int gcd(int a, int b) {
  	if (b==0) return a;
  	else return gcd(b, a%b)
  }
  ```

  

# 최소공배수

- LCM
  - (a*b) / gcd(a,b)



# 소수

- 약수가 1과 자기자신밖에 없는 수

  - 2보다 크거나 같고, [N-1, N/2, 루트N] 보다 작거나 같은 자연수로 나누어 떨어지면 안된다
    - N = a*b 에서 a의 최솟값이 제일 작은 **2** 가 된다면, b는 N/2 이므로 (a가 3이면 N/3) b의 최댓값인 **N/2 보다 작거나 같으 면 된다**

- 소수 판별하는 방법

  ```
  bool prime(int n) {
  	if (n < 2) return false;
  	for (int i=2; i<=n-1; i++) { // 또는 	for (int i=2; i<=n/2; i++) { // 또는 i*i<=n;
  		if (n % i == 0) {
  			return false;
  		}
  	}
  	return true;
  }
  // i*i <= n 이 가장 좋은 알고리즘 (시간복잡도 루트N)
  ```

  - O(N)

- N보다 작거나 같은 모든 소수를 찾아내는 방법

  

# 에라토스테네스의 체

- 1은 소수가 아니다
- 2는 소수이고 2의 배수를 모두 지운다
- 3은 소수이고 3의 배수를 모두 지운다
- 5는 소수이고 5의 배수를 모두 지운다
- 7은 소수이고 7의 배수를 모두 지운다…

```
// 시간복잡도 Nlog(logN) - 좋은 알고리즘
int priem[100];
int pn=0;
bool check[101];
int n = 100;
for (int i=2; i<=n; i++) {
	if (!check[i]) {
		prime[pn++] = i;
		for (int j=i*i; j<=n; j+=i) check[j] = true;
	}
}
```



# 골드바흐의 추측

- 2보다 큰 모든 짝수는, 두 소수의 합으로 표현 가능하다
- 위의 문장에 3을 더하면
- 5보다 큰 모든 홀수는 세 소수의 합으로 표현 가능하다
- 로 바뀐다
- **10^18 이하에서만 참**



























