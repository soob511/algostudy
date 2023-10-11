from heapq import heappush, heappop

## const
DELTA = ((0,1),(1,0),(0,-1),(-1,0))

## input
Q = int(input())
COMMANDS = [list(map(int,input().split())) for _ in range(Q)]

## global
FIRST_LINE = COMMANDS[0]
N, M, P = map(int, FIRST_LINE[1:4])
DATA = FIRST_LINE[4:]
COMMANDS = COMMANDS[1:-1]

# pid: [total_jump, x, y, d, score]
BUNNIES = {DATA[i*2]:[0, 0, 0, DATA[i*2+1], 0] for i in range(P)}
# total_jump, xy, x, y, pid
PRIORITY = []
for pid in BUNNIES:
    total_jump, x, y, d, score = BUNNIES[pid]
    heappush(PRIORITY, (total_jump, x+y, x, y, pid))

def get_prime_location(x, y, d):
    location_priorities = []
    for dx, dy in DELTA:
        nx, ny = x+dx*d, y+dy*d
        if (nx//(N-1))%2 == 0:
            nx = nx%(N-1)
        else:
            nx = (N-1) - nx%(N-1)
        
        if (ny//(M-1))%2 == 0:
            ny = ny%(M-1)
        else:
            ny = (M-1) - ny%(M-1)
            
        location_priorities.append([nx+ny, nx, ny])
    location_priorities.sort()
    _, row, col = location_priorities[-1]
    return row, col

def move():
    ## 토끼 선정
    total_jump, _, x, y, pid = heappop(PRIORITY)
    _, _, _, d, score = BUNNIES[pid]

    ## 이동위치 선정
    r, c = get_prime_location(x, y, d)

    ## 토끼 정보 갱신
    BUNNIES[pid][0] = total_jump+1
    BUNNIES[pid][1] = r
    BUNNIES[pid][2] = c
    heappush(PRIORITY, (total_jump+1, r+c, r, c, pid))

    ## 점수 추가
    score = BUNNIES[pid][-1]
    for key in BUNNIES:
        BUNNIES[key][-1] += (r + c +2)
    BUNNIES[pid][-1] = score

    return pid

def after_move(moved, s):
    # -row+column, -row, -col, -pid
    bunny_priorities = []

    for pid in moved:
        _, x, y, _, _ = BUNNIES[pid]
        bunny_priorities.append(((x+y), x, y, pid))
    
    bunny_priorities.sort()
    BUNNIES[bunny_priorities[-1][-1]][-1] += s

def print_highest_score():
    result = 0
    for pid in BUNNIES:
        result = max(result,  BUNNIES[pid][-1])
    print(result)
    

def simulation():
    for line in COMMANDS:
        if line[0] == 200:
            _, k, s = line

            moved = set()
            for _ in range(k):
                moved.add(move())
            after_move(moved, s)
        elif line[0] == 300:
            _, pid_t, l = line
            BUNNIES[pid_t][3] *= l
    print_highest_score()

simulation()
