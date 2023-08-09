import sys
sys.setrecursionlimit(10000)

N, Q = map(int, input().split())
N = 1<<N
A = [list(map(int, input().split())) for _ in range(N)]
L = list(map(int, input().split()))

DELTA = ((-1,0), (1,0), (0,1), (0,-1))

def rotate(x, y, n):
    new_grid = [[A[x+n-1-c][y+r] for c in range(n)]for r in range(n)]
    for r in range(n):
        for c in range(n):
            A[x+r][y+c] = new_grid[r][c]

def melt():
    flag = [[False for _ in range(N)] for _ in range(N)]
    for x in range(N):
        for y in range(N):
            count = 0
            for dx, dy in DELTA:
                nx, ny = x+dx, y+dy

                if nx<0 or ny<0 or nx>=N or ny>=N:
                    continue
                if A[nx][ny] > 0:
                    count += 1
            if count < 3:
                flag[x][y] = True
    
    for x in range(N):
        for y in range(N):
            if flag[x][y] and A[x][y] > 0:
                A[x][y] -= 1

def max_cluster():
    results = []
    visited = [[False for _ in range(N)] for _ in range(N)]
    for x in range(N):
        for y in range(N):
            if not visited[x][y] and A[x][y] > 0:
                results.append(0)
                dfs(x, y, visited, results)
    
    return max(results)

def dfs(x, y, visited, results):
    results[-1] += 1
    visited[x][y] = True
    for dx, dy in DELTA:
        nx, ny = x+dx, y+dy

        if nx<0 or ny<0 or nx>=N or ny>=N:
            continue
        if not visited[nx][ny] and A[nx][ny] > 0:
            dfs(nx, ny, visited, results)

for grade in L:
    # rotate
    n = 1 << grade
    for x in range(0, N, n):
        for y in range(0, N, n):
            rotate(x, y, n)
    
    # melt
    melt()

print(sum([sum(line) for line in A]))
print(max_cluster())
