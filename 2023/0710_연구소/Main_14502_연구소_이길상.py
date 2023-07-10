DELTA = ((1,0), (-1,0), (0,1), (0,-1))

N, M = map(int, input().split())
MAP = [list(map(int, input().split())) for _ in range(N)]
answer = [0]

def wall(x, y, i):
    if i == 3:
        virus()
        return

    for r in range(x, N):
        start = 0
        if r == x:
            start = y
        for c in range(start, M):
            if MAP[r][c] == 0:
                MAP[r][c] = 1
                wall(r, c, i+1)
                MAP[r][c] = 0

def virus():
    visited = [[False for _ in range(M)] for _ in range(N)]

    for x in range(N):
        for y in range(M):
            if MAP[x][y] == 2:
                dfs(x, y, visited)
    count = 0
    for x in range(N):
        for y in range(M):
            if MAP[x][y] == 0 and not visited[x][y]:
                count += 1

    answer[0] = max(answer[0], count)

def dfs(x, y, visited):
    visited[x][y] = True

    for dx, dy in DELTA:
        nx = x+dx
        ny = y+dy

        if nx<0 or ny<0 or nx>=N or ny>=M:
            continue
        if visited[nx][ny]:
            continue
        if MAP[nx][ny]==1:
            continue

        dfs(nx, ny, visited)

wall(0, 0, 0)

print(answer[0])
