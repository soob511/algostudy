D = ((-1,0), (0,1) , (1, 0), (0,-1))

N, M = map(int, input().split())

r, c, d = map(int, input().split())

room = [list(map(int, input().split())) for _ in range(N)]

cleaned = 0

while True:
    # 1
    if room[r][c] == 0:
        room[r][c] = 2
        cleaned += 1
    
    reachable = 0
    for dr, dc in D:
        nr = r + dr
        nc = c + dc

        if nr<0 or nc<0 or nr>=N or nc>=M:
            continue

        if room[nr][nc] == 0:
            reachable += 1
    
    #2
    if reachable  == 0:
        dr, dc = D[d]
        nr = r - dr
        nc = c - dc

        if nr>=0 and nc>=0 and nr<N and nc<M :
            if room[nr][nc] != 1:
                r = nr
                c = nc
            else:
                break
    
    #3
    else:
        d = (d+3)%4
        dr, dc = D[d]
        nr = r + dr
        nc = c + dc

        if nr>=0 and nc>=0 and nr<N and nc<M and room[nr][nc] == 0:
            r = nr
            c = nc

print(cleaned)
