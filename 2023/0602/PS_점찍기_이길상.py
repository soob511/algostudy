# https://school.programmers.co.kr/learn/courses/30/lessons/140107

import math

def solution(k, d):
    answer = 0
    
    for ak in range(0, d+1, k):
        limit = math.sqrt(d*d - ak*ak)
        
        answer += limit//k
        answer += 1

    
    return answer
