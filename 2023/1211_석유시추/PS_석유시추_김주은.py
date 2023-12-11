from collections import deque

def solution(land):
    
    dr = [0,1,0,-1]
    dc = [1,0,-1,0]
    
    N = len(land)
    M = len(land[0])
    
    visited = [[False for _ in range(M)] for _ in range(N)]
    line = [0 for _ in range(M)]
    maxx = 1

    for i in range(N):
        for j in range(M):
            if not visited[i][j] and land[i][j]==1:
                
                cols = set()                
                q = deque()
                
                visited[i][j]=True
                q.append([i,j])
                cnt=1

                while len(q)>0:
                    
                    x,y = q.pop()
                    cols.add(y)
                
                    for d in range(4):
                        n = x+dr[d]
                        m = y+dc[d]

                        if n<0 or n>=N or m<0 or m>=M or visited[n][m] or land[n][m]==0:
                            continue

                        visited[n][m] = True
                        q.append([n,m])
                        cnt+=1
                        
                for s in cols:
                    line[s]+=cnt
    
    maxx = 1
    for i in line:
        if maxx<i:
            maxx=i
            
    return maxx
