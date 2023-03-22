# https://school.programmers.co.kr/learn/courses/30/lessons/12927

def solution(n, works):
    if sum(works) < n:
        return 0
    
    works.sort(key = lambda x: -x)
    L = len(works)
    
    answer = 0
    area = 1
    
    for w in works:
        while (area == L or w > works[area]) and n >= area:
            w -= 1
            n -= area
        
        if n < area:
            for i in range(n):
                answer += (w-1)*(w-1)
            for i in range(n, area):
                answer += w*w
            for i in range(area, L):
                answer += works[i]*works[i]

            break
        
        area += 1
    
    return answer
