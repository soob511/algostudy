import sys 
sys.setrecursionlimit(10000)

def solution(maps):

    answer = []

    R = len(maps)
    C = len(maps[0])
    visited = [[False for _ in range(C)] for _ in range(R)]

    dr = [0,1,0,-1]
    dc = [1,0,-1,0]
    
    def dfs(x,y):
        sums=int(maps[x][y])
        for d in range(4):
            nx = x+dr[d]
            ny = y+dc[d]
            if nx<0 or nx>=R or ny<0 or ny>=C or maps[nx][ny]=='X' or visited[nx][ny]:
                continue
            visited[nx][ny]=True
            sums += dfs(nx,ny)

        return sums
    
    for i in range(R):
        for j in range(C):
            if maps[i][j]=='X' or visited[i][j]:
                continue
            visited[i][j]=True
            answer.append(dfs(i,j))
            
    return  sorted(answer) if answer else [-1]
            
    
