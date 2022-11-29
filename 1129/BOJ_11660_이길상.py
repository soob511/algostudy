import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline
write = sys.stdout.write

N, M = map(int, input().split())

TABLE = [[0 for C in range(N+1)] for R in range(N+1)]
DP = [[0 for C in range(N+1)] for R in range(N+1)]

# 테이블 상태 입력받기
for r in range(N):
    line = list(map(int, input().split()))
    for c in range(N):
        TABLE[r+1][c+1] = line[c]

# 누적합 구하기
def totalsum(x, y):
    if x<0 or y<0:
        return 0
    if DP[x][y] > 0:
        return DP[x][y]
    else:
        DP[x][y] = TABLE[x][y] + totalsum(x, y-1) + totalsum(x-1, y) - totalsum(x-1, y-1)
        return DP[x][y]

totalsum(N, N)

# 누적합 더하고 빼서 범위 합 구하기
def rangesum(x1, y1, x2, y2):
    return DP[x2][y2] - DP[x2][y1-1]  - DP[x1-1][y2] + DP[x1-1][y1-1]


# M개 줄에 범위 입력
for m in range(M):
    x1, y1, x2, y2 = map(int, input().split())
    write(str(rangesum(x1, y1, x2, y2)) + "\n")
