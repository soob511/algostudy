FIELD = [[] for _ in range(6)]
DELTA = [[1,0],[-1,0],[0,1],[0,-1]]

for r in range(12):
    line = input()
    for c in range(6):
        FIELD[c].insert(0, line[c])

def chain(r, c, visited, pac):
    pac.append((r,c))
    for dr, dc in DELTA:
        nr = r + dr
        nc = c + dc
        if nr<0 or nr>=6 or nc<0 or nc>=len(FIELD[nr]): continue
        if visited[nr][nc]: continue
        if FIELD[nr][nc] != FIELD[r][c]: continue

        visited[nr][nc] = True
        chain(nr, nc, visited, pac)

count = 1
turn = -1
while count > 0:
    # 빈칸제거
    for r in range(6):
        filtered = []
        for e in FIELD[r]:
            if e != '.':
                filtered.append(e)
        FIELD[r] = filtered

    count = 0
    turn += 1
    visited = [[False for c in range(len(FIELD[r]))] for r in range(6)]

    # 연쇄
    for r in range(6):
        for c in range(len(FIELD[r])):
            if visited[r][c]:
                continue
            visited[r][c] = True
            pac = []
            chain(r, c, visited, pac)

            if len(pac) > 3:
                count += 1
                for x, y in pac:
                    FIELD[x][y] = '.'
    
print(turn)
