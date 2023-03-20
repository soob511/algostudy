N = int(input())
T = N-1
LTRD = [False for _ in range(2*N-1)]

board = [list(map(int,input().split())) for _ in range(N)]
MAX = [0, 0]

def bishop(XY, count, WB):
    if XY >= 2*N:
        MAX[WB] = max(MAX[WB], count)
        return

    X = XY if XY<T else T
    R = -abs(XY-T)+T+1
    for x in range(X, X-R, -1):
        y = XY-x
        if board[x][y] == 0: continue
        if LTRD[x-y+T]: continue

        LTRD[x-y+T] = True
        bishop(XY+2, count+1, WB)
        LTRD[x-y+T] = False
    
    bishop(XY+2, count, WB)

bishop(0,0,0)
bishop(1,0,1)

print(sum(MAX))
