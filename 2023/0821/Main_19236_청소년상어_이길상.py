import copy

# 상수
DELTA = ((-1,0), (-1,-1), (0,-1), (1,-1), (1,0), (1,1), (0,1), (-1,1))
N = 4

# 초기 변수
GRID = [[0 for _ in range(N)] for _ in range(N)]
FISH = [[] for _ in range(N*N)]
answer = 0

# 콘솔 입력
for r in range(N):
    line = list(map(int, input().split()))
    for c in range(N):
        a, b = line[c*2]-1, line[c*2+1]-1

        GRID[r][c] = a
        FISH[a] = [r, c, b]

# 상어
SHARK = [0, 0, FISH[GRID[0][0]][2], GRID[0][0]+1]
FISH[GRID[0][0]][2] = -1

# 물고기 이동
def move_fish(shark, fish, grid):
    for i in range(N*N):
        if fish[i][2] < 0: 
            continue
        
        for _ in range(8):
            r, c, b = fish[i]
            dr, dc = DELTA[b]
            nr, nc = r+dr, c+dc

            if nr<0 or nc<0 or nr>=N or nc>=N:
                pass
            elif nr == shark[0] and nc == shark[1]:
                pass
            else:
                j = grid[nr][nc]

                grid[nr][nc], grid[r][c] = i, j
                fish[i][0], fish[i][1] = nr, nc
                fish[j][0], fish[j][1] = r, c
                break

            fish[i][2] = (fish[i][2]+1)%8 

# 상어 이동
def moved_shark(shark, fish, grid):
    sr, sc, sb, score = shark
    dr, dc = DELTA[sb]

    results = []

    sr, sc = sr+dr, sc+dc
    while sr>=0 and sc>=0 and sr<N and sc<N:
        fa = grid[sr][sc]
        fr, fc, fb = fish[fa]

        if fb>=0:
            nshark = [sr, sc, fb, score+fa+1]
            nfish = copy.deepcopy(fish)
            ngrid = copy.deepcopy(grid)
            nfish[fa][2] = -1
            
            # 가능한 경우를 deep copy하여 리스트로 반환
            results.append([nshark, nfish, ngrid])
        
        sr, sc = sr+dr, sc+dc
    
    return results



def siumulation(shark, fish, grid):
    move_fish(shark, fish, grid)

    results = moved_shark(shark, fish, grid)

    # 가능한 경우가 존재하지 않으면 return
    if len(results) == 0:
        global answer
        answer = max(answer, shark[-1])
        return
    
    for nshark, nfish, ngrid in results:
        siumulation(nshark, nfish, ngrid)
    

siumulation(SHARK, FISH, GRID)

print(answer)
