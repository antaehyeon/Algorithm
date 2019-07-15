def gcd(a, b):
    if b == 0: return a
    else: return gcd(b, a % b)


r = int(input())
for i in range(r):
    a, b = map(int, input().split())
    print(int(a / gcd(a, b) * b))
