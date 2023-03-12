def solution(jobs):
    
    answer = 0
    now = 0
    i = 0
    start = -1
    heap = []
        
    while i < len(jobs):
        for j in jobs:
            if start < j[0] <= now:
                heappush(heap, [j[1],j[0]])
        if heap:
            curr = heappop(heap)
            start = now
            now += curr[0]
            answer += (now - curr[1])
            i+=1
        else:
            now+=1
            
    
    return int(answer/len(jobs))
