from collections import deque

DELTA = ((0,1), (1,0), (0,-1), (-1,0))

N, L, R = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]

day_count = 0

while True:
    visit = [[0 for _ in range(N)]for _ in range(N)]
    union_count = 0
    gate_count = 0

    for x in range(N):
        for y in range(N):
            if visit[x][y]>0:
                continue
            
            union_count += 1
            Q = deque()

            visit[x][y] = union_count 
            total = A[x][y]
            units = [(x, y)]
            Q.append((x, y))

            while Q:
                r, c = Q.pop()
                
                for dr, dc in DELTA:
                    nr = r + dr
                    nc = c + dc

                    if nr<0 or nc<0 or nr>=N or nc>=N:
                        continue
                    if visit[nr][nc]>0:
                        continue

                    diff = abs(A[r][c] - A[nr][nc])
                    if diff<L or diff>R:
                        continue

                    visit[nr][nc] = union_count
                    total += A[nr][nc]
                    units.append((nr, nc))
                    Q.append((nr, nc))

                    gate_count += 1

            avg = total // len(units)
            for r, c in units:
                A[r][c] = avg

    if gate_count == 0:
        break

    day_count += 1

print(day_count)
