# https://school.programmers.co.kr/learn/courses/30/lessons/12985
def solution(n,a,b):
    answer = 0
    
    while a != b:
        a = (a+1)//2
        b = (b+1)//2
        answer += 1

    return answer



# https://school.programmers.co.kr/learn/courses/30/lessons/138476
def solution(k, tangerine):
    count = dict()
    
    for t in tangerine:
        if t in count:
            count[t] += 1
        else:
            count[t] = 1
    
    values = sorted(list(count.values()))
    
    answer = 0
    while k > 0:
        k -= values.pop()
        answer += 1
    
    return answer
