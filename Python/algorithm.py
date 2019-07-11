def solution(numbers, target):
    answer_list = [0]
    for i in numbers:
        temporary_list = []
        for j in answer_list:
            temporary_list.append(j+i)
            temporary_list.append(j-i)
        answer_list = temporary_list
    answer = answer_list.count(target)
    return answer


print(solution([1, 1, 1, 1, 1], 3))
