import collections


def solution(participant, completion):
    answer = collections.Counter(participant) - collections.Counter(completion)
    return answer.keys()[0]


print(solution(["leo", "kiki", "eden"], ["eden", "kiki"]))
