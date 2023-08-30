DELTA = ((0,1), (0,-1), (1,0), (-1,0))

N, M, F = map(int, input().split())
FIELD = [list(map(int, input().split())) for _ in range(N)]
R, C = map(int, input().split())
PEOPLE = [list(map(lambda x: x-1, map(int, input().split()))) for _ in range(M)]


def distance(r, c):
    result = [[-1 for _ in range(N)] for _ in range(N)]
    queue = [(r,c)]
    result[r][c] = 0
    d = 1
    while queue:
        iter = len(queue)

        for i in range(iter):
            x, y = queue[i]
            for dx, dy in DELTA:
                nx, ny = x+dx, y+dy
                
                if nx<0 or ny<0 or nx>=N or ny>=N:
                    continue
                if result[nx][ny]!=-1 or FIELD[nx][ny] == 1:
                    continue
                result[nx][ny] = d
                queue.append((nx, ny))
        
        d += 1
        queue = queue[iter:]
    
    return result

def picker(people, r, c):
    dist_map = distance(r, c)
    idx = 0
    for i in range(len(people)):
        x, y, _, _ = people[i]
        ix, iy, _, _ = people[idx]
        if dist_map[x][y] < dist_map[ix][iy]:
            idx = i
        elif dist_map[x][y] == dist_map[ix][iy]:
            if x<ix:
                idx = i
            elif x==ix and y<iy:
                idx = i

    ix, iy, _, _ = people[idx]
    return people.pop(idx), dist_map[ix][iy]

def move(fuel, people, r, c):
    # 최단거리가 가장 짧은 승객 탐색
    person, cost = picker(people, r, c)
    x, y, tx, ty = person

    # 출발지까지 이동
    if cost > fuel or cost <0:
        return -1, -1, -1
    fuel -= cost

    # 목적지까지 이동
    dist_map = distance(x, y)
    cost = dist_map[tx][ty]
    if cost > fuel or cost <0:
        return -1, -1, -1
    fuel += cost

    return tx, ty, fuel

R, C = R-1, C-1
for i in range(M):
    R, C, F = move(F, PEOPLE, R, C)

    if F<0:
        break

print(F)
