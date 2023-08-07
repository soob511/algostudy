N, M = map(int, input().split())
GRID = [list(map(int, input().split())) for _ in range(N)]

DELTA = ((-1,0), (1,0), (0,1), (0,-1))

def dfs(color, x, y, visited, group):
    visited[x][y] = color
    group[0] += 1
    group[4].append((x, y))
    if GRID[x][y] == 0:
        group[1] += 1
    else:
        group[2] = min(group[2], x)
        group[3] = min(group[3], y)

    for dx, dy in DELTA:
        nx, ny = x + dx, y + dy
        
        if nx<0 or ny<0 or nx>=N or ny>=N:
            continue
        if visited[nx][ny] == color:
            continue
        if GRID[nx][ny]==color or GRID[nx][ny]==0:
            dfs(color, nx, ny, visited, group)

def gravity():
    for y in range(N):
        for x in range(N-1, -1, -1):
            if GRID[x][y] >= 0:
                tx = x+1
                while tx<N and GRID[tx][y] == -2:
                    tx+=1
                if tx-1 != x:
                    GRID[tx-1][y] = GRID[x][y]
                    GRID[x][y] = -2


score = 0

while True:
    prime_group = [0, 0, 0, 0, []] # length, rainbow, row, col, member
    visited = [[0 for _ in range(N)]for _ in range(N)]

    # find
    for x in range(N):
        for y in range(N):
            if GRID[x][y] > 0 and GRID[x][y] != visited[x][y]:
                group = [0, 0, 0, 0, []]
                dfs(GRID[x][y], x, y, visited, group)
                if group > prime_group:
                    prime_group = group

    # break check
    if prime_group[0] < 2:
        break

    # remove
    for x, y in prime_group[4]:
        GRID[x][y] = -2
    score += prime_group[0]**2

    # gravity
    gravity()

    # rotate
    new_grid = [[GRID[y][N-x-1] for y in range(N)]for x in range(N)]
    GRID = new_grid

    # gravity
    gravity()

print(score)
