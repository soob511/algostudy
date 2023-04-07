# https://www.codetree.ai/training-field/frequent-problems/colored-bomb

N, M = map(int, input().split())

FIELD = [list(map(int, input().split())) for _ in range(N)]

DELTA = [[1,0],[0,1],[-1,0],[0,-1]]

def select(x, y, color, cluster, visited, red):
    for dx, dy in DELTA:
        nx = x + dx
        ny = y + dy

        if nx<0 or nx>=N or ny<0 or ny>=N:
            continue

        # 다른 색
        if FIELD[nx][ny] == color :
            if visited[nx][ny]:
                continue

            visited[nx][ny] = True
            # 기준점 갱신
            if nx > cluster[1]:
                cluster[1] = nx
            elif nx == cluster[1] and ny < cluster[2]:
                cluster[2] = ny
            cluster[3].append((nx, ny))
            select(nx, ny, color, cluster, visited, red)
        
        # 빨간 색
        elif FIELD[nx][ny] == 0:
            if red[nx][ny]:
                continue

            red[nx][ny] = True
            # 빨간 폭탄 개수 세기
            cluster[0] += 1   
            cluster[3].append((nx, ny))
            select(nx, ny, color, cluster, visited, red)

def gravity():
    for col in range(N):
        for row in range(N-1, -1, -1):
            # 빈 공간일 경우
            if FIELD[row][col] == -2:
                # 비어있지 않은 위 칸을 찾아서
                next = row
                while next>= 0 and FIELD[next][col] == -2:
                    next-=1
                
                if next<0:
                    continue

                # 그게 폭탄일 경우 아래로 내린다.
                if FIELD[next][col] >= 0:
                    FIELD[row][col] = FIELD[next][col]
                    FIELD[next][col] = -2


def rotate():
    new_field = [[0 for _ in range(N)] for _ in range(N)]

    for x in range(N):
        for y in range(N):
            new_field[N-y-1][x] = FIELD[x][y]
    
    return new_field

## main
score = 0
while True:
    # 폭탄 선택
    visited = [[False for _ in range(N)] for _ in range(N)]
    bombs = []
    for x in range(N):
        for y in range(N):
            if not visited[x][y] and FIELD[x][y] > 0:
                visited[x][y] = True
                red = [[False for _ in range(N)] for _ in range(N)]
                # 빨간 폭탄 수, 기준행, 기준열, 좌표 목록
                cluster = [0, x, y, [(x, y)]]
                select(x, y, FIELD[x][y], cluster, visited, red)
                
                if len(cluster[3]) > 1:
                    bombs.append(cluster)

    bombs.sort(key = lambda x: (-len(x[3]), x[0], -x[1], x[2]))

    # 폭탄 묶음이 없으면 정지
    if not bombs:
        break

    # 폭파
    score += len(bombs[0][3])**2
    for x, y in bombs[0][3]:
        FIELD[x][y] = -2

    # 중력
    gravity()

    # 회전
    FIELD = rotate()

    # 중력
    gravity()


print(score)
