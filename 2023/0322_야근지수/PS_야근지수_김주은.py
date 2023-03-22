from heapq import heappush, heappop

def solution(n, works):
    
    if sum(works)<=n:
        return 0
    
    heap = []
    for w in works:
        heappush(heap, -w)
        
    for i in range(n):
        w = heappop(heap)
        heappush(heap, w+1)
        
    print(heap)
        
    answer = 0
    for i in heap:
        answer+=i*i
        
        
    return answer
