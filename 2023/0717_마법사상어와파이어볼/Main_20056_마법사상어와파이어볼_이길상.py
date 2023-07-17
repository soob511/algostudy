DELTA = ((-1,0), (-1,1), (0,1), (1,1), (1,0), (1,-1), (0,-1), (-1,-1))

N, M, K = map(int, input().split())
FIREBALLS = [list(map(int, input().split())) for _ in range(M)]

for _ in range (K):
    # move
    grid = [[[] for _ in range(N)] for _ in range(N)]
    for r, c, m, s, d in FIREBALLS:
        nr = (r + DELTA[d][0]*s)%N
        nc = (c + DELTA[d][1]*s)%N
        grid[nr][nc].append((m,s,d))

    #split
    FIREBALLS = []
    for r in range(N):
        for c in range(N):
            e = grid[r][c]
            if len(e)==1:
                m, s, d = e[0]
                FIREBALLS.append((r, c, m, s, d))
            elif len(e) > 1:
                dd, mm, ss = 0, 0, 0
                for m, s, d in e:
                    mm += m
                    ss += s
                    dd += d%2

                if dd == 0 or dd==len(e):
                    dd = 0
                else:
                    dd = 1
                
                mm //= 5
                ss //= len(e)

                if mm > 0:
                    for d in range(dd, dd+7, 2):
                        FIREBALLS.append((r, c, mm, ss, d))
    

answer = 0
for r, c, m, s, d in FIREBALLS:
    answer += m

print(answer)
                
