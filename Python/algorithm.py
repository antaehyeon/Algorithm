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


def solution(numbers, target):
    answer_list = [0]
    for i in numbers:
        temporary_list = []
        for j in answer_list:
            temporary_list.append(j + i)
            temporary_list.append(j - i)
        answer_list = temporary_list
    answer = answer_list.count(target)
    return answer


print(solution([1, 1, 1, 1, 1], 3))
