# https://school.programmers.co.kr/learn/courses/30/lessons/12946

def hanoi(n, start, end):
    if n == 1:
        return [[start, end]]
    
    other = 6 - (start+end)
    
    return [*hanoi(n-1, start, other), [start, end], *hanoi(n-1, other, end)]


def solution(n):
    answer = hanoi(n, 1, 3)
    return answer
