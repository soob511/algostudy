DELTA = ((1,0), (-1,0), (0,1), (0,-1))

N, M = map(int, input().split())
MAP = [list(map(int, input().split())) for _ in range(N)]

empty_count = 0
for line in MAP:
    for cell in line:
        if cell == 0:
            empty_count += 1

answer = [N*N]
Q = []

def active(x, y, i):
    if i == M:
        virus()
        return

    for r in range(x, N):
        start = 0
        if r == x:
            start = y
        for c in range(start, N):
            if MAP[r][c] == 2:
                Q.append((r,c))
                MAP[r][c] = 3
                
                active(r, c, i+1)

                Q.pop()
                MAP[r][c] = 2

def virus():
    QQ = Q[:]

    visited = [[False for _ in range(N)] for _ in range(N)]
    for x, y in QQ:
        visited[x][y] = True
    
    sec = 0
    count = 0
    while True:
        temp = []

        if count == empty_count:
            answer[0] = min(answer[0], sec)
            return

        for x, y in QQ:
            for dx, dy in DELTA:
                nx, ny = x+dx, y+dy

                if nx<0 or ny<0 or nx>=N or ny>=N:
                    continue
                if MAP[nx][ny] == 1 or visited[nx][ny]:
                    continue

                if MAP[nx][ny] == 0:
                    count += 1
                
                visited[nx][ny] = True
                temp.append((nx, ny))
        
        if not temp:
            return

        QQ = temp
        sec += 1

active(0, 0, 0)

if answer[0] == N*N:
    print(-1)
else:
    print(answer[0])
