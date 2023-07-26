D = ((0,-1), (1,0), (0,1), (-1,0))

N = int(input())
SAND = [list(map(int, input().split())) for _ in range(N)]

OUT = [0]

def add(r, c, sand):
    if r<0 or c<0 or r>=N or c>=N:
        OUT[0] += sand
    else:
        SAND[r][c] += sand


def spread(r, c, d):
    sand = origin = SAND[r][c]

    # 7
    amount = origin * 7 // 100
    add(r + D[(d+1)%4][0], c + D[(d+1)%4][1], amount)
    add(r + D[(d+3)%4][0], c + D[(d+3)%4][1], amount)
    sand -= amount*2

    # 2
    amount = origin * 2 // 100
    add(r + D[(d+1)%4][0]*2, c + D[(d+1)%4][1]*2, amount)
    add(r + D[(d+3)%4][0]*2, c + D[(d+3)%4][1]*2, amount)
    sand -= amount*2

    # 10
    amount = origin * 10 // 100
    add(r + D[(d+1)%4][0] + D[d][0], c + D[(d+1)%4][1] + D[d][1], amount)
    add(r + D[(d+3)%4][0] + D[d][0], c + D[(d+3)%4][1] + D[d][1], amount)
    sand -= amount*2

    # 1
    amount = origin * 1 // 100
    add(r + D[(d+1)%4][0] - D[d][0], c + D[(d+1)%4][1] - D[d][1], amount)
    add(r + D[(d+3)%4][0] - D[d][0], c + D[(d+3)%4][1] - D[d][1], amount)
    sand -= amount*2

    # 5
    amount = origin * 5 // 100
    add(r + D[d][0]*2, c + D[d][1]*2, amount)
    sand -= amount

    # a
    add(r + D[d][0], c + D[d][1], sand)


def tornado():
    r = c = N//2
    d = 0
    movable = N*N
    for i in range(1, N+1):
        for _ in range(2):
            for _ in range(i):
                r, c = r + D[d][0], c + D[d][1]
                movable -= 1

                if not movable:
                    pass
                    return
                
                spread(r, c, d)


            d += 1
            d %= 4


tornado()

print(OUT[0])
