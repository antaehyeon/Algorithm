answer = 0
n = int(input())
L = list(map(int, input().split()))


def prime(p):
    if (p < 2): return False
    i = 2
    while i * i <= p:
        if (p % i == 0): return False
        i += 1

    return True


for i in L:
    if (prime(i)): answer += 1

print(answer)
