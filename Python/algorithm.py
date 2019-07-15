def gcd(a, b):
    if b == 0: return a
    else: return gcd(b, a % b)


for _ in range(int(input())):
    n, *a = map(int, input().split())
    s = 0
    for i in range(0, n - 1):
        for j in range(i + 1, n):
            s += gcd(a[i], a[j])
    print(s)