DELTA = ((1,0), (0,1), (-1,0), (0,-1));

# 입력 및 초기화
row, col = map(int, input().split())
field = [[ch for ch in input()] for _ in range(row)]

hedge = []
water = []
for r in range(row):
    for c in range(col):
        if field[r][c]=='S':
            hedge.append((r, c))
        elif field[r][c]=='D':
            dest = (r, c)
        elif field[r][c]=='*':
            water.append((r, c))

# 실행
time = 1
while hedge:
    # 홍수 확산
    temp = []
    for r, c in water:
        for dr, dc in DELTA:
            nr = r + dr
            nc = c + dc
            
            if nr<0 or nc<0 or nr>=row or nc>=col:
                continue
            if field[nr][nc] == 'X' or field[nr][nc] == 'D' or field[nr][nc] == '*':
                continue

            field[nr][nc] = '*'
            temp.append((nr,nc))
    water = temp

    # 비버 확산
    temp = []
    for r, c in hedge:
        for dr, dc in DELTA:
            nr = r + dr
            nc = c + dc
            
            if nr<0 or nc<0 or nr>=row or nc>=col:
                continue
            if field[nr][nc] == 'X' or field[nr][nc] == 'S' or field[nr][nc] == '*':
                continue
            
            # 목적지 도착
            if field[nr][nc] == 'D':
                print(time)
                exit(0)

            field[nr][nc] = 'S'
            temp.append((nr,nc))
    hedge = temp

    time += 1

# 실패
print('KAKTUS')
