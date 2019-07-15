primes = []
n = 1000000
check = [True, True] + [False] * (n - 1)
isFlag = False

for i in range(2, n + 1):
    if not check[i]:
        primes.append(i)
        for j in range(i * i, n + 1, i):
            check[j] = True

while True:
    n = int(input())
    if n == 0:
        break

    for p in primes:
        if not check[n - p]:
            print(n, "=", p, "+", n - p)
            isFlag = True
            break

if not isFlag:
    print("Goldbach's conjecture is wrong.")
