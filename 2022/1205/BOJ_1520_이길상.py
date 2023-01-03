import sys
sys.setrecursionlimit(100000)

M, N = map(int, input().split())

MAP = [list(map(int, input().split())) for n in range(M)]

DP = [[-1 for n in range(N)] for m in range(M)]
DP[0][0] = 1
dx = [0,0,1,-1]
dy = [1,-1,0,0]

def route(x, y):
    if DP[x][y] < 0:
        DP[x][y] = 0
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]

            if nx<0 or ny<0 or nx>=M or ny>=N: continue
            if MAP[nx][ny] <= MAP[x][y]: continue
            
            DP[x][y] += route(nx, ny)
            
    return DP[x][y]


print(route(M-1, N-1))
