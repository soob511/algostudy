# https://www.codetree.ai/training-field/frequent-problems/tree-tycoon

MOVE = [[0, 1], [-1, 1], [-1, 0], [-1, -1], [0, -1], [1, -1], [1, 0], [1, 1]]
NEARBY = [[1, 1], [-1, -1], [1,-1],[-1,1]]

# 입력
N, M = map(int, input().split())
LIBRO = [list(map(int, input().split())) for _ in range(N)]

# 영양제
PROTEIN = [[False for _ in range(N)] for _ in range(N)]
PROTEIN[N-1][0] = PROTEIN[N-1][1] = PROTEIN[N-2][0] = PROTEIN[N-2][1] = True

for m in range(M):
    # 영양제 이동
    d, p = map(int, input().split())
    dx, dy = MOVE[d-1]
    
    TEMP = [[False for _ in range(N)] for _ in range(N)]
    for x in range(N):
        for y in range(N):
            if PROTEIN[x][y]:
                PROTEIN[x][y] = False

                nx = (x + dx*p) % N
                ny = (y + dy*p) % N
                TEMP[nx][ny] = True

    # 높이 1 증가
    for x in range(N):
        for y in range(N):
            if TEMP[x][y]:
                LIBRO[x][y]+=1
    
    # 인접한 만큼 증가
    for x in range(N):
        for y in range(N):
            if TEMP[x][y]:
                count = 0
                for dx, dy in NEARBY:
                    nx = x+dx
                    ny = y+dy
                    if nx<0 or nx>=N or ny<0 or ny>=N:
                        continue
                    if LIBRO[nx][ny] < 1:
                        continue
                    count += 1
                LIBRO[x][y] += count

    # 벌목
    for x in range(N):
        for y in range(N):
            if not TEMP[x][y] and LIBRO[x][y] >= 2:
                LIBRO[x][y]-=2
                PROTEIN[x][y] = True
    
print(sum([sum(line) for line in LIBRO]))
