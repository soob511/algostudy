from collections import deque

def solution(maps):
    
    N = len(maps)
    M = len(maps[0])
    
    dr = [0,1,0,-1]
    dc = [1,0,-1,0]
    
    visited = [[0 for _ in range(M)] for _ in range(N)]
    queue = deque()
    
    queue.append([0,0,1])
    
    while queue:
        
        v = queue.popleft()
        
        if v[0]==N-1 and v[1]==M-1:
            return v[2]
        
        for d in range(4):
            nr = v[0]+dr[d]
            nc = v[1]+dc[d]
            
            if nr<0 or nr>=N or nc<0 or nc>=M or maps[nr][nc]==0 or visited[nr][nc]==1:
                continue
                
            visited[nr][nc]=1
            queue.append([nr,nc,v[2]+1])

    
    return -1
