N, M, K = map(int, input().split())
CANNONS = [[{'damage': num, 'turn': 0}
            for num in map(int, input().split())] 
            for _ in range(N)]

DELTA = ((0,1),(1,0),(0,-1),(-1,0))


def choose_two():
    priority_list = []

    for x in range(N):
        for y in range(M):
            cannon = CANNONS[x][y]
            if cannon['damage'] <= 0:
                continue
            priority_list.append((
                cannon['damage'],
                -cannon['turn'],
                -(x+y),
                -y,
                (x, y),
            ))

    if len(priority_list) == 1:
        print(priority_list[0][0])
        exit(0)

    priority_list.sort()

    return priority_list[0][-1], priority_list[-1][-1]

def get_direction(start):
    direction = [[-1 for _ in range(M)] for _ in range(N)]
    direction[start[0]][start[1]] = 0

    nodes = [start]
    while nodes:
        next_nodes = []
        for x, y in nodes:
            for d in range(4):
                dx, dy = DELTA[d]
                nx = (x+dx)%N
                ny = (y+dy)%M

                if CANNONS[nx][ny]['damage'] <= 0:
                    continue
                if direction[nx][ny] != -1:
                    continue
                    
                direction[nx][ny] = d
                next_nodes.append((nx, ny))
        nodes = next_nodes
    
    return direction

def laser_attack(attacker, target, direction):
    ax, ay = attacker
    tx, ty = target
    damage = CANNONS[ax][ay]['damage']
    CANNONS[tx][ty]['damage'] -= (damage//2 + damage%2)
    
    involved = [[False for _ in range(M)] for _ in range(N)]
    while (ax, ay) != (tx, ty):
        involved[tx][ty] = True
        CANNONS[tx][ty]['damage'] -= (damage//2)

        d = direction[tx][ty]
        dx, dy = DELTA[d]
        tx, ty = (tx-dx)%N, (ty-dy)%M
    
    involved[tx][ty] = True
    return involved

def shell_attack(attacker, target):
    ax, ay = attacker
    tx, ty = target
    damage = CANNONS[ax][ay]['damage']

    involved = [[False for _ in range(M)] for _ in range(N)]
    for x in range(tx-1, tx+2):
        for y in range(ty-1, ty+2):
            nx, ny = x%N, y%M
            if CANNONS[nx][ny]['damage'] <= 0:
                continue
            CANNONS[nx][ny]['damage'] -= (damage//2)
            involved[nx][ny] = True

    CANNONS[tx][ty]['damage'] -= (damage//2 + damage%2)
    CANNONS[ax][ay]['damage'] = damage
    involved[ax][ay] = True
    return involved

def attack(attacker, target, turn):
    ax, ay = attacker
    tx, ty = target

    CANNONS[ax][ay]['turn'] = turn
    CANNONS[ax][ay]['damage'] += (N+M)

    direction = get_direction(attacker)
    if direction[tx][ty] == -1:
        involved = shell_attack(attacker, target)
    else:
        involved = laser_attack(attacker, target, direction)
    
    repair(involved)

def repair(involved):
    for x in range(N):
        for y in range(M):
            if CANNONS[x][y]['damage'] > 0 and not involved[x][y]:
                    CANNONS[x][y]['damage'] += 1

def scenario():
    for turn in range(1, K + 1):
        attacker, target = choose_two()
        attack(attacker, target, turn)
    
    _, target = choose_two()
    tx, ty = target

    print(CANNONS[tx][ty]['damage'])

scenario()
