N = int(input())
INFO = [list(map(int, input().split())) for _ in range(N*N)]
INFOMAP = {line[0]:line for line in INFO}
SEAT = [[0 for _ in range(N)] for _ in range(N)]

DELTA = ((0,1),(1,0),(0,-1),(-1,0))
SCORE = [0, 1, 10, 100, 1000]

# 조건점수 계산
def get_scores(x, y, info):
    result = [0,0,x,y]
    for dx, dy in DELTA:
        nx, ny = x+dx, y+dy
        
        if nx<0 or ny<0 or nx>=N or ny>=N:
            continue
        
        if SEAT[nx][ny] == 0:
            result[1] -= 1
        if SEAT[nx][ny] in info:
            result[0] -= 1
    
    return result

# 최적의 위치에 배치
def set_location(info):
    results = []
    for x in range(N):
        for y in range(N):
            if SEAT[x][y] > 0:
                continue
            results.append(get_scores(x, y, info))
    
    results.sort()
    tx, ty = results[0][2], results[0][3]
    SEAT[tx][ty] = info[0]

def scenario():
    for line in INFO:
        set_location(line)

    total = 0
    for x in range(N):
        for y in range(N):
            key = SEAT[x][y]
            friends = -get_scores(x, y, INFOMAP[key])[0]
            total += SCORE[friends]

    print(total)

scenario()
