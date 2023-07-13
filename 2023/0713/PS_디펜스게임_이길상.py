# https://school.programmers.co.kr/learn/courses/30/lessons/142085#

import heapq

def solution(n, k, enemy):
    
    descend = []
    count = 0
    answer = 0
    for e in enemy:
        count += e
        heapq.heappush(descend, -e)
        
        if n < count:
            if k>0:
                k-=1
                count += heapq.heappop(descend)
            else:
                break
            
        answer += 1
    
    return answer
