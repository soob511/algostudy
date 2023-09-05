# https://school.programmers.co.kr/learn/courses/30/lessons/12923

import math

def solution(begin, end):
    answer = []

    if begin == 1:
        answer.append(0)
        begin = 2
    
    for n in range(begin, end+1):
        high = math.floor(math.sqrt(n))
        low = 1
        for i in range(2, high+1):
            if n%i == 0:
                low = i
                if (n//i) <= 10_000_000:
                    answer.append(n//i)
                    break
        else:
            answer.append(low)
        
    return answer
