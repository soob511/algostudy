from collections import deque

def solution(board):

    R = len(board)
    C = len(board[0])
    rx = ry = None
    visited = [[0 for _ in range(C)] for _ in range(R)]
    
    q = deque()
    
    for i in range(R):
        for j in range(C):
            if board[i][j]=='R':
                rx = i
                ry = j
                
    q.append([rx,ry])

    time = 1                              
    while q:
        s = len(q)
        while s > 0:
            v = q.popleft()
            vx = v[0]
            vy = v[1]                

            for d in range(4): 
                nx,ny = getNext(vx,vy,d,board,R,C)
                if (vx==nx and vy==ny) or (0<visited[nx][ny] and visited[nx][ny]<=time):
                    continue
                
                if board[nx][ny]=='G':
                    return time
                
                visited[nx][ny]=time
                q.append([nx,ny])

            s-=1
        time+=1

    return -1


def getNext(vx,vy,dir,board,R,C):
    # 북(0), 서(1), 남(2), 동(3)
    dr = [-1,0,1,0]
    dc = [0,-1,0,1]

    while True:
        nx = vx+dr[dir]
        ny = vy+dc[dir]

        if nx<0 or nx>=R or ny<0 or ny>=C or board[nx][ny]=='D':
            return vx,vy
        
        vx=nx
        vy=ny
