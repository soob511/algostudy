# https://school.programmers.co.kr/learn/courses/30/lessons/87390

def solution(n, left, right):
    return [max(i//n + 1, i%n + 1) for i in range(left, right + 1)]



# def solution(n, left, right):
#     answer = []
#     for i in range(left, right + 1):
#         answer.append(max(i//n + 1, i%n + 1))
#     return answer
