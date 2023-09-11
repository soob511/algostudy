
import copy

## 상수
FISH_MOVE = ((0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1), (1,0), (1,-1))
SHARK_MOVE = ((-1,0), (0,-1), (1,0), (0,1))
N = 4

## 변수
GRID = [[[] for _ in range(N)] for _ in range(N)]
SMELL = [[0 for _ in range(N)] for _ in range(N)]

## 입력
M, S = map(int, input().split())
for _ in range(M):
    x, y, d = map(int, input().split())
    GRID[x-1][y-1].append(d-1)
r, c = map(int, input().split())
SHARK = (r-1, c-1)

### 함수
def valid_location(x, y):
    if x<0 or y<0 or x>=N or y>=N:
        return False
    return True

def magic():
    return copy.deepcopy(GRID)

def move_fish(x, y, d):
    for _ in range(len(FISH_MOVE)):
        dx, dy = FISH_MOVE[d]
        nx, ny = x+dx, y+dy
        
        if not valid_location(nx, ny):
            pass
        elif SMELL[nx][ny] > 0:
            pass
        elif SHARK == (nx, ny):
            pass
        else:
            x, y = nx, ny
            break

        d = (d-1)%len(FISH_MOVE)
    
    return x, y, d

def move_fishes():
    result = [[[] for _ in range(N)] for _ in range(N)]

    for x in range(N):
        for y in range(N):
            for d in GRID[x][y]:
                nx, ny, nd = move_fish(x, y, d)
                result[nx][ny].append(nd)
    
    return result

def simulation_shark(x, y, score, limit, visited, result):
    if len(visited) == limit:
        if score > result[1]:
            result[0] = copy.deepcopy(visited)
            result[1] = score
        return

    for d in range(len(SHARK_MOVE)):
        dx, dy = SHARK_MOVE[d]
        nx, ny = x+dx, y+dy

        if not valid_location(nx, ny):
            continue
        
        next_score = score
        if (nx, ny) not in visited:
            next_score += len(GRID[nx][ny])
        visited.append((nx, ny))
        simulation_shark(nx, ny, next_score, limit, visited, result)
        visited.pop()

def move_shark():
    x, y = SHARK
    
    result = [[(x,y), (x,y), (x,y)], -1]
    simulation_shark(x, y, 0, 3, [], result)

    for r, c in result[0]:
        if GRID[r][c]:
            GRID[r][c].clear()
            SMELL[r][c] = 3
    
    return result[0][-1]

def reduce_smell():
    for x in range(N):
        for y in range(N):
            if SMELL[x][y]>0:
                SMELL[x][y] -= 1

def magic_complete(new_grid):
    for x in range(N):
        for y in range(N):
            GRID[x][y] += new_grid[x][y]

## 구현
for _ in range(S):
    # 1
    new_grid = magic()
    # 2
    GRID = move_fishes()
    # 3
    SHARK = move_shark()
    # 4
    reduce_smell()
    # 5
    magic_complete(new_grid)

result = 0
for x in range(N):
    for y in range(N):
        result += len(GRID[x][y])
print(result)
