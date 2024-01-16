from queue import PriorityQueue

def solution(n, k, enemy):
    
    pq = PriorityQueue()
    
    for idx, e in enumerate(enemy, start=1):
        
        pq.put((-e,e))
        n-=e
        
        if n<0:
            if k>0:
                n+=pq.get()[1]
                k-=1
            else:
                return idx-1
            
    return len(enemy)
    
