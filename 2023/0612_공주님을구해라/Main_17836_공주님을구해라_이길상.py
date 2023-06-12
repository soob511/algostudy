from queue import Queue

DELTA = ((0,1), (1,0), (0,-1), (-1,0))
N, M, T = map(int, input().split())
FIELD = [list(map(int, input().split())) for _ in range(N)]
D = [[[-1,-1] for _ in range(M)] for _ in range(N)]

D[0][0] == 0
Q = Queue()
Q.put((0,0,0,0))

while not Q.empty():
    x, y, t, g = Q.get()

    if t>T:
        continue
    
    if FIELD[x][y] == 2:
        g = 1
        
    for dx, dy in DELTA:
        nx = x+dx
        ny = y+dy
        
        # 범위 벗어남
        if nx<0 or ny<0 or nx>=N or ny>=M:
            continue
        # 검 없음
        if g==0:
            # 검 없이 못가는 곳
            if FIELD[nx][ny] == 1:
                continue
            # 가본 곳
            if D[nx][ny][0] != -1:
                continue
        # 검이 있는 상태로 가봣던 곳
        if g==1 and D[nx][ny][1] != -1:
            continue

        if D[nx][ny][0] == -1 or D[nx][ny][0]>t+1:
            D[nx][ny][0] = t+1
        if g==1 and D[nx][ny][1] == -1:
            D[nx][ny][1] = t+1
        
        Q.put((nx, ny, t+1, g))

result = D[-1][-1][0]
if result == -1:
    print("Fail")
    
else:
    print(result)
        
        
    
