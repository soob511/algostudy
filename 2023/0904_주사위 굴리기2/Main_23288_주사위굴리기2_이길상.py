
## 상수
DELTA = ((-1,0), (0,-1), (1,0), (0,1))

## 입력받기
N, M, K = map(int, input().split())
MAP = [list(map(int, input().split())) for _ in range(N)]

## 시작 상태
score = 0
x, y = 0, 0
d = 3
dice = {
    'top': 1,
    'bottom':6,
    'east': 3,
    'south': 5,
    'north': 2,
    'west': 4
}

## 함수
def set_point(x, y, d):
    dx, dy = DELTA[d]
    nx, ny = x+dx, y+dy

    if nx<0 or ny<0 or nx>=N or ny>=M:
        d = (d+2)%4
        dx, dy = DELTA[d]
        nx, ny = x+dx, y+dy
    
    return nx, ny, d

def set_d(d, a, b):
    if a>b:
        return (d-1)%4
    elif a<b:
        return (d+1)%4
    else:
        return d
    
def get_score(x, y):
    visited = [[False for _ in range(M)] for _ in range(N)]
    visited[x][y] = True
    count = 1
    num = MAP[x][y]
    queue = [(x,y)]

    while queue:
        temp = []
        for r, c in queue:
            for dx, dy in DELTA:
                nx, ny = r+dx, c+dy
                if nx<0 or ny<0 or nx>=N or ny>=M:
                    continue
                if visited[nx][ny] or MAP[nx][ny] != num:
                    continue
                
                visited[nx][ny] = True
                count += 1
                temp.append((nx, ny))
        queue = temp
    
    return count * num

def rotate_dice(d, dice):
    # 동
    if d == 3:
        dice['east'], dice['bottom'], dice['west'], dice['top'] = dice['top'], dice['east'], dice['bottom'], dice['west']
    # 서
    elif d == 1:
        dice['west'], dice['top'], dice['east'], dice['bottom'] = dice['top'], dice['east'], dice['bottom'], dice['west']
    # 남
    elif d == 2:
        dice['south'], dice['bottom'], dice['north'], dice['top'] = dice['top'], dice['south'], dice['bottom'], dice['north']
    # 북
    elif d == 0:
        dice['north'], dice['bottom'], dice['south'], dice['top'] = dice['top'], dice['north'], dice['bottom'], dice['south']


## 시뮬레이션
for _ in range(K):

    # 1. 주사위 굴리기
    x, y, d = set_point(x, y, d)
    rotate_dice(d, dice)

    # 2. 점수 획득
    score += get_score(x, y)

    # 3. 이동 방향 결정
    d = set_d(d, dice['bottom'], MAP[x][y])

print(score)
