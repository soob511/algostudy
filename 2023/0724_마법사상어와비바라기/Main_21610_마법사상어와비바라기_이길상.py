DELTA = ((0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1), (1,0), (1,-1))

N, M = map(int, input().split())
WATER = [list(map(int, input().split())) for _ in range(N)]
CLOUD = [(N-1,0),(N-1,1),(N-2,0),(N-2,1)]


for m in range(M):
    d, s = map(int, input().split())
    d -= 1

    # 구름 이동, 물 1 증가
    MOVED = []
    for r, c in CLOUD:
        nr = (r + DELTA[d][0]*s) % N
        nc = (c + DELTA[d][1]*s) % N

        WATER[nr][nc] += 1
        MOVED.append((nr, nc))
    
    # 물복사
    ADDED = [[0 for _ in range(N)] for _ in range(N)]
    for r, c in MOVED:
        count = 0

        for dr in range(-1, 2, 2):
            for dc in range(-1, 2, 2):
                nr = r + dr
                nc = c + dc

                if nr<0 or nc<0 or nr>=N or nc>=N:
                    continue

                if WATER[nr][nc] > 0:
                    count += 1

        ADDED[r][c]+= count

    # 복사된 물 더하고 구름 생성
    CLOUD = []
    for r in range(N):
        for c in range(N):
            WATER[r][c] += ADDED[r][c]

            if WATER[r][c] >= 2 and (r,c) not in MOVED:
                CLOUD.append((r,c))
                WATER[r][c] -= 2
    
print(sum([sum(line) for line in WATER]))


