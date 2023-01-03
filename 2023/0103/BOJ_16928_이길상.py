import sys
sys.setrecursionlimit(100000)
input = sys.stdin.readline
write = sys.stdout.write

from queue import Queue

# 데이터 선언
BOARD = [-1 for _ in range(101)]
LADDER = dict()
SNAKE = dict()

# N, M 입력
N, M = map(int, input().split())

# 사다리 입력
for n in range(N):
    X, Y = map(int, input().split())
    LADDER[X] = Y
# 뱀 입력
for m in range(M):
    U, V = map(int, input().split())
    SNAKE[U] = V


# BFS 응용
BOARD[1] = 0
POINTS = Queue()
POINTS.put(1)
while not POINTS.empty():
    p = POINTS.get()
    for move in range(1, 7):
        target = p+move
        if target > 100: continue
        if target in SNAKE: target = SNAKE[target]
        if target in LADDER: target = LADDER[target]
        if BOARD[target] < 0 or BOARD[target] > BOARD[p]+1:
            BOARD[target] = BOARD[p]+1
            POINTS.put(target)


print(BOARD[100])
