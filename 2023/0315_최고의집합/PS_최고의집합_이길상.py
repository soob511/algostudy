# https://school.programmers.co.kr/learn/courses/30/lessons/12938

def solution(n, s):
    if n > s:
        return [-1]
    
    q = s // n
    rest = s % n
    
    answer = [q for _ in range(n-rest)] + [q+1 for _ in range(rest)]
    
    return answer
