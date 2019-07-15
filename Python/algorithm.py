def gcd(a, b):
    if b == 0: return a
    else: return gcd(b, a % b)


# 2개의 입력값이 정해져 있다면 n, m = map(int, input().split())
L = list(map(int, input().split()))
a = L[0]
b = L[1]
gcdN = gcd(a, b)

print(gcdN)
print(int((a / gcdN) * b))
