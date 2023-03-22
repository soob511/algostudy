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
# 효율성 테스트 결과
# 테스트 1 〉	통과 (1.30ms, 10.2MB)
# 테스트 2 〉	통과 (1.64ms, 10.4MB)


# heapq 사용한 코드
import heapq

def solution(n, works):
    if sum(works) < n:
        return 0
    
    pq = []
    
    for w in works:
        heapq.heappush(pq, -w)
    
    for _ in range(n):
        num = heapq.heappop(pq)
        if num ==0:
            break
        heapq.heappush(pq, num+1)
    
    answer = 0
    for w in pq:
        answer += w**2
 
    return answer
# 효율성 테스트 결과
# 테스트 1 〉	통과 (348.76ms, 10.2MB)
# 테스트 2 〉	통과 (381.86ms, 10.2MB)
