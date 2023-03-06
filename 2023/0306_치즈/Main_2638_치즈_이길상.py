import sys
sys.setrecursionlimit(10000)

N, M = map(int, input().split())
FIELD = [list(map(int, input().split())) for _ in range(N)]
DELTA = [[1,0],[-1,0],[0,1],[0,-1]]

# 공기에 노출된 치즈 표시
def exposed(x, y, visited):
    for dx, dy in DELTA:
        nx = x+dx
        ny = y+dy

        if nx<0 or ny<0 or nx>=N or ny>=M:
            continue
        if FIELD[nx][ny] == 1:
            visited[nx][ny]+=1
            continue
        if visited[nx][ny]<0:
            continue
        visited[nx][ny] = -1
        exposed(nx, ny, visited)

# 표시된 치즈 없애기
def meltdown(visited):
    count = 0
    for n in range(N):
        for m in range(M):
            if visited[n][m] >= 2:
                FIELD[n][m] = 0
                count += 1
    return count

hour = 0

while True:
    visited = [[0 for _ in range(M)] for _ in range(N)]
    visited[0][0] = -1

    exposed(0, 0, visited)

    if meltdown(visited) == 0:
        break

    hour += 1

print(hour)
