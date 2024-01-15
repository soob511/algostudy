# https://school.programmers.co.kr/learn/courses/30/lessons/142085
# total 변수 대신 list.sum() 사용시 시간 초과

import heapq

def solution(n, k, enemies):
    priority_queue = []
    total = 0
    
    for i, enemy in enumerate(enemies):
        heapq.heappush(priority_queue, -enemy)
        total += enemy
        if total > n:
            if k == 0:
                return i
            total += heapq.heappop(priority_queue)
            k-=1
    
    return len(enemies)
