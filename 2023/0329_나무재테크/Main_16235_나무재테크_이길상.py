N, M, K = map(int, input().split())

TREE = [[[] for _ in range(N)] for _ in range(N)]
LAND = [[5 for _ in range(N)] for _ in range(N)]
A = [list(map(int, input().split())) for _ in range(N)]

for _ in range(M):
    x, y, z = map(int, input().split())

    TREE[x-1][y-1].append(z)
    TREE[x-1][y-1].sort()



for _ in range(K):
    # 봄
    dead_tree = []
    for x in range(N):
        for y in range(N):
            for i in range(len(TREE[x][y])):
                if TREE[x][y][i] <= LAND[x][y]:
                    LAND[x][y] -= TREE[x][y][i]
                    TREE[x][y][i] += 1
                else:
                    # 여름
                    for j in range(i, len(TREE[x][y])):
                        LAND[x][y] += TREE[x][y].pop() // 2
                    break

    # 가을
    pass
    new_tree = [[0 for _ in range(N)] for _ in range(N)]
    for x in range(N):
        for y in range(N):
            for v in TREE[x][y]:
                if v%5 == 0:
                    for r in range(x-1, x+2):
                        for c in range(y-1, y+2):
                            if r<0 or c<0 or r>=N or c>=N:
                                continue
                            if r==x and c==y:
                                continue
                            TREE[r][c].insert(0, 1)
            LAND[x][y] += A[x][y]

print(sum([sum([len(TREE[x][y]) for y in range(N)]) for x in range(N)]))
