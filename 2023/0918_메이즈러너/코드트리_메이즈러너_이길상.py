N, M, K = map(int, input().split())
MAZE = [list(map(int, input().split())) for _ in range(N)]
PEOPLE = []
for _ in range(M):
    x, y = map(int, input().split())
    PEOPLE.append([x-1, y-1])
x, y = map(int, input().split())
RESULT = [0]
EXIT = [x-1, y-1]

def distance(x, y, r, c):
    return abs(x-r) + abs(y-c)

def next_move(x, y, exit, maze):
    delta = ((1,0), (-1,0), (0,1), (0,-1))
    exit_x, exit_y = exit
    dist = distance(x, y, exit_x, exit_y)
    for dx, dy in delta:
        nx, ny = x+dx, y+dy
        if distance(nx, ny, exit_x, exit_y) == dist-1 and maze[nx][ny] == 0:
            return nx, ny
    return -1, -1

def move(maze, people, exit):
    exit_x, exit_y = exit
    temp = []
    for i in range(len(people)):
        x, y = people[i]
        nx, ny = next_move(x, y, exit, maze)
        if (nx, ny) == (exit_x, exit_y):
            RESULT[0] += 1
        elif (nx, ny) == (-1, -1):
            temp.append([x, y])
        else:
            RESULT[0] += 1
            temp.append([nx, ny])
    people.clear()
    people.extend(temp)

def set_rotate(people, exit):
    r, c = exit

    fx, fy, fd = N, N, N
    for x, y in people:
        nx, ny = max(x, r), max(y, c)
        nd = max(abs(x-r), abs(y-c)) + 1

        nx, ny = nx-nd+1, ny-nd+1
        if nx < 0:
            nx = 0
        if ny <0:
            ny = 0

        if (nd, nx, ny) < (fd, fx, fy):
            fx, fy, fd = nx, ny, nd
    
    return fx, fy, fd

def rotate_exit(x, y, d, exit):
    r, c = exit
    if x <= r < x+d and y <= c < y+d:
        dr, dc = r-x, c-y
        r, c = x+dc, y+d-1-dr
        exit[0]=r
        exit[1]=c

def rotate_people(x, y, d, people):
    for i in range(len(people)):
        r, c = people[i]
        if x <= r < x+d and y <= c < y+d:
            dr, dc = r-x, c-y
            r, c = x+dc, y+d-1-dr
            people[i] = [r, c]        

def rotate_maze(x, y, d, maze):
    rotated = [[0 for _ in range(N)] for _ in range(N)]
    for r in range(d):
        for c in range(d):
            rotated[c][d-1-r] = maze[x+r][y+c]
    for r in range(d):
        for c in range(d):
            if rotated[r][c] > 0:
                rotated[r][c] -= 1
            maze[x+r][y+c] = rotated[r][c]

def rotate(maze, people, exit):
    x, y, d = set_rotate(people, exit)

    rotate_exit(x, y, d, exit)
    rotate_people(x, y, d, people)
    rotate_maze(x, y, d, maze)


for k in range(K):

    move(MAZE, PEOPLE, EXIT)

    if not PEOPLE:
        break

    rotate(MAZE, PEOPLE, EXIT)

print(RESULT[0])
print(EXIT[0]+1, EXIT[1]+1)
