# https://school.programmers.co.kr/learn/courses/30/lessons/42628

import heapq

def solution(operations):
    inout = [False for _ in operations]
    
    MAX = []
    MIN = []

    for i, line in enumerate(operations):
        if line[0] == 'I':
            num = int(line.split()[1])
            heapq.heappush(MAX,(-num, i))
            heapq.heappush(MIN,(num, i))
            inout[i] = True
        elif len(line) > 3:
            while MIN and not inout[MIN[0][1]]:
                heapq.heappop(MIN)
            if MIN:
                val, idx = heapq.heappop(MIN)
                inout[idx] = False
        else:
            while MAX and not inout[MAX[0][1]]:
                heapq.heappop(MAX)
            if MAX:
                val, idx = heapq.heappop(MAX)
                inout[idx] = False
            
    while MIN and not inout[MIN[0][1]]:
        heapq.heappop(MIN)
    while MAX and not inout[MAX[0][1]]:
        heapq.heappop(MAX)

    if not MAX:
        MAX.append((0,0))
    if not MIN:
        MIN.append((0,0))
        
    return [-MAX[0][0], MIN[0][0]]
